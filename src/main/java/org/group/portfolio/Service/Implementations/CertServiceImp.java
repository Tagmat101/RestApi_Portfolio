package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.CertDto;
import org.group.portfolio.Entities.Certification;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.CertRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CertServiceImp {
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private CertRepository certRepository;

    public Certification SaveCert(CertDto certDto) {
        Certification cert = modelMapper.map(certDto, Certification.class);

        return certRepository.save(cert);
    }

    public Certification UpdateCert(String id, CertDto certDto) {
        Certification cert = certRepository.findById(id).orElse(null);
        if(cert == null) throw new AppException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        cert.setName(certDto.getName());
        cert.setCategory(certDto.getCategory());
        cert.setUrl_cert(certDto.getUrl_cert());
        cert.setOrganization(certDto.getOrganization());
        cert.setCategory(certDto.getCategory());
        cert.setDate(certDto.getDate());
        certRepository.save(cert);
        return cert;
    }
}
