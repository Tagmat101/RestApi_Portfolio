package org.group.portfolio.Respository;

import org.group.portfolio.Entities.Portfolio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortfolioRepository extends MongoRepository<Portfolio,String> {
}
