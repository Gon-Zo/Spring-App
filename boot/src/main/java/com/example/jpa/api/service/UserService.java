package com.example.jpa.api.service;

import com.example.jpa.api.service.dto.SignUpDTO;
import com.example.jpa.api.service.dto.UserStoreDTO;
import com.example.jpa.api.service.user.SignUpService;
import com.example.jpa.domain.user.User;
import com.example.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final SignUpService signUpService;

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

    public SignUpDTO.Response saveAppUser(SignUpDTO.Request dto) {
        return signUpService.signUp(dto);
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

            return Boolean.TRUE;
        }


        return Boolean.FALSE;
    }

    public Collection<User> getBy(Collection<Long> userIds) {
        return repository.findByIdIn(userIds);
    }
}
