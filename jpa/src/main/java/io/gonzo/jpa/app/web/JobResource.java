package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.Job;
import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.repository.JobRepository;
import io.gonzo.jpa.app.repository.UserRepository;
import io.gonzo.jpa.app.web.dto.JobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobResource {

    private final JobRepository repository;

    private final UserRepository userRepository;

    @GetMapping("")
    public List<Job> showByJobList() {
        return repository.findAll();
    }

    @PostMapping("")
    public void createByJob(@RequestBody JobDTO.Store dto) {

        Set<User> users = userRepository.findByIdIn(dto.getUserIdList());

        repository.save(dto.toEntity(users));

        return;
    }

}
