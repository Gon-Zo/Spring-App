package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.service.AppUserService;
import io.gonzo.jpa.app.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {

    private final AppUserService service;

    @GetMapping("/app-user")
    public Optional<List<User>> showByAppUser() {
        return service.getUserList();
    }

    @PostMapping("/app-user")
    public void createByAppUser(@RequestBody UserDTO dto) {
        service.saveAppUser(dto);
    }

    @PutMapping("/app-user/{id}")
    public Long updateByAppUser(@PathVariable Long id, @RequestBody UserDTO dto) {
        return service.updateAppUser(dto, id);
    }

    @DeleteMapping("/app-user/{id}")
    public Long removeByAppUser(@PathVariable Long id) {
        return service.removeAppUser(id);
    }

    @GetMapping("/found/app-user")
    public Optional<List<User>> showByFoundAppUser(UserDTO dto) {
        return service.getFoundAppUserList(dto);
    }

}
