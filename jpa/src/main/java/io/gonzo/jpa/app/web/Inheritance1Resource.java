package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.service.Inheritance1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inheritance1")
@RequiredArgsConstructor
public class Inheritance1Resource {

    private final Inheritance1Service inheritance1Service;


}
