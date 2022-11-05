package com.example.app.app.service;

import com.example.app.app.domain.Job;
import com.example.app.app.domain.User;
import com.example.app.app.repository.JobRepository;
import com.example.app.app.repository.UserRepository;
import com.example.app.app.web.dto.JobDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class JobService {

    private final JobRepository repository;

    private final UserRepository userRepository;

    @Transactional
    public List<JobDTO.IOnlyTitle> getAllByOnlyTitle() {
        return repository.findAllProjectedBy(JobDTO.IOnlyTitle.class);
    }

    @Transactional
    public List<Job> getByAll() {
        return repository.findAll();
    }

    @Transactional
    public JobDTO.IUserIds getByOne(Long id) {
        return repository.findById(id, JobDTO.IUserIds.class).orElse(null);
    }

    @Transactional
    public JobDTO.Result createBy(JobDTO.Store dto) {

        Set<User> users = userRepository.findByIdIn(dto.getUserIdList());

        Job saveEntity = repository.save(dto.toEntity(users));

        return JobDTO.Result.convertBy(saveEntity);
    }

    @Transactional
    public Job updateBy(Long id, JobDTO.Store dto) {

        Job updateEntity = repository.findById(id).orElseThrow(() -> new NullPointerException());

        updateEntity.setTitle(dto.getTitle());

        updateEntity.setContent(dto.getContent());

        Set<User> updateUserList = userRepository.findByIdIn(dto.getUserIdList());

        updateEntity.setUsers(updateUserList);

        return updateEntity;
    }

}
