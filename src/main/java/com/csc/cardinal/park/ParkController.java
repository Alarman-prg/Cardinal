package com.csc.cardinal.park;


import com.csc.cardinal.user.GroupHikeEntity;
import com.csc.cardinal.user.GroupHikeRepository;
import com.csc.cardinal.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/***
 * @Author Andrew & Jacob
 */
@Controller
public class ParkController {

    @Autowired
    private ParkService parkService;

    @Autowired
    private GroupHikeRepository groupHikeRepository;
    @Autowired
    private ParkRepository parkRepository;

    @PostMapping("/addPark")
    public String save(@RequestBody ParkEntity parkEntity) {
        parkService.save(parkEntity);
        return "redirect:/park/parkOp";
    }

    @GetMapping("/opLogin")
    public String getHome(Model model) {
        List<ParkEntity> parkList = parkRepository.findAll();
        model.addAttribute("parkList", parkList);
        return "park/parkOp";
    }

    @GetMapping("/create-park")
    public String showCreateParkForm(Model model) {
        model.addAttribute("park", new ParkEntity());
        return "park/create-park";
    }

    @GetMapping("/group-hike")
    public String displayCounty(Model model) {
        List<GroupHikeEntity> hikeList = groupHikeRepository.findAll();
        model.addAttribute("hikeList", hikeList);
        return "park/group-hike";
    }

    @GetMapping("/getPark")
    public ParkEntity findById(@RequestParam int id) {
        return parkService.findById(id);
    }

    @GetMapping("park/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        ParkEntity park = parkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        model.addAttribute("park", park);
        return "park/park-edit"; // Return the name of your update form template
    }

    @GetMapping("park/update/{id}")
    public String updatePark(@PathVariable("id") Long id, @ModelAttribute("park") ParkEntity updatedPark) {
      //  Optional<ParkEntity> park = parkRepository.findById(id);
        parkService.update(updatedPark, id);

        return "park/park-edit";
    }

    @DeleteMapping("/park/delete/{id}")
    public void delete(@PathVariable Long id) {
        parkService.delete(id);
    }

}