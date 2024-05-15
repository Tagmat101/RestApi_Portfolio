package org.group.portfolio.Respository;

import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.group.portfolio.Entities.Certification;

import java.util.List;

@Repository

public interface CertificationRepository extends MongoRepository<Certification, String>{
    List<Certification> findAllByUser(User user);
}
