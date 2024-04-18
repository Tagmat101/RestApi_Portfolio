package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Vector;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertDto {
    private String name;
    private String organization;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String issue_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String end_data;
    private String url_cert;



}
