package com.rogerirobothia.example.controller;

import com.rogerirobothia.example.dto.ProductDTO;
import com.rogerirobothia.example.entity.Product;
import com.rogerirobothia.example.service.implementation.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@Valid @RequestBody ProductDTO productoDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Map<String, String> errorResponse = new LinkedHashMap<>();
            errorResponse.put("error", bindingResult.getFieldError().getDefaultMessage());
            errorResponse.put("message", "Bad data");

            return ResponseEntity.badRequest().body(errorResponse);
        }

        return ResponseEntity.ok("ta biuen");
    }

}
