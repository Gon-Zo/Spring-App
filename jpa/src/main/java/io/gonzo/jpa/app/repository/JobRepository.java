package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.Job;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @Override
    @EntityGraph(attributePaths = {"users"})
    List<Job> findAll();

}
