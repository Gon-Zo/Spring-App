package io.gonzo.jpa.app.service.repository.inheritance1;

import io.gonzo.jpa.app.domain.inheritance1.Book1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book1Repository extends JpaRepository<Book1 , Long> {
}
