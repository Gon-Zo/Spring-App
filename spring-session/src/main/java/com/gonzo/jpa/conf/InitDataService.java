package com.gonzo.jpa.conf;

import com.gonzo.jpa.domain.user.UserRepository;
import com.gonzo.jpa.web.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class InitDataService {

    private final UserRepository userRepository;

    public InitDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initData(){

        long userCnt = userRepository.count();

        if(userCnt == 0L){

            UserDto userData = UserDto.builder()
                    .email("admin")
                    .password("1234")
                    .build();

            userData.encodingByPassword();

            userRepository.save(userData.toEntity());

        }

    }

}
