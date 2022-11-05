package com.example.jpa.repository.specs;

import com.example.jpa.domain.Category;
import com.example.jpa.domain.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecs {

    public static Specification<Product> isEqualsTitle(String title) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title));
    }

    public static Specification<Product> isCategory(Category category) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("categorySet"), category));
    }

}
