package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.CategoriePortDto;
import org.group.portfolio.Entities.CategoriePort;
import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.CategoriePortRepository;
import org.group.portfolio.Respository.PortfolioRepository;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.Interfaces.CategoriePortService;
import org.group.portfolio.Utils.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriePortServiceImp implements CategoriePortService {
    @Autowired
    CategoriePortRepository categoriePortRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PortfolioRepository portfolioRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    JwtUtil jwtUtil;
    @Override
    public CategoriePort Create(CategoriePortDto categoriePortDto,String token) {
        CategoriePort categoriePort = modelMapper.map(categoriePortDto,CategoriePort.class);
        String id = jwtUtil.getIdFromToken(token);
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        categoriePort.setUser(user);
        return categoriePortRepository.save(categoriePort);
    }
    public List<CategoriePort> GetAllByUser(String id)
    {
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        return categoriePortRepository.getByUser(user);
    }
    public List<CategoriePort> GetAllByUserActive(String id)
    {
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        return categoriePortRepository.getByUserAndStateIsTrue(user);
    }
    public CategoriePort Update(CategoriePortDto categoriePortDto,String token)
    {
        System.out.println("Updating categorie : " + categoriePortDto);
        CategoriePort categoriePort = categoriePortRepository.findById(categoriePortDto.getId()).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        if(categoriePort.isState() != categoriePortDto.isState())
        {
            if(!categoriePortDto.isState() && categoriePort.isState())
            {
                List<Portfolio> portfolios = portfolioRepository.findAllByCategorie(categoriePort);
                System.out.println(portfolios);
                if(!portfolios.isEmpty())
                   throw new AppException("Can't turn off this category already in use");
            }
        }
        modelMapper.map(categoriePortDto, categoriePort);

        String id = jwtUtil.getIdFromToken(token);
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        categoriePort.setUser(user);

        return categoriePortRepository.save(categoriePort);
    }
    public void Delete(String id)
    {
        CategoriePort categoriePort = categoriePortRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        //see if this category is not related to a portfolio :
        List<Portfolio> portfolios = portfolioRepository.findAllByCategorie(categoriePort);
        System.out.println(portfolios);
        if(portfolios.isEmpty())
            categoriePortRepository.delete(categoriePort);
        else throw new AppException("Can't delete this category it is related");
    }
}
