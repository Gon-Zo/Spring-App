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

import java.util.*;

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

                            Assertions.assertEquals(_address.getAddressNumber(), address.getAddressNumber());

                            Assertions.assertEquals(_address.getCity(), address.getCity());

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
    void findByName_FirstNameOrName_LastName_success() {
        String firstName = "박";
        String lastName = "초원";

        Optional<List<Customers>> result = repository.findByName_FirstNameOrName_LastName(firstName, lastName);

        Assertions.assertEquals(result.isPresent(), Boolean.TRUE);
    }

    @Test
    void findByName_FirstNameOrName_LastName_fail() {
        String firstName = "남";
        String lastName = "도일";

        Optional<List<Customers>> result = repository.findByName_FirstNameOrName_LastName(firstName, lastName);

        Assertions.assertEquals(result.isPresent(), Boolean.TRUE);
    }


    @Test
    void findByName_FirstName() {

        String firstName = "박";

        Optional<List<Customers>> result = repository.findByName_FirstName(firstName);

        Assertions.assertEquals(result.isPresent(), Boolean.TRUE);

    }

    @Test
    void findByNameIsNull() {

        Optional<List<Customers>> result = repository.findByNameIsNull();

        Assertions.assertEquals(result.isPresent(), Boolean.TRUE);

    }

    @Test
    void findByNameIsNot() {

        Name name = Name.builder()
                .firstName("김")
                .lastName("호수")
                .build();

        Optional<List<Customers>> result = repository.findByNameIsNot(name);

        Assertions.assertEquals(result.isPresent(), Boolean.TRUE);

    }

    @Test
    void findByNameOrderByLevelDesc() {

        Name name = Name.builder()
                .firstName("김")
                .lastName("호수")
                .build();

        Optional<List<Customers>> result = repository.findByNameOrderByLevelDesc(name);

        Assertions.assertEquals(result.isPresent(), Boolean.TRUE);

    }

    @Test
    void findByNameOrderByLevelAsc() {
        Name name = Name.builder()
                .firstName("김")
                .lastName("호수")
                .build();

        Optional<List<Customers>> result = repository.findByNameOrderByLevelAsc(name);

        Assertions.assertEquals(result.isPresent(), Boolean.TRUE);
    }

    @Test
    void findByNameNot() {

        Name name = Name.builder()
                .firstName("김")
                .lastName("호수")
                .build();

        Optional<List<Customers>> data = repository.findByNameNot(name);

        Assertions.assertEquals(data.isPresent() , Boolean.TRUE);
    }

    @Test
    void findByLevelIn() {
        Collection<Integer> levelList = Arrays.asList(3,5);

        Optional<List<Customers>> data = repository.findByLevelIn(levelList);

        Assertions.assertEquals(data.isPresent() , Boolean.TRUE);
    }

    @Test
    void findByLevelNotIn() {
        Collection<Integer> levelList = Collections.singletonList(3);

        Optional<List<Customers>> data = repository.findByLevelNotIn(levelList);

        Assertions.assertEquals(data.isPresent() , Boolean.TRUE);
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
