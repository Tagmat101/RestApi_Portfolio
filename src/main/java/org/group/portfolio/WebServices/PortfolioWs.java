package org.group.portfolio.WebServices;

import org.group.portfolio.Dto.PortfolioDto;
import org.group.portfolio.Entities.Portfolio;
import org.group.portfolio.Response.ApiResponse;
import org.group.portfolio.Service.Interfaces.PortfolioService;
import org.group.portfolio.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioWs {
    @Autowired
    PortfolioService portfolioService;
    @Autowired
    JwtUtil jwtUtil;
     @PostMapping("/create")
     public ResponseEntity<ApiResponse<Portfolio>> Create(@RequestBody PortfolioDto portfolioDto, @RequestHeader("Authorization") String token)
     {
         if(!jwtUtil.validateToken(token)){
             ApiResponse<Portfolio> notFoundResponse = new ApiResponse<>(401, "UnAuthorized", null);
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
         }

         Portfolio portfolio = portfolioService.savePortfolio(portfolioDto);
         ApiResponse<Portfolio> response = new ApiResponse<>(200, "Portfolio Created successfully", portfolio);
         return ResponseEntity.ok(response);
     }
     @GetMapping("/{id}")
     public ResponseEntity<ApiResponse<Portfolio>> GetPortfolioById(@PathVariable String id,@RequestHeader("Authorization") String token)
     {
         if(!jwtUtil.validateToken(token)){
             ApiResponse<Portfolio> notFoundResponse = new ApiResponse<>(401, "UnAuthorized", null);
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
         }
         Portfolio portfolio = portfolioService.GetPortfolioById(id);
         ApiResponse<Portfolio> response = new ApiResponse<>(200, "Portfolio Found ", portfolio);
         return ResponseEntity.ok(response);
     }
     @PutMapping("/{id}")
     public ResponseEntity<ApiResponse<Portfolio>> Update(@PathVariable String id,@RequestBody PortfolioDto portfolioDto,@RequestHeader("Authorization") String token)
     {
         if(!jwtUtil.validateToken(token)){
             ApiResponse<Portfolio> notFoundResponse = new ApiResponse<>(401, "UnAuthorized", null);
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
         }
         Portfolio portfolio = portfolioService.UpdatePortfolio(id,portfolioDto);
         ApiResponse<Portfolio> response = new ApiResponse<>(200, "Portfolio Updated successfully ", portfolio);
         return ResponseEntity.ok(response);
     }
     @DeleteMapping("/{id}")
     public ResponseEntity<ApiResponse<String>> Delete(@PathVariable String id,@RequestHeader("Authorization") String token)
     {
        if(!jwtUtil.validateToken(token)){
            ApiResponse<String> notFoundResponse = new ApiResponse<>(401, "UnAuthorized", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundResponse);
        }
        portfolioService.DeletePortfolio(id);
        ApiResponse<String> response = new ApiResponse<>(200, "Portfolio Deleted successfully ", id);
        return ResponseEntity.ok(response);
     }
}
