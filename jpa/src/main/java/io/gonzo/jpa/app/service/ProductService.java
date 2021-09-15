package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.Product;
import io.gonzo.jpa.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.gonzo.jpa.app.repository.specs.ProductSpecs.isEqualsTitle;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getProduct() {
        return repository.findAll();
    }

    public List<Product> getProductByTitle(String title){
        return repository.findAll(isEqualsTitle(title));
    }

}
