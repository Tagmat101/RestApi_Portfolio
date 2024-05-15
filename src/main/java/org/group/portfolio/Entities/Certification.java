package org.group.portfolio.Entities;

//importing libraries
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Vector;

@Document(collection = "Certification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Certification {
    @Id
    private String id;
    private String name;
    private String organization;
    private String date;
    @Indexed(unique = true)
    private String url_cert;
    @DBRef
    private User user;
}
