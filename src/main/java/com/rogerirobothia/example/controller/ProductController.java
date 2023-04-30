package com.rogerirobothia.example.controller;

import com.rogerirobothia.example.dto.ProductDTO;
import com.rogerirobothia.example.entity.Product;
import com.rogerirobothia.example.exceptions.ProductNotFound;
import com.rogerirobothia.example.service.implementation.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {

        this.productService = productService;
    }

    @GetMapping("/{id}")
    Product findProductById(@PathVariable Long id) throws ProductNotFound{
        return productService.findProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product saveProduct(@Valid @RequestBody ProductDTO productoDTO){
        return productService.saveProduct(productoDTO);
    }
}
