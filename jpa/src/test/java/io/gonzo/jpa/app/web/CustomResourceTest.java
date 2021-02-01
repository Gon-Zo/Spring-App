package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.base.CustomPK;
import io.gonzo.jpa.app.repository.CustomRepository;
import io.gonzo.jpa.app.service.CustomService;
import io.gonzo.jpa.app.web.dto.CustomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CustomResource.class)
class CustomResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomService service;

//    @BeforeEach
//    void createByData() {
//
//        CustomPK pk = new CustomPK();
//        pk.setEmail("test@namver.com");
//        pk.setUrl("naver.com");
//
//        service.saveBy(
//                CustomDTO.builder()
//                        .customPK(pk)
//                        .content("tset...")
//                        .build()
//        );
//
//    }

    @Test
    @DisplayName("모든 데이터 보기")
    public void showByAll() throws Exception {
        mockMvc.perform(get("/api/web/custom/all"))
                .andExpect(status().isOk())
                ;
    }

}
