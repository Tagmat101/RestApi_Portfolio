package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.CertificationDto;
import org.group.portfolio.Entities.Certification;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Implementations.CertificationServiceImp;
import org.group.portfolio.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certification")
public class CertificationWs {
    @Autowired
    private CertificationServiceImp certificationServiceImp;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Certification>> createCertification(@RequestBody CertificationDto CertificationDto, @RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<Certification> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        String id = jwtUtil.getIdFromToken(token);
        Certification save = certificationServiceImp.Create(CertificationDto,id);

        ApiResponse<Certification> response = new ApiResponse<>(200, "Certification Created successfully", save);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ApiResponse<Certification>> getUserById(@PathVariable("id") String id,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<Certification> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        Certification Certification = certificationServiceImp.GetById(id);
        ApiResponse<Certification> response = new ApiResponse<>(200, "Certification found successfully", Certification);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Certification>>>  getAllCertificationsByUser(@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<List<Certification>> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        String id = jwtUtil.getIdFromToken(token);
        List<Certification> eduList = certificationServiceImp.GetAllByUser(id);
        ApiResponse< List<Certification>> response = new ApiResponse<>(200, "Certification List", eduList);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Certification>> updateCertification(@PathVariable("id") String id, @RequestBody CertificationDto updatedCertificationDto,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<Certification> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        Certification Certification = certificationServiceImp.Update(id,updatedCertificationDto);
        ApiResponse<Certification> response = new ApiResponse<>(200, "Certification updated successfully", Certification);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCertification(@PathVariable("id") String id,@RequestHeader("Authorization") String token) {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<String> notFoundResponse = new ApiResponse<>(404, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        System.out.println("Deleting Certification record " + id);
        String deletedID = certificationServiceImp.Delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Certification deleted successfully", deletedID));
    }
}
