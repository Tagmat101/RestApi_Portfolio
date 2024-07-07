package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.CategoriePortDto;
import org.group.portfolio.Entities.CategoriePort;

import java.util.List;

public interface CategoriePortService  {
    public CategoriePort Create(CategoriePortDto categoriePortDto,String token);
    public List<CategoriePort> GetAllByUser(String id);
    public List<CategoriePort> GetAllByUserActive(String id);
    public CategoriePort Update(CategoriePortDto categoriePortDto,String token);
    public void Delete(String id);
    public long GetCountByUser(String idUser);
}
