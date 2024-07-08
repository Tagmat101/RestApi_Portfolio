package org.group.portfolio.Respository;

import org.group.portfolio.Entities.CategoriePort;
import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PortfolioRepository extends MongoRepository<Portfolio, String> {
    @Query(fields = "{ 'name': 1, 'color': 1, 'categorie': 1, 'visible': 1 }")
    List<Portfolio> findAllByUser(User user);

    List<Portfolio> findAllByCategorie(CategoriePort categoriePort);

    long countPortfoliosByUser(User user);
}