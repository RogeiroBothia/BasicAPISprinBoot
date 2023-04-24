package com.rogerirobothia.example.service.implementation;

import com.rogerirobothia.example.dto.ProductDTO;
import com.rogerirobothia.example.entity.Product;
import com.rogerirobothia.example.repository.ProductRepository;
import com.rogerirobothia.example.service.interfaces.ProductService;
import com.rogerirobothia.example.utility.UtilityModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UtilityModelMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, UtilityModelMapper mapper) {

        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    //@Override
    //public Page<Product> getAllProducts(Integer page, Integer size) {
    //    return null;
    //}

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long productId) {

        return productRepository.findById(productId);
    }

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        Product product = mapper.mapToProduct(productDTO);
        product.setCreatedDate(LocalDateTime.now());
        if(product.getAmount()>0)
            product.setStock(true);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
