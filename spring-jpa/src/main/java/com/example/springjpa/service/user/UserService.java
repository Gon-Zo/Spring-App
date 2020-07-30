package com.example.springjpa.service.user;

import com.example.springjpa.domain.user.User;
import com.example.springjpa.web.dto.UserDto;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

/**
 * Create by park031517@gmail on 2020.07.22
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public interface UserService {

    User getByEmail(UserDto dto);

    User getByName(UserDto dto);

    User getByEmailAndName(UserDto dto);

    User getByEmailOrName(UserDto dto);

    User getByCreateDate(UserDto dto);

    void createByUser(UserDto dto);

    void removeByUser(long seq);

    void updateByUser(long seq , UserDto dto);

    List<User> getByUserList();

}
