package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.Product;
import io.gonzo.jpa.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getProduct() {
        return repository.findAll();
    }

}
