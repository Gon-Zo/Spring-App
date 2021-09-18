package com.gonzo.core.app.configuration;

import com.gonzo.core.app.entity.Item;
import com.gonzo.core.app.entity.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExConfiguration {

    @Bean
    public Item getItem() {
        return new Item("사과나무");
    }

    @Bean
    public Store getStore() {
        return new Store(getItem());
    }

    @Bean
    public Store getStore1() {
        Store store = new Store();
        store.setItem(getItem());
        return store;
    }
}
