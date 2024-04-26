package org.group.portfolio.Respository;

import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends MongoRepository<Education,String> {
    List<Education> findAllByUser(User user);
}
