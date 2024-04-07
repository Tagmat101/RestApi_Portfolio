package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.EducationDto;
import org.group.portfolio.Dto.UserDto;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Respository.UserRepository;
import org.group.portfolio.Service.EducationService;
import org.group.portfolio.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationWs {
    @Autowired
    private EducationService educationService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEducation(@RequestBody EducationDto educationDto) {
        System.out.println(educationDto.getId());
        System.out.println("");
        return educationService.createEducation(educationDto);
    }

    @GetMapping("/{id}")
    public EducationDto getUserById(@PathVariable("id") String id) {
        return educationService.getEducationById(id);
    }

    @GetMapping("/all")
    public List<EducationDto> getAllEducations() {
        return educationService.getAllEducation();
    }

    @PutMapping("/{id}")
    public String updateEducation(@PathVariable("id") String id, @RequestBody EducationDto updatedEducationDto) {
        System.out.println("Updating education record");
        return educationService.updateEducation(id, updatedEducationDto);
    }

    @DeleteMapping("/{id}")
    public String deleteEducation(@PathVariable("id") String id) {
        System.out.println("Deleting education record"+id);
        return educationService.deleteEducation(id);
    }
}
