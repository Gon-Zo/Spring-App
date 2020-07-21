package com.example.springjpa.domain.post;

import com.example.springjpa.domain.BaseEntity;
import com.example.springjpa.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "APP_POST")
@NoArgsConstructor
public class Post extends BaseEntity {

   @Column(name = "title" , nullable = false)
   private String title;

   @Column(name = "content" , nullable = false)
   private String content;

   /**
    * name = create name
    * referencedColumnName = mapping name
    */
   @OneToOne
   @JoinColumn(name = "user_seq" ,
           referencedColumnName = "seq")
   private User user;

   @Builder
   public Post(String title, String content) {
      this.title = title;
      this.content = content;
   }

}
