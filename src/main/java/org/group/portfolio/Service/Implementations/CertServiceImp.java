package org.group.portfolio.Service.Implementations;

import org.group.portfolio.Dto.CertDto;
import org.group.portfolio.Entities.Certification;
import org.group.portfolio.Exceptions.AppException;
import org.group.portfolio.Response.ErrorMessages;
import org.group.portfolio.Respository.CertRepository;
import org.group.portfolio.Service.Interfaces.CertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Vector;

@Service
public class CertServiceImp implements CertService {
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
        cert.setDate(certDto.getIssue_date());
        cert.setUrl_cert(certDto.getUrl_cert());
        cert.setOrganization(certDto.getOrganization());
        cert.setDate(certDto.getEnd_data());
        certRepository.save(cert);
        return cert;
    }

    @Override
    public Certification GetCert(String id, CertDto certDto) {
        return null;
    }

    @Override
    public Certification DeleteCert(String id, CertDto certDto) {
        return null;
    }

    @Override
    public Vector<Certification> GetAllCerts(CertDto certDto) {
        return null;
    }
}
