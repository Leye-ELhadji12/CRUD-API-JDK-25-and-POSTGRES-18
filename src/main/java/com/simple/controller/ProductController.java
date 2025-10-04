package com.simple.controller;

import module.java.base.RequestMapping;
import module.java.base.RestController;

import com.simple.dto.ProductDTO;
import com.simple.service.ProductService;

import lombok.RequiredArgsConstructor;

import module.java.base.Page;
import module.java.base.PageRequest;
import module.java.base.Pageable;
import module.java.base.HttpStatus;
import module.java.base.ResponseEntity;
import module.java.base.DeleteMapping;
import module.java.base.GetMapping;
import module.java.base.PatchMapping;
import module.java.base.PathVariable;
import module.java.base.PostMapping;
import module.java.base.RequestBody;
import module.java.base.RequestParam;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(
        @RequestParam (defaultValue = "0") int page,
        @RequestParam (defaultValue = "10") int size) {
            Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDTO));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, productDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
