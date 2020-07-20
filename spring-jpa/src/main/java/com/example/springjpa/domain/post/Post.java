package com.example.springjpa.domain.post;

import com.example.springjpa.domain.BaseEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "POST")
@NoArgsConstructor
public class Post extends BaseEntity {

   @Column(name = "title" , nullable = false)
   private String title;

   @Column(name = "content" , nullable = false)
   private String content;

   @Builder
   public Post(String title, String content) {
      this.title = title;
      this.content = content;
   }

}
