package com.gonzo.jpa.service.user;

import com.gonzo.jpa.web.dto.UserDto;

public interface UserService {

    void saveByUser(UserDto dto);

    void getToUser(UserDto dto);

}
