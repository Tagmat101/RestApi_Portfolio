package org.group.portfolio.Respository;

import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.Project;
import org.group.portfolio.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectRepository  extends MongoRepository<Project,String> {
    List<Project> findAllByUser(User user);
}
