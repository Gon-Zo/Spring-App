package com.gonzo.core.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Item {

    @Getter
    private String title;

    public Item(String title) {
        this.title = title;
    }

}
