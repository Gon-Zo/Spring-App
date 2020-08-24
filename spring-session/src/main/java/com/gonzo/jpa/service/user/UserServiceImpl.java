package com.gonzo.jpa.service.user;

import com.gonzo.jpa.domain.user.UserRepository;
import com.gonzo.jpa.web.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveByUser(UserDto dto) {
        dto.encodingByPassword();
        repository.save(dto.toEntity());
    }

    @Override
    public void getToUser(UserDto dto) {

    }

}
