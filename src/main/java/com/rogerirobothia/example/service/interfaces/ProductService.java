package com.rogerirobothia.example.service.interfaces;

import com.rogerirobothia.example.dto.ProductDTO;
import com.rogerirobothia.example.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    //public Page<Product> getAllProducts(Integer page, Integer size);
    public List<Product> getAllProducts();
    public Optional<Product> getProductById(Long productId);
    public Product saveProduct(ProductDTO productDTO);
    public Product updateProduct(ProductDTO productDTO);
    public void deleteProduct(Long productId);
}
