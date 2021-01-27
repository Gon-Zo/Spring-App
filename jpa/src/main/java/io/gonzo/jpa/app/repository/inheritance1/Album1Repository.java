package io.gonzo.jpa.app.repository.inheritance1;

import io.gonzo.jpa.app.domain.inheritance1.Album1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Album1Repository extends JpaRepository<Album1 , Long> {
}
