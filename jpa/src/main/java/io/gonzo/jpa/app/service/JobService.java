package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.Job;
import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.repository.JobRepository;
import io.gonzo.jpa.app.repository.UserRepository;
import io.gonzo.jpa.app.web.dto.JobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository repository;

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<Job> getByAll() {
        return repository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Job createBy(JobDTO.Store dto) {

        Set<User> users = userRepository.findByIdIn(dto.getUserIdList());

        Job saveEntity = repository.save(dto.toEntity(users));

        return saveEntity;
    }

}
