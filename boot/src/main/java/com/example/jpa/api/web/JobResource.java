package com.example.jpa.api.web;

import com.example.jpa.api.service.JobService;
import com.example.jpa.api.service.dto.JobDTO;
import com.example.jpa.domain.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobResource {

    private final JobService service;

    @GetMapping("/title")
    public ResponseEntity<List<JobDTO.IOnlyTitle>> showAllByOnlyTitle() {
        List<JobDTO.IOnlyTitle> body = service.getAllByOnlyTitle();
        return ResponseEntity.ok(body);
    }

    @GetMapping("")
    public ResponseEntity<List<Job>> showByJobList() {
        List<Job> body = service.getByAll();
        return ResponseEntity.ok(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO.IUserIds> showByOneJob(@PathVariable Long id) {
        JobDTO.IUserIds body = service.getByOne(id);
        return ResponseEntity.ok(body);
    }

    @PostMapping("")
    public ResponseEntity<JobDTO.Result> createByJob(@Validated @RequestBody JobDTO.Store dto) {
        JobDTO.Result body = service.createBy(dto);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateByJob(@PathVariable Long id, @Validated @RequestBody JobDTO.Store dto) {
        Job body = service.updateBy(id, dto);
        return ResponseEntity.ok(body);
    }

}
