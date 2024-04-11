package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.PortfolioDto;
import org.group.portfolio.Entities.Portfolio;

import java.util.List;

public interface PortfolioService {
    public Portfolio savePortfolio(PortfolioDto portfolioDto,String token);
    public Portfolio GetPortfolioById(String id);
    public Portfolio UpdatePortfolio(String id,PortfolioDto portfolioDto,String token);
    public  void DeletePortfolio(String id);
    public List<Portfolio> GetAllByUser(String token);
}
