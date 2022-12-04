package com.example.jpa.api.service.user;

import com.example.jpa.api.service.dto.SignUpDTO;
import com.example.jpa.core.exception.EmailExistsException;
import com.example.jpa.domain.user.User;
import com.example.jpa.domain.user.UserFail;
import com.example.jpa.domain.user.UserMeta;
import com.example.jpa.domain.user.UserPassword;
import com.example.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 가입에 대한 관점을 담은 서비스 Layer
 *
 * @author newbalancer
 * @see com.example.jpa.api.service.UserService
 */
@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * 가입 메소드
     *
     * @param dto 유저의 가입 정보를 담는 Object(DTO)
     * @return 유저의 기본적으로 정보를 반환을 해준다
     */
    @Transactional
    public SignUpDTO.Response signUp(SignUpDTO.Request dto) {

        checkedEmail(dto.getEmail());

        UserMeta meta = dto.toMeta();

        UserPassword password = dto.toPassword(encoderPassword(dto.getPassword()));

        UserFail fail = dto.toFail();

        User user = dto.toUser(meta, password, fail);

        return new SignUpDTO.Response(userRepository.save(user));
    }

    /**
     * 인코딩을 위한 메소드
     *
     * @param password 유저의 오리지널 패스워드
     * @return 인코딩된 패스워드
     */
    private String encoderPassword(String password) {
        return passwordEncoder.encode(password);
    }

    /**
     * 이메일 중복 체크
     *
     * @param email 유저 이메일
     * @throws EmailExistsException 동일한 유저 이메일 데이터가 있을시 예외처리
     */
    private void checkedEmail(String email) {

        boolean isExists = userRepository.existsByEmail(email);

        if (isExists) {
            throw new EmailExistsException(email);
        }
    }
}
