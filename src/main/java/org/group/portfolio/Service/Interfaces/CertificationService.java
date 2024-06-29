package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.CertificationDto;
import org.group.portfolio.Dto.EducationDto;
import org.group.portfolio.Entities.Certification;
import org.group.portfolio.Entities.Education;

import java.util.List;

public interface CertificationService {
    public Certification GetById(String id);
    public Certification Create(CertificationDto certificationDto, String id);
    public Certification Update(String id,CertificationDto certificationDto);
    public String Delete(String id);
    public List<Certification> GetAllByUser(String id);
}
