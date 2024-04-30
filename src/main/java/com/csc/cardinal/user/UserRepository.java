package com.csc.cardinal.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/***
 * @Author Jacob
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findById(long id);

    public UserEntity findByEmail(String email);

    public UserEntity findByUsername(String username);

    public List<UserEntity> findAllByUsername(String username);

}
