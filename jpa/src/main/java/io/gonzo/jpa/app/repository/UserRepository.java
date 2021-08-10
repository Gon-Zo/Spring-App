package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.repository.support.UserRepositorySupport;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositorySupport {

    @Override
    @EntityGraph(attributePaths = {"groups"})
    List<User> findAll();

//    @Override
//    List<UserDTO> findAll();
}
