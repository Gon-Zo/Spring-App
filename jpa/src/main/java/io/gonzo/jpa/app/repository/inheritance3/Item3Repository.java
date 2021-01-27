package io.gonzo.jpa.app.repository.inheritance3;

import io.gonzo.jpa.app.domain.inheritance3.Item3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item3Repository extends JpaRepository<Item3, Long> {
}
