package io.gonzo.jpa.app.service;

import io.gonzo.jpa.JpaApplication;
import io.gonzo.jpa.app.domain.Job;
import io.gonzo.jpa.app.repository.JobRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AutoConfigureTestEntityManager
@SpringBootTest(classes = JpaApplication.class)
@DisplayName("job 도메이 서비스 레이어")
@Transactional(rollbackFor = Exception.class)
class JobServiceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepository jobRepository;

    Job job;

    @BeforeEach
    public void beforeEach() {

    }


    @Test
    @DisplayName("전체 조회 - 객체 비교")
    void getByAll() {

        // given
        job = jobRepository.saveAndFlush(Job.builder()
                .title("job test")
                .content("job test data")
                .build()
        );


        // when
        List<Job> jobList = jobService.getByAll();

        // then
        jobList.forEach(dbJob-> Assertions.assertThat(job).isEqualTo(dbJob));

        return;
    }

    @Test
    @DisplayName("JOB 도메이 저장 및 플래쉬 비교")
    void createBy() {

        // given
        Job saveEntity = Job.builder()
                .title("save entity save")
                .content("saving by job domain")
                .build();

        // when
        Job dbFlushJob = jobRepository.saveAndFlush(saveEntity);

        // then
        Assertions.assertThat(dbFlushJob).isEqualTo(saveEntity);

    }

    @Test
    @DisplayName("job 저장시 entity id 들어왔나? 테스트 - NULL")
    void createByIdIsNull(){

        // given
        Job saveEntity = Job.builder()
                .title("save entity save")
                .content("saving by job domain")
                .build();

        // when
        jobRepository.save(saveEntity);

        // then
        Assertions.assertThat(saveEntity.getId()).isEqualTo(null);

    }

    @Test
    @DisplayName("job 도메이 저장시 - id 값 체크")
    void createByIdIs1L() {

        // given
        Job saveEntity = Job.builder()
                .title("save entity save")
                .content("saving by job domain")
                .build();

        // when
        jobRepository.save(saveEntity);

        //when
        Assertions.assertThat(saveEntity.getId()).isEqualTo(1L);

    }

}
