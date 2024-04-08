package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.ExperienceDto;
import org.group.portfolio.Entities.Experience;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Implementations.ExperienceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceWs {
    @Autowired
    private ExperienceServiceImp experienceService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Experience>> createEducation(@RequestBody ExperienceDto experienceDto) {
        Experience save = experienceService.Create(experienceDto);
        ApiResponse<Experience> response = new ApiResponse<>(200, "Experience Created successfully", save);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ApiResponse<Experience>> getUserById(@PathVariable("id") String id) {

        Experience experience = experienceService.GetById(id);
        ApiResponse<Experience> response = new ApiResponse<>(200, "Experience found successfully", experience);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Experience>>>  getAllEducations() {
        List<Experience> eduList = experienceService.GetAll();
        ApiResponse< List<Experience>> response = new ApiResponse<>(200, "Experience List", eduList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Experience>> updateEducation(@PathVariable("id") String id, @RequestBody ExperienceDto updatedEducationDto) {
        Experience experience = experienceService.Update(id,updatedEducationDto);
        ApiResponse<Experience> response = new ApiResponse<>(200, "Experience updated successfully", experience);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEducation(@PathVariable("id") String id) {
        System.out.println("Deleting experience record " + id);
        String deletedID = experienceService.Delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Experience deleted successfully", deletedID));
    }
}
