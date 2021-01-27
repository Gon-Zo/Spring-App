package io.gonzo.jpa.app.repository.inheritance3;

import io.gonzo.jpa.app.domain.inheritance3.Album3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Album3Repository extends JpaRepository<Album3, Long> {
}
