package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.base.CustomPK;
import io.gonzo.jpa.app.domain.basic.Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomRepository extends JpaRepository<Custom, CustomPK> {

    Optional<List<Custom>> findByCustomPK_Email(String email);

    Collection<CustomOnly> findByCustomPK_Url(String url);

    Optional<List<Custom>> findByContentContaining(String content);

    Optional<List<Custom>> findByContentLike(String content);
}
