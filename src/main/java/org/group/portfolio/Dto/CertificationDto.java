package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group.portfolio.Entities.User;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificationDto {
    private String name;
    private String organization;
    private Date startDate;
    private Date endDate;
    private String url_cert;
    User user;


}
