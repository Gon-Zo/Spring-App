package io.gonzo.jpa.app.service.repository.inheritance2;

import io.gonzo.jpa.app.domain.inheritance2.Book2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2Repository extends JpaRepository<Book2, Long> {
}
