package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.repository.ProductRepository;
import io.gonzo.jpa.app.web.dto.NameOnly;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Collection<NameOnly> getByImg(String img) {
        return repository.findByImg(img, NameOnly.class);
    }

}
