package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.Auth;
import io.gonzo.jpa.app.repository.AuthRepository;
import io.gonzo.jpa.app.web.dto.AuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthResource {

    public final AuthRepository repository;

    @GetMapping("")
    public List<Auth> showAuthList() {
        return repository.findAll();
    }

    @GetMapping("/authName/{authName}")
    public Collection<AuthDTO.IOnlyAuthName> showAuthList(@PathVariable String authName) {
        return repository.findByAuthName(authName, AuthDTO.IOnlyAuthName.class);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auth> showByAuthOne(@PathVariable Long id) {
        Optional<Auth> authOptional = repository.findById(id);
        return ResponseEntity.ok(authOptional.orElseThrow(() -> new NullPointerException()));
    }

    @GetMapping("/exc")
    public void showExc() {
        throw new NullPointerException();
    }

    @PutMapping("/{id}")
    public void modifyByAuth(@PathVariable Long id) {

        Optional<Auth> authOptional = repository.findById(id);

        if (authOptional.isPresent()){
            Auth auth = authOptional.get();

            auth.setAuthName("TEST_SUCCESS");
        }

        return;
    }

}
