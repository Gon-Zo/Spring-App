package com.example.jpa.app.web;

import com.example.jpa.app.domain.Product;
import com.example.jpa.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductResource {

    private final ProductService service;

    @GetMapping("")
    public List<Product> showProduct() {
        return service.getProduct();
    }

    @GetMapping("/{title}")
    public List<Product> showProduct(@PathVariable String title, String categoryTitle) {
        return service.getProductByTitle(title, categoryTitle);
    }
}
