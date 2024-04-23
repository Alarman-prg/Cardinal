package com.csc.cardinal.park;


import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkController {

    @Autowired
    private ParkService parkService;

    @PostMapping("/parkOp")
    public ParkEntity save(@RequestBody ParkEntity parkEntity) {
        return parkService.save(parkEntity);
    }

    @GetMapping("/parkOp/{county}")
    public List<ParkEntity> findAllCounty(@PathVariable("county") String county, Model model) {
        List<ParkEntity> parkEntityList = parkService.findAllByCounty(county);
        model.addAttribute("parkEntityList", parkEntityList);
        return parkEntityList;
    }

    @GetMapping("/parkOp/{operator}")
    public List<ParkEntity> findAllOperators(@PathVariable("operator") String operator, Model model) {
        List<ParkEntity> parkEntityList = parkService.findAllByCounty(operator);
        model.addAttribute("parkEntityList", parkEntityList);
        return parkEntityList;
    }

    @PutMapping("/parkOp/{id}")
    public ParkEntity update(
            @RequestBody ParkEntity parkEntity,
            @PathVariable Long id
    ){
        return parkService.update(parkEntity, id);
    };

    @DeleteMapping("/parkOp/{id}")
    public void delete(@PathVariable Long id){
        parkService.delete(id);
    }
}
