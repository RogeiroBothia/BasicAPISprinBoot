package com.rogerirobothia.example.utility;

import com.rogerirobothia.example.dto.ProductDTO;
import com.rogerirobothia.example.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UtilityModelMapper {

    private final ModelMapper mapper = new ModelMapper();
    private static UtilityModelMapper instance;

    private UtilityModelMapper(){}
    public static UtilityModelMapper singleInstance(){
        if(instance == null){
           instance = new UtilityModelMapper();
        }
        return instance;
    }

    //Product entity to ProductDTO
    public ProductDTO mapToProductDTO(Product product){
        return mapper.map(product, ProductDTO.class);
    }

    //ProductDTO to Product entity
    public Product mapToProduct(ProductDTO productDTO){
        return mapper.map(productDTO, Product.class);
    }
}
