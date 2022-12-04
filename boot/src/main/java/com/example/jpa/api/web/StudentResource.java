package com.example.jpa.api.web;


import com.example.jpa.api.service.dto.StudentDTO;
import com.example.jpa.domain.Student;
import com.example.jpa.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentResource {

    private final StudentRepository repository;

    @GetMapping("")
    public ResponseEntity<List<Student>> showByStudentList() {
        List<Student> data = repository.findAll();
        return ResponseEntity.ok(data);
    }

    @PostMapping("")
    public ResponseEntity<Boolean> createByStudent(@RequestBody StudentDTO.Store dto) {
        Student saveEntity = repository.save(dto.toEntity());
        return ResponseEntity.ok(ObjectUtils.isNotEmpty(saveEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> showByStudent(@PathVariable UUID id) {
        Optional<Student> data = repository.findById(id);

        if (data.isEmpty()) {
            throw new NullPointerException();
        }

        return ResponseEntity.ok(data.get());
    }

}
