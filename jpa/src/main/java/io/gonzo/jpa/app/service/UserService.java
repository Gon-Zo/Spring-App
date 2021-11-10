package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.repository.UserRepository;
import io.gonzo.jpa.app.web.dto.UserStoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getUserList1(){
        return repository.findAll();
    }

    public Optional<List<User>> getUserList() {
        return repository.findByAll();
    }

    public Optional<List<User>> getFoundAppUserList(UserStoreDTO dto) {
        return repository.findByWhere(dto);
    }

    public void saveAppUser(UserStoreDTO dto) {
        repository.save(dto.toEntity());
    }

    public Long updateAppUser(UserStoreDTO dto, Long id) {
        return repository.update(dto, id);
    }

    public Long removeAppUser(Long id) {
        return repository.delete(id);
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
