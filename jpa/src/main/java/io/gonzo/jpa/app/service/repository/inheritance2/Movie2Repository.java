package io.gonzo.jpa.app.service.repository.inheritance2;

import io.gonzo.jpa.app.domain.inheritance2.Movie2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Movie2Repository extends JpaRepository<Movie2, Long> {
}
