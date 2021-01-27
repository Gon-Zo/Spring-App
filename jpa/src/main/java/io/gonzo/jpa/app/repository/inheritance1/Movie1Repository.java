package io.gonzo.jpa.app.repository.inheritance1;

import io.gonzo.jpa.app.domain.inheritance1.Movie1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Movie1Repository extends JpaRepository<Movie1 , Long> {
}
