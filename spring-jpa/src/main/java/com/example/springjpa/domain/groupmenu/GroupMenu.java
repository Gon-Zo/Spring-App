package com.example.springjpa.domain.groupmenu;

import com.example.springjpa.domain.BaseEntity;
import com.example.springjpa.domain.group.Group;
import com.example.springjpa.domain.menu.Menu;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Entity
@ToString
@Table(name = "APP_GROUP_MENU")
public class GroupMenu extends BaseEntity {

    @ManyToOne
    private Group groups;

    @ManyToOne
    private Menu menus;

}
