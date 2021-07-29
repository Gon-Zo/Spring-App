package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.AppUser;
import io.gonzo.jpa.app.service.AppUserService;
import io.gonzo.jpa.app.web.dto.AppUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app-user")
@RequiredArgsConstructor
public class AppUserResource {

    private final AppUserService service;

    @GetMapping("")
    public List<AppUser> showByAppUser() {
        return service.getUserList();
    }

    @PostMapping("")
    public void createByAppUser(@RequestBody AppUserDTO dto) {
        service.saveAppUser(dto);
    }

    @PutMapping("/{id}")
    public Long updateByAppUser(@PathVariable Long id, @RequestBody AppUserDTO dto) {
        return service.updateAppUser(dto, id);
    }

}
