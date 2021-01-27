package io.gonzo.jpa.app.repository.inheritance3;

import io.gonzo.jpa.app.domain.inheritance3.Movie3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Movie3Repository extends JpaRepository<Movie3, Long> {
}
