package io.gonzo.jpa.app.service.repository.inheritance2;

import io.gonzo.jpa.app.domain.inheritance2.Album2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Album2Repository extends JpaRepository<Album2, Long> {
}
