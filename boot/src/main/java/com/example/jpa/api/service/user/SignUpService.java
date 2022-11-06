package com.example.jpa.api.service.user;

import com.example.jpa.api.service.dto.SignUpDTO;
import com.example.jpa.domain.user.User;
import com.example.jpa.domain.user.UserFail;
import com.example.jpa.domain.user.UserMeta;
import com.example.jpa.domain.user.UserPassword;
import com.example.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignUpDTO.Response signUp(SignUpDTO.Request dto) {

        UserMeta meta = dto.toMeta();

        UserPassword password = dto.toPassword(encoderPassword(dto.getPassword()));

        UserFail fail = dto.toFail();

        User user = dto.toUser(meta, password, fail);

        return new SignUpDTO.Response(userRepository.save(user));
    }

    private String encoderPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
