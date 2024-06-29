package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.CertificationDto;
import org.group.portfolio.Entities.Certification;
import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.CertificationRepository;
import org.group.portfolio.Respository.PortfolioRepository;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.Interfaces.CertificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CertificationServiceImp implements CertificationService {
    @Autowired
    private CertificationRepository CertificationRepository;
    @Autowired
    private PortfolioRepository portfolioRepository;
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private UserRepository userRepository;
    @Override
    public Certification Create(CertificationDto CertificationDto, String id) {
        if (CertificationDto == null) {
            throw new IllegalArgumentException("CertificationDto must not be null");
        }
        Certification Certification = modelMapper.map(CertificationDto, Certification.class);
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
        Certification.setUser(user);
        if (Certification == null) {
            throw new AppException("Mapping from CertificationDto to Certification failed");
        }
        System.out.print(Certification);
        return CertificationRepository.save(Certification);
    }

    public Certification GetById(String id) {
        // Retrieve Certification from the database
        return CertificationRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
    }
    public List<Certification> GetAll() {
        return CertificationRepository.findAll();
    }

    @Override
    public Certification Update(String id, CertificationDto CertificationDto) {
        Certification Certification = CertificationRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));

        // Update Certification object with fields from CertificationDto
        modelMapper.map(CertificationDto, Certification);

        return CertificationRepository.save(Certification);
    }


    @Override
    public String Delete(String id) {
        if (CertificationRepository.existsById(id)) {
            //deletin its corresponding portfolios :
            List<Portfolio> portfolios = portfolioRepository.findAll();
//            for(Portfolio portfolio : portfolios)
//            {
//                List<Certification> Certifications = portfolio.getCertifications();
//                Certifications.removeIf(Certification -> Certification.getId().equals(id));
//
//                portfolioRepository.save(portfolio);
//            }

            CertificationRepository.deleteById(id);
            return id;
        } else {
            throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
    }

    @Override
    public List<Certification> GetAllByUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));

        return CertificationRepository.findAllByUser(user);
    }
}
