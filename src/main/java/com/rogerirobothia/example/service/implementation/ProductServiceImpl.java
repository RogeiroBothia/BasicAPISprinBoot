package com.rogerirobothia.example.service.implementation;

import com.rogerirobothia.example.dto.ProductDTO;
import com.rogerirobothia.example.entity.Product;
import com.rogerirobothia.example.exceptions.ProductNotFound;
import com.rogerirobothia.example.repository.ProductRepository;
import com.rogerirobothia.example.service.interfaces.ProductService;
import com.rogerirobothia.example.utility.UtilityModelMapper;
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
    public Product findProductById(Long productId) throws ProductNotFound {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()){
            throw new ProductNotFound("Product is not available");
        }
        return product.get();
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
    public Product updateProduct(Long id, ProductDTO productDTO) throws ProductNotFound{
        if(productRepository.findById(id).isEmpty()){
            throw new ProductNotFound("Product to update is not available");
        }
        Product product = mapper.mapToProduct(productDTO);
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        if(productRepository.findById(productId).isEmpty()){
            throw new ProductNotFound("Product to delete is not available");
        }
        productRepository.deleteById(productId);
    }
}
