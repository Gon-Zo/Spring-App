package com.example.springjpa.domain.menu;

import com.example.springjpa.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "APP_MENU")
public class Menu extends BaseEntity {

    @Column(name = "url" , nullable = false)
    private String url;

    @Builder
    public Menu(String url){
       this.url = url;
    }

}
