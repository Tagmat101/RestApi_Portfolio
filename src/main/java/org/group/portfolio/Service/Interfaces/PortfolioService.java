package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.PortfolioDto;
import org.group.portfolio.Entities.Portfolio;

public interface PortfolioService {
    public Portfolio savePortfolio(PortfolioDto portfolioDto);
    public Portfolio GetPortfolioById(String id);
    public Portfolio UpdatePortfolio(String id,PortfolioDto portfolioDto);
}
