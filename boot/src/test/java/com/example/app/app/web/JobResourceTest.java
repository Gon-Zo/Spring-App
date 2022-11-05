package com.example.app.app.web;

import com.example.app.BootApplication;
import com.example.app.app.domain.Job;
import com.example.app.app.repository.JobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//json-path
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@AutoConfigureMockMvc
@SpringBootTest(classes = BootApplication.class)
class JobResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JobRepository jobRepository;

    @BeforeEach
    void beforeEach() {
    }

    @Test
    void showByJobList() throws Exception {

        // given

        Job saveEntity = Job.builder()
                .title("title")
                .content("content")
                .build();

        jobRepository.save(saveEntity);

        // when
        mockMvc.perform(MockMvcRequestBuilders.get("/job"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].id").value(1L));

    }

    @Test
    void createByJob() {
    }

}
