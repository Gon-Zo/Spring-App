package com.example.jpa.api.service;

import com.example.jpa.api.service.dto.JobDTO;
import com.example.jpa.domain.Job;
import com.example.jpa.domain.User;
import com.example.jpa.repository.JobRepository;
import com.example.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class JobService {

    private final JobRepository repository;

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<JobDTO.IOnlyTitle> getAllByOnlyTitle() {
        return repository.findAllProjectedBy(JobDTO.IOnlyTitle.class);
    }

    @Transactional(readOnly = true)
    public List<JobDTO.Info> getByAll() {
        return repository.findAllProjectedBy(JobDTO.Info.class);
    }

    @Transactional(readOnly = true)
    public Optional<JobDTO.IUserIds> getByOne(Long id) {
        return repository.findById(id, JobDTO.IUserIds.class);
    }

    @Transactional
    public Optional<JobDTO.Result> createBy(JobDTO.Store dto, Collection<User> userSet) {

        if (userSet.isEmpty()) {
            return Optional.empty();
        }

        Job saveEntity = repository.save(dto.toEntity(userSet));

        return Optional.of(JobDTO.Result.convertBy(saveEntity));
    }

    @Transactional
    public JobDTO.Result updateBy(Long id, JobDTO.Store dto, Set<User> userSet) {

        Job entity = repository.findById(id).orElseThrow(NullPointerException::new);

        entity.update(dto.getTitle(), dto.getContent(), userSet);

        return JobDTO.Result.convertBy(entity);
    }
}
