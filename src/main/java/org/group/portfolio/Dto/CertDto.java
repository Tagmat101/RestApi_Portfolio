package org.group.portfolio.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group.portfolio.Service.Enum.CertCategory;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Vector;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertDto {
    private String name;
    private String organization;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private String url_cert;
    private Vector<CertCategory> category = new Vector<CertCategory>();


}
