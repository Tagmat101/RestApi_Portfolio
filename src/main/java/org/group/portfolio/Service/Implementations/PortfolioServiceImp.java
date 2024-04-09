package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.PortfolioDto;
import org.group.portfolio.Entities.*;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.*;
import org.group.portfolio.Service.Interfaces.PortfolioService;
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

    @Override
    public Portfolio savePortfolio(PortfolioDto portfolioDto) {
        //for educations
        List<Education> educations = portfolioDto.getEducations().stream()
                .map(dto -> modelMapper.map(dto, Education.class))
                .collect(Collectors.toList());
        //for Experiences
        List<Experience> experiences = portfolioDto.getExperiences().stream()
                        .map(dto -> modelMapper.map(dto,Experience.class))
                        .collect(Collectors.toList());
        educationRepository.saveAll(educations);
        experienceRepository.saveAll(experiences);
        Portfolio portfolio = modelMapper.map(portfolioDto,Portfolio.class);
        portfolio.setEducations(educations);
        portfolio.setExperiences(experiences);

        // throw it to cache getting old cache and postincrement it with the one here:
        User user = userRepository.findById(portfolioDto.getUser().getId()).orElseThrow(() ->
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

        userRepository.save(user);
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio GetPortfolioById(String id) {

        return portfolioRepository.findById(id).orElseThrow(()
                ->  new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
    }

    @Override
    public Portfolio UpdatePortfolio(String id,PortfolioDto portfolioDto) {
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow
                (() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        modelMapper.map(portfolioDto,portfolio);
        return portfolioRepository.save(portfolio);
    }
}
