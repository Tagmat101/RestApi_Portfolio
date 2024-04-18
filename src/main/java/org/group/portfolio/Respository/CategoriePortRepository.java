package org.group.portfolio.Respository;

import org.group.portfolio.Entities.CategoriePort;
import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriePortRepository extends MongoRepository<CategoriePort,String> {
    public List<CategoriePort> getByUser(User user);
    public List<CategoriePort> getByUserAndStateIsTrue(User user);
}
