package org.group.portfolio.Service.Interfaces;

import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Dto.SkillDto;
import org.group.portfolio.Entities.Project;
import org.group.portfolio.Entities.Skill;

import java.util.List;

public interface SkillService {
    public Skill GetById(String id);
    public Skill Create(SkillDto SkillDto, String idUser);
    public Skill Update(String idSkill, SkillDto SkillDto);
    public String Delete(String idSkill);
    public List<Skill> GetAllByUser(String idUser);
    public long GetAllCountSkills(String idUser);
}