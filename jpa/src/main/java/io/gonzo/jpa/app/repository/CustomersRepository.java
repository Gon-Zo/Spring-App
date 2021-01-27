package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.basic.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
}
