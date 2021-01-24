package io.gonzo.jpa.app.service.repository.inheritance2;

import io.gonzo.jpa.app.domain.inheritance2.Item2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item2Repository extends JpaRepository<Item2, Long> {
}
