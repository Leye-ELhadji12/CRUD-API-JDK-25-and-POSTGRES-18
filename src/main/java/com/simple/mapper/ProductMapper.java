package com.simple.mapper;

import module.java.base.BeanUtils;
import module.java.base.Component;

import com.simple.dto.ProductDTO;
import com.simple.entity.Product;

@Component
public class ProductMapper {
    
    public Product toEntity(ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;
    }


    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }
}
