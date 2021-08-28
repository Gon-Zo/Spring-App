package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.service.UserService;
import io.gonzo.jpa.app.web.dto.IUserDTO;
import io.gonzo.jpa.app.web.dto.UserStoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

    @GetMapping("/app-user1")
    public List<User> showByUser() {
        return service.getUserList1();
    }

    @GetMapping("/app-user")
    public Optional<List<User>> showByAppUser() {
        return service.getUserList();
    }

    @PostMapping("/app-user")
    public void createByAppUser(@RequestBody UserStoreDTO dto) {
        service.saveAppUser(dto);
    }

    @PutMapping("/app-user/{id}")
    public Long updateByAppUser(@PathVariable Long id, @RequestBody UserStoreDTO dto) {
        return service.updateAppUser(dto, id);
    }

    @DeleteMapping("/app-user/{id}")
    public Long removeByAppUser(@PathVariable Long id) {
        return service.removeAppUser(id);
    }

    @GetMapping("/found/app-user")
    public Optional<List<User>> showByFoundAppUser(UserStoreDTO dto) {
        return service.getFoundAppUserList(dto);
    }

}
