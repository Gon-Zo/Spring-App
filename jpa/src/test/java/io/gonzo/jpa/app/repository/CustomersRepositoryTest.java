package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.base.Address;
import io.gonzo.jpa.app.domain.base.Name;
import io.gonzo.jpa.app.domain.basic.Customers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("h2")
@ExtendWith(SpringExtension.class)
class CustomersRepositoryTest {

    @Autowired
    private CustomersRepository repository;

    @Test
    void findDistinctByName_success() {

        String firstName = "박";
        String lastName = "퇴물";

        Name name = Name.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        Optional<Customers> distinctNames = repository.findDistinctByName(name);

        distinctNames.ifPresent(customers -> {
            Name customerName = customers.getName();
            Assertions.assertEquals(customerName.getFirstName(), firstName);
            Assertions.assertEquals(customerName.getLastName(), lastName);
        });

    }

    @Test
    void findDistinctByName_fail() {

        String firstName = "최";
        String lastName = "퇴물";

        Name name = Name.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        Optional<Customers> distinctNames = repository.findDistinctByName(name);

        boolean isPresent = distinctNames.isPresent();

        if (!isPresent) {
            throw new NullPointerException();
        }

        distinctNames.ifPresent(customers -> {
            Name customerName = customers.getName();
            Assertions.assertEquals(customerName.getFirstName(), firstName);
            Assertions.assertEquals(customerName.getLastName(), lastName);
        });

    }

    @Test
    void findByName_FirstNameAndAddress_success() {

        String addressCode = "UCT-001";

        Integer addressNumber = 41000;

        String city = "경기도";

        Address address = Address.builder()
                .addressCode(addressCode)
                .addressNumber(addressNumber)
                .city(city)
                .build();

        String firstName = "박";

        Optional<List<Customers>> foundCustomerList = repository.findByName_FirstNameAndAddress(firstName, address);

        foundCustomerList
                .ifPresent(
                        customerList -> customerList.forEach(value -> {

                            Address _address = value.getAddress();

                            Assertions.assertEquals(_address.getAddressCode(), address.getAddressCode());

                            Assertions.assertEquals(_address.getAddressNumber() , address.getAddressNumber());

                            Assertions.assertEquals(_address.getCity() , address.getCity());

                            Assertions.assertEquals(value.getName().getFirstName(), firstName);

                        })
                );

    }

    @Test
    void findByName_FirstNameAndAddress_fail() {

        String addressCode = "UCT-005";

        Integer addressNumber = 41000;

        String city = "경기도";

        Address address = Address.builder()
                .addressCode(addressCode)
                .addressNumber(addressNumber)
                .city(city)
                .build();

        String firstName = "박";

        Optional<List<Customers>> foundCustomerList = repository.findByName_FirstNameAndAddress(firstName, address);

        boolean isPresent = foundCustomerList.isPresent();

        if (!isPresent) {
            throw new NullPointerException();
        }

        foundCustomerList
                .ifPresent(
                        customerList -> customerList.forEach(value -> {

                            Address _address = value.getAddress();

                            Assertions.assertEquals(_address.getAddressCode(), address.getAddressCode());

                            Assertions.assertEquals(_address.getAddressNumber(), address.getAddressNumber());

                            Assertions.assertEquals(_address.getCity(), address.getCity());

                            Assertions.assertEquals(value.getName().getFirstName(), firstName);

                        })
                );

    }

    @Test
    void findByName_FirstNameOrName_LastName() {
    }

    @Test
    void findByName_FirstName() {
    }

    @Test
    void findByNameIsNull() {
    }

    @Test
    void findByNameIsNot() {
    }

    @Test
    void findByNameOrderByLevelDesc() {
    }

    @Test
    void findByNameOrderByLevelAsc() {
    }

    @Test
    void findByNameNot() {
    }

    @Test
    void findByLevelIn() {
    }

    @Test
    void findByLevelNotIn() {
    }

    @Test
    void findByIsActiveTrue() {
    }

    @Test
    void findByIsActiveFalse() {
    }

    @Test
    void findByEmailAddressIgnoreCase() {
    }
}
