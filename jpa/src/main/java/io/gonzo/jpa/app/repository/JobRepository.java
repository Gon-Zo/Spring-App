package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.Job;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface JobRepository extends JpaRepository<Job, Long> {

    @Override
    @Transactional
    @EntityGraph(attributePaths = {"users"})
    List<Job> findAll();

    @Override
    @Transactional
    @EntityGraph(attributePaths = {"users"})
    Optional<Job> findById(Long aLong);

    @Transactional
    @EntityGraph(attributePaths = {"users"})
    <T> Optional<T> findById(Long id, Class<T> className);

//    @Transactional
//    boolean existsById(Long id);
}
