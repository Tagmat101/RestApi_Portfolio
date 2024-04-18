package org.group.portfolio.Respository;

import org.group.portfolio.Entities.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository  extends MongoRepository<Project,String> {
}
