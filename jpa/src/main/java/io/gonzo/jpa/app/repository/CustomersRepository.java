package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.base.Address;
import io.gonzo.jpa.app.domain.base.Name;
import io.gonzo.jpa.app.domain.basic.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

    // Between
    //LessThan
    //LessThanEqual
    //GreaterThan
    //GreaterThanEqual
    //After
    //Before

    Optional<Customers> findDistinctByName(Name name);

    Optional<List<Customers>> findByName_FirstNameAndAddress(String name_firstName, Address address);

    Optional<List<Customers>> findByName_FirstNameOrName_LastName(String name_firstName , String name_lastName);

    Optional<Customers> findByName_FirstName(String name_firstName);

    Optional<List<Customers>> findByNameIsNull();

    Optional<List<Customers>> findByNameIsNot(Name name);

    Optional<List<Customers>> findByNameOrderByLevelDesc(Name name);

    Optional<List<Customers>> findByNameOrderByLevelAsc(Name name);

    Optional<List<Customers>> findByNameNot(Name name);

    Optional<List<Customers>> findByLevelIn(Collection<Integer> level);

    Optional<List<Customers>> findByLevelNotIn(Collection<Integer> level);

    Optional<List<Customers>> findByIsActiveTrue();

    Optional<List<Customers>> findByIsActiveFalse();

    Optional<List<Customers>> findByEmailAddressIgnoreCase(String emailAddress);

}
