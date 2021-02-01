package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.basic.Custom;
import io.gonzo.jpa.app.repository.CustomOnly;
import io.gonzo.jpa.app.service.CustomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/web/custom")
public class CustomResource {

    private final CustomService service;

    @GetMapping("/email")
    public Optional<List<Custom>> showByCustomPk_Email(String email) {
        return service.getByCustomPK_Email(email);
    }

    @GetMapping("/all")
    public Optional<List<Custom>> showByAll() {
        return service.getByAll();
    }

    @GetMapping("/url")
    public Collection<CustomOnly> showByCustomPK_Url(String url){
        return service.getByCustomPK_Url(url);
    }

}
