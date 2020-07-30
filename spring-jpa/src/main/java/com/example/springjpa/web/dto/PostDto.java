package com.example.springjpa.web.dto;

import com.example.springjpa.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Create by park031517@gmail.com on 2020-07-30, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@ToString
@Getter
@NoArgsConstructor
public class PostDto {

    private String title;

    private String content;

    public Post toEntity(){
        return Post.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }

}
