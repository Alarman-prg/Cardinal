package com.csc.cardinal.park;


import com.csc.cardinal.user.GroupHikeEntity;
import com.csc.cardinal.user.GroupHikeRepository;
import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ParkController {

    @Autowired
    private ParkService parkService;

    @Autowired
    private GroupHikeRepository groupHikeRepository;

    @GetMapping("/county")
    public String displayCounty(Model model) {
        List<GroupHikeEntity> hikeList = groupHikeRepository.findAll();
        model.addAttribute("hikeList", hikeList);
        return "park/county";
    }

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
