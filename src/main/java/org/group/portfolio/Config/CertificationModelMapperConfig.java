package org.group.portfolio.Config;
import org.group.portfolio.Dto.CertDto;
import org.group.portfolio.Entities.Certification;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class CertificationModelMapperConfig {
    @Bean
    public ModelMapper certModelMapper() {
        ModelMapper certModelMapper = new ModelMapper();
        // Add mappings for Certification and CertDto
        certModelMapper.createTypeMap(Certification.class, CertDto.class)
                .addMapping(Certification::getName, CertDto::setName)
                .addMapping(Certification::getDate, CertDto::setIssue_date)
                .addMapping(Certification::getOrganization, CertDto::setOrganization)
                .addMapping(Certification::getUrl_cert, CertDto::setUrl_cert)
                .addMapping(Certification::getDate, CertDto::setEnd_data);
        return certModelMapper;
    }
}