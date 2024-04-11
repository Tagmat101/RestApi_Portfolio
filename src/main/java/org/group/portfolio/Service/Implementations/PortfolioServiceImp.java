package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.PortfolioDto;
import org.group.portfolio.Entities.*;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.*;
import org.group.portfolio.Service.Interfaces.PortfolioService;
import org.group.portfolio.Utils.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PortfolioServiceImp implements PortfolioService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    JwtUtil jwtUtil;
    @Override
    public Portfolio savePortfolio(PortfolioDto portfolioDto,String token) {
        //just for test (educations and experiences)....
        //for educations
        List<Education> educations = portfolioDto.getEducations().stream()
                .map(dto -> modelMapper.map(dto, Education.class))
                .collect(Collectors.toList());
        //for Experiences
        List<Experience> experiences = portfolioDto.getExperiences().stream()
                        .map(dto -> modelMapper.map(dto,Experience.class))
                        .collect(Collectors.toList());
        Portfolio portfolio = modelMapper.map(portfolioDto,Portfolio.class);
        portfolio.setEducations(educations);
        portfolio.setExperiences(experiences);
        // throw it to cache getting old cache and postincrement it with the one here:
        //provide the token from frontend no need from decoding there:
        String id = jwtUtil.getIdFromToken(token);
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
       if(user.getEducationsCache() != null && user.getExperiencesCache() != null)
       {
           user.getEducationsCache().addAll(educations);
           user.getExperiencesCache().addAll(experiences);
       } else
       {
           user.setEducationsCache(educations);
           user.setExperiencesCache(experiences);
       }
        portfolio.setUser(user);
        userRepository.save(user);
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio GetPortfolioById(String id) {

        return portfolioRepository.findById(id).orElseThrow(()
                ->  new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
    }

    @Override
    public Portfolio UpdatePortfolio(String id,PortfolioDto portfolioDto,String token) {
        System.out.println(portfolioDto);
        String idUser = jwtUtil.getIdFromToken(token);
        User user = userRepository.findById(idUser).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow
                (() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        System.out.println(portfolioDto.getUser());
        portfolioDto.setUser(user);
        modelMapper.map(portfolioDto,portfolio);
        return portfolioRepository.save(portfolio);
    }

    @Override
    public void DeletePortfolio(String id) {
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow
                (() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        portfolioRepository.delete(portfolio);
    }
    @Override
    public List<Portfolio> GetAllByUser(String token)
    {
        String id = jwtUtil.getIdFromToken(token);
        User user = userRepository.findById(id).orElseThrow
                (() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        return portfolioRepository.findAllByUser(user);
    }
}
