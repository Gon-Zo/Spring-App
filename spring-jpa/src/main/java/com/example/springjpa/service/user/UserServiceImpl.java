package com.example.springjpa.service.user;

import com.example.springjpa.domain.user.User;
import com.example.springjpa.domain.user.UserRepository;
import com.example.springjpa.domain.user.support.UserSupport;
import com.example.springjpa.web.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    private final UserSupport support;

    public UserServiceImpl(UserRepository repository, UserSupport support) {
        this.repository = repository;
        this.support = support;
    }

    @Override
    public User getByEmail(UserDto dto) {
        return repository.findByEmail(dto.getEmail());
    }

    @Override
    public User getByName(UserDto dto) {
        return repository.findByName(dto.getName());
    }

    @Override
    public User getByEmailAndName(UserDto dto) {
        return repository.findByEmailAndName(dto.getEmail() , dto.getName());
    }

    @Override
    public User getByEmailOrName(UserDto dto) {
        return repository.findByEmailOrName(dto.getEmail() , dto.getName());
    }

    @Override
    public User getByCreateDate(UserDto dto) {
        return repository.findByCreateDate(dto.getCreateDate());
    }

    @Override
    public void createByUser(UserDto dto) {
        repository.save(dto.toEntity());
    }

    @Override
    @Transactional
    public void removeByUser(long seq) {
        repository.deleteById(seq);
    }

    @Override
    @Transactional
    public void updateByUser(long seq , UserDto dto) {

        User currentUser = repository.getOne(seq);

        User newUser = currentUser.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName())
                .build();

        newUser.setSeq(seq);

        repository.save(newUser);

    }

    @Override
    public List<User> getByUserList() {
        return repository.findAll();
    }

}
