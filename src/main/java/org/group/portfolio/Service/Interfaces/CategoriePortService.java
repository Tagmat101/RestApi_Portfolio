package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.CategoriePortDto;
import org.group.portfolio.Entities.CategoriePort;

import java.util.List;

public interface CategoriePortService  {
    public CategoriePort Create(CategoriePortDto categoriePortDto,String token);
    public List<CategoriePort> GetAllByUser(String id);
}
