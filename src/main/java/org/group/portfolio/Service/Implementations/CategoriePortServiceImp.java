package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.CategoriePortDto;
import org.group.portfolio.Entities.CategoriePort;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.CategoriePortRepository;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.Interfaces.CategoriePortService;
import org.group.portfolio.Utils.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriePortServiceImp implements CategoriePortService {
    @Autowired
    CategoriePortRepository categoriePortRepository;
    @Autowired
    UserRepository userRepository;
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
}
