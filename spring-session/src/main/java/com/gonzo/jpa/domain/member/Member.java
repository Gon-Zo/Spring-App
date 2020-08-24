package com.gonzo.jpa.domain.member;

import com.gonzo.jpa.domain.BaseEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
@NoArgsConstructor
public class Member extends BaseEntity {

    private String name;

    @Builder
    public Member(String name) {
        this.name = name;
    }

}
