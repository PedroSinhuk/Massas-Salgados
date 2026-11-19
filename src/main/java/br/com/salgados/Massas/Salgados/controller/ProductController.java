package br.com.salgados.Massas.Salgados.controller;


import br.com.salgados.Massas.Salgados.entity.Category;
import br.com.salgados.Massas.Salgados.entity.Filling;
import br.com.salgados.Massas.Salgados.entity.Product;
import br.com.salgados.Massas.Salgados.mapper.ProductMapper;
import br.com.salgados.Massas.Salgados.request.ProductRequest;
import br.com.salgados.Massas.Salgados.response.ProductResponse;
import br.com.salgados.Massas.Salgados.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/massal/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest productRequest) {
        Product product = ProductMapper.toProduct(productRequest);
        Product savedProduct = productService.save(product);
        return ResponseEntity.ok(ProductMapper.toProductResponse(savedProduct));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll()
                .stream()
                .map(ProductMapper::toProductResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findAll(@PathVariable Long id) {
        return productService.findById(id)
                .map(product -> ResponseEntity.ok(ProductMapper.toProductResponse(product)))
                .orElse(ResponseEntity.notFound().build());
    }
}