package com.example.springjpa.web.dto;

import com.example.springjpa.domain.store.Store;
import com.example.springjpa.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Create by park031517@gmail.com on 2020-08-15, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Getter
@ToString
@NoArgsConstructor
public class StoreDto {

    private String name;

    private String accountNumber;

    private User user;

    public Store toEntity() {
        return Store.builder()
                .name(this.name)
                .accountNumber(this.accountNumber)
                .user(this.user)
                .build();
    }

}
