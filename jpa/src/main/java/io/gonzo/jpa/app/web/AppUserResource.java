package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.AppUser;
import io.gonzo.jpa.app.service.AppUserService;
import io.gonzo.jpa.app.web.dto.AppUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserResource {

    private final AppUserService service;

    @GetMapping("/app-user")
    public List<AppUser> showByAppUser() {
        return service.getUserList();
    }

    @PostMapping("/app-user")
    public void createByAppUser(@RequestBody AppUserDTO dto) {
        service.saveAppUser(dto);
    }

    @PutMapping("/app-user/{id}")
    public Long updateByAppUser(@PathVariable Long id, @RequestBody AppUserDTO dto) {
        return service.updateAppUser(dto, id);
    }

    @DeleteMapping("/app-user/{id}")
    public Long removeByAppUser(@PathVariable Long id) {
        return service.removeAppUser(id);
    }

    @GetMapping("/found/app-user")
    public List<AppUser> showByFoundAppUser(AppUserDTO dto) {
        return service.getFoundAppUserList(dto);
    }

}
