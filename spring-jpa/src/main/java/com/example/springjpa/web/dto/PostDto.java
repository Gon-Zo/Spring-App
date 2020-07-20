package com.example.springjpa.web.dto;

import com.example.springjpa.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
