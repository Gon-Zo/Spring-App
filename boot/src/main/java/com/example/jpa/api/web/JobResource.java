package com.example.jpa.api.web;

import com.example.jpa.api.service.JobService;
import com.example.jpa.api.service.UserService;
import com.example.jpa.api.service.dto.JobDTO;
import com.example.jpa.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class JobResource {
    private final JobService service;

    private final UserService userService;

    @GetMapping("/jobs/title")
    public List<JobDTO.IOnlyTitle> showAllByOnlyTitle() {
        return service.getAllByOnlyTitle();
    }

    @GetMapping("jobs")
    public List<JobDTO.Info> showByJobList() {
        return service.getByAll();
    }

    @GetMapping("jobs/{id}")
    public ResponseEntity<JobDTO.IUserIds> showByOneJob(@PathVariable Long id) {

        Optional<JobDTO.IUserIds> bodyOptional = service.getByOne(id);

        if (bodyOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bodyOptional.get());
    }

    @PostMapping("job")
    public ResponseEntity<JobDTO.Result> createByJob(@Validated @RequestBody JobDTO.Store dto) {

        Set<User> userSet = (Set<User>) userService.getBy(dto.getUserIdList());

        Optional<JobDTO.Result> bodyOptional = service.createBy(dto, userSet);

        if (bodyOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(bodyOptional.get());
    }

    @PutMapping("jobs/{id}")
    public JobDTO.Result updateByJob(@PathVariable Long id, @Validated @RequestBody JobDTO.Store dto) {

        Set<User> userSet = (Set<User>) userService.getBy(dto.getUserIdList());

        return service.updateBy(id, dto, userSet);
    }
}
