package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.ProjectDto;
import org.group.portfolio.Entities.Experience;
import org.group.portfolio.Entities.Project;
import org.group.portfolio.Entities.User;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Implementations.ProjectServiceImp;
import org.group.portfolio.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectWs {
    @Autowired
    private ProjectServiceImp projectService;
    @Autowired
    JwtUtil jwtUtil;

    public List<byte[]> uploadImage(MultipartFile[] images) throws IOException {
        List<byte[]> projectImages =new ArrayList<>();
        for (MultipartFile image:images){
            projectImages.add(image.getBytes());
        }
        System.out.println(projectImages);

        return projectImages;
    }
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<String>> createProject(@RequestPart("project") ProjectDto projectDto,
                                                              @RequestPart("images") MultipartFile[] images,
                                                              @RequestHeader("Authorization") String token) {
        // Input validation
        if (projectDto == null) {
            ApiResponse<String> badRequestResponse = new ApiResponse<>(400, "Bad Request", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestResponse);
        }

        // Authorization validation
        if (!jwtUtil.validateToken(token)) {
            ApiResponse<String> unauthorizedResponse = new ApiResponse<>(401, "Unauthorized", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(unauthorizedResponse);
        }

        try {
            String id = jwtUtil.getIdFromToken(token);
            projectDto.setImages(uploadImage(images));
            Project save = projectService.Create(projectDto, id);

            ApiResponse<String> response = new ApiResponse<>(200, "Project Created successfully", save.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle exceptions appropriately
            ApiResponse<String> errorResponse = new ApiResponse<>(500, "Internal Server Error", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<ApiResponse<Project>> getUserById(@PathVariable("id") String id,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<Project> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        Project experience = projectService.GetById(id);
        ApiResponse<Project> response = new ApiResponse<>(200, "Project found successfully", experience);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Project>>>  getAllProjectsByUser(@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<List<Project>> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        String id = jwtUtil.getIdFromToken(token);
        List<Project> eduList = projectService.GetAllByUser(id);
        ApiResponse< List<Project>> response = new ApiResponse<>(200, "Project List", eduList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Project>> updateProject(@PathVariable("id") String id, @RequestBody ProjectDto updatedProjectDto,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<Project> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        Project experience = projectService.Update(id,updatedProjectDto);
        ApiResponse<Project> response = new ApiResponse<>(200, "Project updated successfully", experience);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteProject(@PathVariable("id") String id,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<String> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        System.out.println("Deleting experience record " + id);
        String deletedID = projectService.Delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Project deleted successfully", deletedID));
    }

}
