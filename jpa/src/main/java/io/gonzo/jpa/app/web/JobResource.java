package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.Job;
import io.gonzo.jpa.app.service.JobService;
import io.gonzo.jpa.app.web.dto.JobDTO;
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

    @GetMapping("")
    public ResponseEntity<List<Job>> showByJobList() {
        List<Job> body = service.getByAll();
        return ResponseEntity.ok(body);
    }

    @PostMapping("")
    public ResponseEntity<Job> createByJob(@Validated @RequestBody JobDTO.Store dto) {
        Job body = service.createBy(dto);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateByJob(@PathVariable Long id, @Validated @RequestBody JobDTO.Store dto) {
        Job body = service.updateBy(id, dto);
        return ResponseEntity.ok(body);
    }

}
