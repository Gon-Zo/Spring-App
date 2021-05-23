package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.base.CustomPK;
import io.gonzo.jpa.app.domain.basic.Custom;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("h2")
@ExtendWith(SpringExtension.class)
@DisplayName("커스텀 엔티티 테스트")
class CustomRepositoryTest {

    @Autowired
    private CustomRepository customRepository;

    private final String content = "test10000";

    @BeforeEach
    public void beforeEach() {

        Custom dto = Custom.builder()
                .customPK(new CustomPK("naver.com", "test@naver.com"))
                .content(content)
                .build();

        customRepository.save(dto);

    }

    @Test
    @DisplayName("컨텐츠 like 절 by jpa containing")
    public void findByContentContaining() {

        Optional<List<Custom>> list = customRepository.findByContentContaining(content);

        list.flatMap(data -> data.stream()
                .filter(value -> value.getContent().equals(content))
                .findFirst()).ifPresent(value -> {
            Assertions.assertEquals(value.getContent(), content);
        });
    }

    @Test
    @DisplayName("컨텐츠 like 절 by jpa like")
    public void findByContentLike() {
        Optional<List<Custom>> list = customRepository.findByContentLike("%" + content + "%");

        list.flatMap(data -> data.stream()
                .filter(value -> value.getContent().equals(content)).findFirst())
                .ifPresent(value -> {
                    Assertions.assertEquals(value.getContent(), content);
                });
    }

    @Test
    @DisplayName("컨텐츠 jpa starting with 절")
    public void findByContentStartingWith() {
        Optional<List<Custom>> list = customRepository.findByContentStartingWith(content);
        list.flatMap(data ->
                data.stream()
                        .filter(value -> value.getContent().equals(content))
                        .findFirst())
                .ifPresent(value -> {
                    Assertions.assertEquals(value.getContent(), content);
                });
    }

    @Test
    @DisplayName("컨텐츠 jpa start with 절")
    public void findByStartsWith() {
        Optional<List<Custom>> list = customRepository.findByContentStartsWith(content);
        list.flatMap(data ->
                data.stream()
                        .filter(value -> value.getContent().equals(content))
                        .findFirst())
                .ifPresent(value -> Assertions.assertEquals(value.getContent(), content));
    }

    @Test
    @DisplayName("컨텐츠 jpa ending with 절")
    public void findByEndingWith() {
        Optional<List<Custom>> list = customRepository.findByContentEndingWith(content);
        list.flatMap(data ->
                data.stream()
                        .filter(value -> value.getContent().equals(content))
                        .findFirst())
                .ifPresent(value -> Assertions.assertEquals(value.getContent(), content));
    }

    @Test
    @DisplayName("컨텐츠 jpa ends with 절")
    public void findByContentEndsWith() {
        Optional<List<Custom>> list = customRepository.findByContentEndsWith(content);
        list.flatMap(data -> data.stream()
                .filter(value -> value.getContent().equals(content))
                .findFirst())
                .ifPresent(value -> Assertions.assertEquals(value.getContent(), content));
    }

}
