package com.example.jpa.api.service;

import com.example.jpa.data.domain.User;
import com.example.jpa.data.repository.UserRepository;
import com.example.jpa.api.service.dto.UserStoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getUserList1() {
        return repository.findAll();
    }

    public Optional<List<User>> getUserList() {
//        return repository.findByAll();
        return Optional.empty();
    }

    public Optional<List<User>> getFoundAppUserList(UserStoreDTO dto) {
//        return repository.findByWhere(dto);
        return Optional.empty();
    }

    public void saveAppUser(UserStoreDTO dto) {
        repository.save(dto.toEntity());
    }

    public Long updateAppUser(UserStoreDTO dto, Long id) {
//        return repository.update(dto, id);
        return 0L;
    }

    public Long removeAppUser(Long id) {
//        return repository.delete(id);
        return 0L;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateByAppUser(Long id) {

        Optional<User> updateUserOptional = repository.findById(id);

        if (updateUserOptional.isPresent()) {

            User updateUser = updateUserOptional.get();

            updateUser.usedByUser();

            return Boolean.TRUE;
        }


        return Boolean.FALSE;
    }

}
