package org.group.portfolio.Respository;

import org.group.portfolio.Entities.Project;
import org.group.portfolio.Entities.Skill;
import org.group.portfolio.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SkillRepository extends MongoRepository<Skill,String> {
    List<Skill> findAllByUser(User user);
    void deleteById(String Id);
}
