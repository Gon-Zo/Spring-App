package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.base.CustomPK;
import io.gonzo.jpa.app.domain.basic.Custom;
import io.gonzo.jpa.app.repository.CustomRepository;
import io.gonzo.jpa.app.web.dto.CustomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@ActiveProfiles("h2")
@ExtendWith(MockitoExtension.class)
class CustomServiceTest {

    @Mock
    private CustomRepository repository;

    @InjectMocks
    private CustomService service;

    @BeforeEach
    public void setUp() {
        this.service = new CustomService(repository);
    }

    @Test
    void saveBy() throws Exception {

        String content = "naver";

        CustomPK pk = new CustomPK("naver.com", "test@naver.com");

        Custom custom = Custom.builder()
                .customPK(pk)
                .content(content)
                .build();

//        given(repository.save(custom)).willReturn(custom);

        CustomDTO dto = CustomDTO.builder()
                .customPK(pk)
                .content(content)
                .build();

        lenient().when(service.saveBy(dto)).thenReturn(Boolean.TRUE);

    }

    @Test
    void getById() {
    }

    @Test
    void getByCustomPK_Email() {
    }

    @Test
    void getByAll() {
    }

    @Test
    void getByCustomPK_Url() {
    }

    @Test
    void getByContentContaining() {

    }

    @Test
    void getByContentLike() {
    }

    @Test
    void getByContentStartingWith() {
    }

    @Test
    void getByContentEndingWith() {
    }

    @Test
    void getByContentStartsWith() {
    }

    @Test
    void getByContentEndsWith() {
    }
}
