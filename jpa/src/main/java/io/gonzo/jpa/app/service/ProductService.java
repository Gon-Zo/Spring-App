package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.Category;
import io.gonzo.jpa.app.domain.Product;
import io.gonzo.jpa.app.repository.CategoryRepository;
import io.gonzo.jpa.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.gonzo.jpa.app.repository.specs.ProductSpecs.isCategory;
import static io.gonzo.jpa.app.repository.specs.ProductSpecs.isEqualsTitle;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    private final CategoryRepository categoryRepository;

    public List<Product> getProduct() {
        return repository.findAll();
    }

    public List<Product> getProductByTitle(String title, String categoryTitle) {
        Category category = categoryRepository.findByTitle(categoryTitle);
        return repository.findAll(isEqualsTitle(title).or(isCategory(category)));
    }

}
