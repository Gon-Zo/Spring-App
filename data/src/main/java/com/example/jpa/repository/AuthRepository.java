package com.example.jpa.repository;

import com.example.jpa.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    @Override
    List<Auth> findAll();

    <T> Collection<T> findByAuthName(String authName, Class<T> type);

//    @Modifying
////    @Query("update Auth auth set auth.authName = :authName where auth.id = :id")
//    long setFixedAuthNameFor(@Param("authName") String authName, @Param("id") Long id);
//
//    @Modifying
////    @Query("delete from Auth auth  where auth.authName = :authName")
//    void deleteByAuthName(@Param("authName") String authName);
//
//    @Override
////    @Query("select auth from Auth auth where auth.id = :id")
//    Optional<Auth> findById(@Param("id") Long id);

    @Query(value = "select auth from Auth auth where auth.authName like %?1", nativeQuery = true)
    List<Auth> findByAuthNameEndsWith(String authName);

//    @Query("select auth from Auth auth where auth.authName =: authName")
//    List<Auth> findByAuthName(String authName, JpaSort sort);
//
}
