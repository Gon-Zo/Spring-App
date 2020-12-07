package com.example.springjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Table(name = "CATEGORY")
@NoArgsConstructor
public class Category extends BaseEntity{

    @Column(name = "TITLE")
    private String title;

    @OrderBy("createDate asc , title desc ")
    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    @Builder
    public Category(String title, List<Post> posts) {
        this.title = title;
        this.posts = posts;
    }

}
