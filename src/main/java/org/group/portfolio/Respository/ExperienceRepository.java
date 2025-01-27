package org.group.portfolio.Respository;

import org.group.portfolio.Entities.Experience;
import org.group.portfolio.Entities.Skill;
import org.group.portfolio.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends MongoRepository<Experience,String> {
    List<Experience> findAllByUser(User user);

}
