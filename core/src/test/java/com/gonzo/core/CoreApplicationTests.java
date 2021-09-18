package com.gonzo.core;

import com.gonzo.core.app.configuration.ExConfiguration;
import com.gonzo.core.app.entity.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

    @Autowired
    ExConfiguration exConfiguration;

    @Test
    @DisplayName("DI Example1")
    void loadByExConfiguration() {
        Store store = exConfiguration.getStore();
        String itemTitle = store.getItem().getTitle();
        Assertions.assertEquals(itemTitle, "사과나무");
        return;
    }

    @Test
    void contextLoads() {
    }

}
