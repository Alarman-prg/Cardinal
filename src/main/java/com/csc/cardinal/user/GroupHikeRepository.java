package com.csc.cardinal.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupHikeRepository extends JpaRepository<GroupHikeEntity, Long> {

    public Optional<GroupHikeEntity> findById(Long groupId);




}
