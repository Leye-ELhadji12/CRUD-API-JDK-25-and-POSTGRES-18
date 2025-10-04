package com.simple.service;

import module.java.base.Page;
import module.java.base.Pageable;
import module.java.base.Service;

import lombok.RequiredArgsConstructor;
import com.simple.repository.ProductRepository;
import com.simple.dto.ProductDTO;
import com.simple.entity.Product;
import com.simple.mapper.ProductMapper;

import module.java.base.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }


    public Page<ProductDTO> getAllProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(productMapper::toDTO);
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toDTO(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        productRepository.save(product);
        return productMapper.toDTO(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
