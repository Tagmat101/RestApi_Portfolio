package org.group.portfolio.Respository;

import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PortfolioRepository extends MongoRepository<Portfolio,String> {
    public List<Portfolio> findAllByUser(User user);
}
