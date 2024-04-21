package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.CertDto;
import org.group.portfolio.Entities.Certification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Vector;

public interface CertService {
    public Certification SaveCert(CertDto certDto);
    public Certification UpdateCert(String id, CertDto certDto);
    public Certification GetCert(String id, CertDto certDto);
    public Certification DeleteCert(String id, CertDto certDto);
    public Vector<Certification> GetAllCerts(CertDto certDto);
}
