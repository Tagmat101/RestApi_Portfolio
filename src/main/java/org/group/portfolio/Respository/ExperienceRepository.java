package org.group.portfolio.Respository;

import org.group.portfolio.Entities.Experience;
import org.group.portfolio.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends MongoRepository<Experience,String> {

}
