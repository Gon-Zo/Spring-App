package com.example.springjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.List;

@Getter
@Entity
@Table(name = "CATEGORY")
@NoArgsConstructor
public class Category extends BaseEntity{

    private String title;

    @OrderBy("createDate asc")
    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    @Builder
    public Category(String title, List<Post> posts) {
        this.title = title;
        this.posts = posts;
    }

}
