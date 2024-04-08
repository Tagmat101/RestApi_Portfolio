package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.EducationDto;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Implementations.EducationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationWs {
    @Autowired
    private EducationServiceImp educationService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Education>> createEducation(@RequestBody EducationDto educationDto) {
        Education save = educationService.Create(educationDto);
        ApiResponse<Education> response = new ApiResponse<>(200, "Education Created successfully", save);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ApiResponse<Education>> getUserById(@PathVariable("id") String id) {

        Education education = educationService.GetById(id);
        ApiResponse<Education> response = new ApiResponse<>(200, "Education found successfully", education);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Education>>>  getAllEducations() {
        List<Education> eduList = educationService.GetAll();
        ApiResponse< List<Education>> response = new ApiResponse<>(200, "Education List", eduList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Education>> updateEducation(@PathVariable("id") String id, @RequestBody EducationDto updatedEducationDto) {
        Education education = educationService.Update(id,updatedEducationDto);
        ApiResponse<Education> response = new ApiResponse<>(200, "Education updated successfully", education);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEducation(@PathVariable("id") String id) {
        System.out.println("Deleting education record " + id);
        String deletedID = educationService.Delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Education deleted successfully", deletedID));
    }
}
