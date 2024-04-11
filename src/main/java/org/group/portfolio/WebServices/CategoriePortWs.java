package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.CategoriePortDto;
import org.group.portfolio.Dto.EducationDto;
import org.group.portfolio.Entities.CategoriePort;
import org.group.portfolio.Entities.Education;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Implementations.EducationServiceImp;
import org.group.portfolio.Service.Interfaces.CategoriePortService;
import org.group.portfolio.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoriePort")
public class CategoriePortWs {
    @Autowired
    private CategoriePortService categoriePortService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CategoriePort>> createEducation(@RequestBody CategoriePortDto categoriePortDto, @RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<CategoriePort> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        CategoriePort save = categoriePortService.Create(categoriePortDto,token);
        ApiResponse<CategoriePort> response = new ApiResponse<>(200, "Education Created successfully", save);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CategoriePort>>>  getAllCategories(@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<List<CategoriePort>> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        String id = jwtUtil.getIdFromToken(token);
        List<CategoriePort> categoriePortsList = categoriePortService.GetAllByUser(id);
        ApiResponse< List<CategoriePort>> response = new ApiResponse<>(200, "CategoriePort List", categoriePortsList);
        return ResponseEntity.ok(response);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse<String>> deleteEducation(@PathVariable("id") String id,@RequestHeader("Authorization") String token) {
//        if(!jwtUtil.validateToken(token)){
//            ApiResponse<String> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
//        }
//        System.out.println("Deleting education record " + id);
//        String deletedID = educationService.Delete(id);
//        return ResponseEntity.ok(new ApiResponse<>(200, "Education deleted successfully", deletedID));
//    }
}
