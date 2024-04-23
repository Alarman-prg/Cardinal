package com.csc.cardinal.park;


import com.csc.cardinal.user.GroupHikeEntity;
import com.csc.cardinal.user.GroupHikeRepository;
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

    @PostMapping("/parkOp")
    public ParkEntity save(@RequestBody ParkEntity parkEntity) {
        return parkService.save(parkEntity);
    }

    @GetMapping("/county")
    public String displayCounty(Model model) {
        List<GroupHikeEntity> hikeList = groupHikeRepository.findAll();
        model.addAttribute("hikeList", hikeList);
        return "park/county";
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
    ) {
        return parkService.update(parkEntity, id);
    }



    @DeleteMapping("/parkOp/{id}")
    public void delete(@PathVariable Long id) {
        parkService.delete(id);
    }



/*@PostMapping("/parks")                                            A bit of confusion when merging, this might not be necessary
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
    }*/

}