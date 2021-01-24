package io.gonzo.jpa.app.service.repository.inheritance1;

import io.gonzo.jpa.app.domain.inheritance1.Item1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item1Repository extends JpaRepository<Item1 , Long> {
}
