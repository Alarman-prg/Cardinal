package com.csc.cardinal.park;


import com.csc.cardinal.park.ParkEntity;
import com.csc.cardinal.park.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ParkService {

    @Autowired
    ParkRepository parkRepository;

    /**
     * Add a record to the parks table
     *
     * @param park
     * @return ParkEntity
     */
    public ParkEntity save(ParkEntity park) {
        return parkRepository.save(park);
    }

    /**
     * Get all records from parks table
     *
     * @return List<ParkEntity>
     */
    public List<ParkEntity> fetch() {
        return (List<ParkEntity>) parkRepository.findAll();
    }

    /**
     * Update record in users table
     *
     * @param park
     * @param id
     * @return
     */
    public ParkEntity update(ParkEntity park, Long id) {

        ParkEntity parkDB = parkRepository.findById(id).get();

        if (Objects.nonNull(park.getName())) {
            parkDB.setName(park.getName());
        }
        if (Objects.nonNull(park.getDescription())) {
            parkDB.setDescription(park.getDescription());
        }
        if (Objects.nonNull(park.getRating_Total())) {
            parkDB.setRating_Total(park.getRating_Total());
        }
        if (Objects.nonNull(park.getRating_Count())) {
            parkDB.setRating_Count(park.getRating_Count());
        }
        if (Objects.nonNull(park.getLength())) {
            parkDB.setLength(park.getLength());
        }
        return parkRepository.save(parkDB);
    }

    /**
     * Delete record from users table
     *
     * @param id
     */
    public void delete(Long id) {
        parkRepository.deleteById(id);
    }
    public ParkEntity findById(long id){
        return parkRepository.findById(id);
    }

    public ParkEntity findByName(String name) {
        return parkRepository.findByName(name);
    }
    public List<ParkEntity> findAllByCounty(String county){
        return parkRepository.findAllByCounty(county);
    }
}

