package com.gonzo.core.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Store {

    @Getter
    @Setter
    private Item item;

    public Store(Item item) {
        this.item = item;
    }

}
