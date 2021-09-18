package com.gonzo.core.app.entity;

import lombok.Getter;

public class Store {

    @Getter
    private Item item;

    public Store(Item item) {
        this.item = item;
    }

}
