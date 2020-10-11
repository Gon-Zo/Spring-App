package com.example.springjpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    /**
     * 양뱡향성을 막기위해서
     * @JsonIgnore
     * @ManyToOne(fetch = FetchType.LAZY)
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    public Post(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

}
