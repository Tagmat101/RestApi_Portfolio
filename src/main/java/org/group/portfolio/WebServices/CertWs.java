package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.CertDto;
import org.group.portfolio.Entities.Certification;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Interfaces.CertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Vector;

@RestController
@RequestMapping("/api/certification")

public class CertWs {

    @Autowired
    private CertService certService;
    ModelMapper modelMapper = new ModelMapper();
//    @PostMapping("/create")
//    public ResponseEntity<ApiResponse<Certification>> AddCert(@RequestBody CertDto certDto)
//    {
//        Certification save = certService.SaveCert(certDto);
//        ApiResponse<Certification> response = new ApiResponse<>(200, "Certification Added successfully", save);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping("/update/{id}")
//    private ResponseEntity<ApiResponse<Certification>> UpdateCert(@PathVariable String id ,@RequestBody CertDto certDto)
//    {
//        Certification updateCert = certService.UpdateCert(id,certDto);
//        ApiResponse<Certification> response = new ApiResponse<>(200, "Certification Updated successfully", updateCert);
//        return ResponseEntity.ok(response);
//    }

//    @PostMapping("/delete/{id}")
//    private ResponseEntity<ApiResponse<Certification>> DeleteCert(@PathVariable String id, @RequestBody  CertDto certDto)
//    {
//        Certification deleteCert = certService.DeleteCert(id, certDto);
//        ApiResponse<Certification> response = new ApiResponse<>(200, "Certification Deleted successfully", deleteCert);
//        return ResponseEntity.ok(response);
//    }

//    @GetMapping("/GetCert/{id}")
//    private ResponseEntity<ApiResponse<Certification>> GetCert(@PathVariable String id, @RequestBody CertDto certDto)
//    {
//        Certification getCert = certService.GetCert(id, certDto);
//        ApiResponse<Certification> response = new ApiResponse<>(200, "Certification Retrieved successfully", getCert);
//        return ResponseEntity.ok(response);
//    }

//    @GetMapping("/GetAllCerts")
//    private ResponseEntity<ApiResponse<Vector<Certification>>> GetAllCerts(@RequestBody CertDto certDto) {
//        Vector<Certification> getAllCerts = certService.GetAllCerts(certDto);
//        ApiResponse<Vector<Certification>> response = new ApiResponse<>(200, "Certifications Retrieved successfully", getAllCerts);
//        return ResponseEntity.ok(response);
//    }
}
