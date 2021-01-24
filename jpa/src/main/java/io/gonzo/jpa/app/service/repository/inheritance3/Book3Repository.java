package io.gonzo.jpa.app.service.repository.inheritance3;

import io.gonzo.jpa.app.domain.inheritance3.Book3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book3Repository extends JpaRepository<Book3, Long> {
}
