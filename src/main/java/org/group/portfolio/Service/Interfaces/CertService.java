package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.CertDto;
import org.group.portfolio.Entities.Certification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Vector;
@Service

public interface CertService {
    public Certification SaveCert(CertDto certDto);
    public Certification UpdateCert(String id, CertDto certDto);
    public Certification GetCert(String id, CertDto certDto);
    public Certification DeleteCert(String id, CertDto certDto);
    public Vector<Certification> GetAllCerts(CertDto certDto);

    public Vector<Certification> GetCertsByUser(String userId);
    public Vector<Certification> GetCertsByInstitution(String organization);
    public Vector<Certification> GetCertsByDate(Date date);
    public Vector<Certification> GetCertsByDateRange(Date startDate, Date endDate);
    public Vector<Certification> GetCertsByTitle(String title);
    public Vector<Certification> GetCertsByDescription(String description);
    public Vector<Certification> GetCertsByUserAndInstitution(String userId, String institution);
    public Vector<Certification> GetCertsByUserAndDate(String userId, Date date);
    public Vector<Certification> GetCertsByUserAndDateRange(String userId, Date startDate, Date endDate);
    public Vector<Certification> GetCertsByUserAndTitle(String userId, String title);
    public Vector<Certification> GetCertsByUserAndDescription(String userId, String description);
    public Vector<Certification> GetCertsByInstitutionAndDate(String institution, Date date);
    public Vector<Certification> GetCertsByInstitutionAndDateRange(String institution, Date startDate, Date endDate);
    public Vector<Certification> GetCertsByInstitutionAndTitle(String institution, String title);
    public Vector<Certification> GetCertsByInstitutionAndDescription(String institution, String description);
    }
