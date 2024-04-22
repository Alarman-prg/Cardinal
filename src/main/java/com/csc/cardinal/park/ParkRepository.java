package com.csc.cardinal.park;

import com.csc.cardinal.user.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ParkRepository extends JpaRepository<ParkEntity, Long> {

    public ParkEntity findById(long id);

    public ParkEntity findByName(String name);

    public List<ParkEntity> findAllByCounty(String county);

}
