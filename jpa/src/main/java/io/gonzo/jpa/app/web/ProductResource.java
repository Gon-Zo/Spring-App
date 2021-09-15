package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.Product;
import io.gonzo.jpa.app.service.ProductService;
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
    public List<Product> showProduct(@PathVariable String title) {
        return service.getProductByTitle(title);
    }

}
