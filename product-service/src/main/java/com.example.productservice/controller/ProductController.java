package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
            return ResponseEntity.ok(productService.saveProduct(product));
    }



    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping({"/{id}"})
    public Product getProuctById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

//    @PutMapping("/api/products/{id}")
//    public ResponseEntity<Product> updateProduct(
//            @PathVariable Long id,
//            @RequestBody Product updatedProduct) {
//        Product saved = productService.update(id, updatedProduct);
//        return ResponseEntity.ok(saved);
//    }


}