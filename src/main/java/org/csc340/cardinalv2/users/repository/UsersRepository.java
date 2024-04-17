package org.csc340.cardinalv2.users.repository;

import org.apache.catalina.User;
import org.csc340.cardinalv2.users.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {

    Optional<UsersEntity> findById(@Param("id") Integer id);

    Optional<UsersEntity> findByUsername(@Param("username") String username);

}
