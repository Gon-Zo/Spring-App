package com.example.springjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Create by park031517@gmail.com on 2020-10-10, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */

@Getter
@Entity
@Table(name = "Post")
@NoArgsConstructor
public class Post extends BaseEntity {

    private String title;

    private String content;

    @ManyToOne
    private Category category;

    @Builder
    public Post(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

}
