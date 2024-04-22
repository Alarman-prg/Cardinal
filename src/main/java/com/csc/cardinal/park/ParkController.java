package com.csc.cardinal.park;


import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkController {

    @Autowired
    private ParkService parkService;

    @PostMapping("/parks")
    public ParkEntity save(@RequestBody ParkEntity parkEntity) {
        return parkService.save(parkEntity);
    }

    @GetMapping("/parks")
    public List<ParkEntity> fetch() {
        return parkService.fetch();
    }

    @PutMapping("/parks/{id}")
    public ParkEntity update(
            @RequestBody ParkEntity parkEntity,
            @PathVariable Long id
    ){
        return parkService.update(parkEntity, id);
    };

    @DeleteMapping("/parks/{id}")
    public void delete(@PathVariable Long id){
        parkService.delete(id);
    }
}
