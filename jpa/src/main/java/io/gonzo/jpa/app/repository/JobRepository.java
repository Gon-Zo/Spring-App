package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.Job;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface JobRepository extends JpaRepository<Job, Long> {

    @Override
    @Transactional
    @EntityGraph(attributePaths = {"users"})
    List<Job> findAll();

}
