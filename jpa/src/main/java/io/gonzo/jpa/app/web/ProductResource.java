package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.service.ProductService;
import io.gonzo.jpa.app.web.dto.NameOnly;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductResource {

    private final ProductService service;

    @GetMapping("")
    public Collection<NameOnly> showProductOnlyName(String img) {
        return service.getByImg(img);
    }

}
