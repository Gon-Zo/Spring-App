package com.example.springjpa.domain.store;

import com.example.springjpa.domain.BaseEntity;
import com.example.springjpa.domain.user.User;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Create by park031517@gmail.com on 2020-08-14, 금
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Entity
@DynamicUpdate
@NoArgsConstructor
@Table(name="APP_SOTRE")
public class Store extends BaseEntity {

    @Setter
    @Column(name = "name" , nullable = false)
    private String name;

    @Setter
    @Column(name = "account_number" , nullable = false)
    private String accountNumber;

    @Setter
    @OneToOne
    private User user;

    @Builder
    public Store (String name, String accountNumber, User user){
        this.name = name;
        this.accountNumber = accountNumber;
        this.user = user;
    }

}
