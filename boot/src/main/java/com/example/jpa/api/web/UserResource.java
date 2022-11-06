package com.example.jpa.api.web;

import com.example.jpa.api.service.UserService;
import com.example.jpa.api.service.dto.SignUpDTO;
import com.example.jpa.api.service.dto.UserStoreDTO;
import com.example.jpa.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public SignUpDTO.Response createByAppUser(@RequestBody SignUpDTO.Request dto) {
        return service.saveAppUser(dto);
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

    @PutMapping("/user/{id}")
    public ResponseEntity modifyByUser(@PathVariable Long id) {

        boolean isUpdateAble = service.updateByAppUser(id);

        return isUpdateAble ? responseEntity(HttpStatus.OK, "업데이트 성공", isUpdateAble) : responseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "업데이트 실패", isUpdateAble);
    }

    private ResponseEntity responseEntity(HttpStatus statusType, String responseMessage, Object data) {

        throw new NullPointerException();
    }

}
