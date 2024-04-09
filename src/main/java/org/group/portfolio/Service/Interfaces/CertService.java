package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.CertDto;
import org.group.portfolio.Entities.Certification;
import org.group.portfolio.Service.Enum.CertCategory;
import org.springframework.context.annotation.Bean;
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
    public Vector<Certification> GetCertsByCategory(CertCategory category);
    public Vector<Certification> GetCertsByUser(String userId);
    public Vector<Certification> GetCertsByInstitution(String institution);
    public Vector<Certification> GetCertsByDate(Date date);
    public Vector<Certification> GetCertsByDateRange(Date startDate, Date endDate);
    public Vector<Certification> GetCertsByTitle(String title);
    public Vector<Certification> GetCertsByDescription(String description);
    public Vector<Certification> GetCertsByCategoryAndUser(CertCategory category, String userId);
    public Vector<Certification> GetCertsByCategoryAndInstitution(CertCategory category, String institution);
    public Vector<Certification> GetCertsByCategoryAndDate(CertCategory category, Date date);
    public Vector<Certification> GetCertsByCategoryAndDateRange(CertCategory category, Date startDate, Date endDate);
    public Vector<Certification> GetCertsByCategoryAndTitle(CertCategory category, String title);
    public Vector<Certification> GetCertsByCategoryAndDescription(CertCategory category, String description);
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
