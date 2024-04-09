package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Entities.Experience;
import org.group.portfolio.Entities.Project;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Implementations.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectWs {
    @Autowired
    private ProjectServiceImp projectService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Project>> createEducation(@RequestBody ProjectDto projectDto) {
        Project save = projectService.Create(projectDto);
        ApiResponse<Project> response = new ApiResponse<>(200, "Project Created successfully", save);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ApiResponse<Project>> getUserById(@PathVariable("id") String id) {

        Project experience = projectService.GetById(id);
        ApiResponse<Project> response = new ApiResponse<>(200, "Project found successfully", experience);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Project>>>  getAllEducations() {
        List<Project> eduList = projectService.GetAll();
        ApiResponse< List<Project>> response = new ApiResponse<>(200, "Project List", eduList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Project>> updateEducation(@PathVariable("id") String id, @RequestBody ProjectDto updatedEducationDto) {
        Project experience = projectService.Update(id,updatedEducationDto);
        ApiResponse<Project> response = new ApiResponse<>(200, "Project updated successfully", experience);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEducation(@PathVariable("id") String id) {
        System.out.println("Deleting experience record " + id);
        String deletedID = projectService.Delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Project deleted successfully", deletedID));
    }

}
