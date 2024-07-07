package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Dto.SkillDto;
import org.group.portfolio.Entities.Project;
import org.group.portfolio.Entities.Skill;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Implementations.ProjectServiceImp;
import org.group.portfolio.Service.Implementations.SkillServiceImp;
import org.group.portfolio.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillWs {
    @Autowired
    private SkillServiceImp skillService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Skill>> createSkill(@RequestBody SkillDto skillDto, @RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<Skill> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        String idUser = jwtUtil.getIdFromToken(token);
        Skill save = skillService.Create(skillDto,idUser);
        ApiResponse<Skill> response = new ApiResponse<>(200, "skill Created successfully", save);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ApiResponse<Skill>> getUserById(@PathVariable("id") String id,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<Skill> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        Skill skill = skillService.GetById(id);
        ApiResponse<Skill> response = new ApiResponse<>(200, "Skill found successfully", skill);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Skill>>>  getAllSkillsByUser(@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<List<Skill>> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        String id = jwtUtil.getIdFromToken(token);
        List<Skill> skillList = skillService.GetAllByUser(id);
        ApiResponse<List<Skill>> response = new ApiResponse<>(200, "Skill List", skillList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Skill>> updateSkill(@PathVariable("id") String id, @RequestBody SkillDto updatedSkillDto,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<Skill> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        Skill skill = skillService.Update(id,updatedSkillDto);
        ApiResponse<Skill> response = new ApiResponse<>(200, "Skill updated successfully", skill);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteSkill(@PathVariable("id") String id,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<String> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        System.out.println("Deleting skill record " + id);
        String deletedID = skillService.Delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "skill deleted successfully", deletedID));
    }
    @GetMapping("/all/count")
    public ResponseEntity<ApiResponse<Long>> GetCountSkills(@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<Long> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        String id = jwtUtil.getIdFromToken(token);
        long countSkills = skillService.GetAllCountSkills(id);
        System.out.println("Count skills  :" + countSkills);
        return ResponseEntity.ok(new ApiResponse<>(200, "Skills Count", countSkills));
    }

}
