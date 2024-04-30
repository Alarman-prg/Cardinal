package com.csc.cardinal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GroupHikeController {

    @Autowired
    GroupHikeRepository groupHikeRepository;

    @Autowired
    GroupHikeService groupHikeService; // Declare the service

//    @PostMapping("/grouphikes")
//    public GroupHikeEntity save(@RequestBody GroupHikeEntity groupHikeEntity) {
//        return groupHikeService.save(groupHikeEntity);
//    }

    @GetMapping("/hikes")
    public String hikeHome(Model model) {
        List<GroupHikeEntity> hikeList = groupHikeRepository.findAll();
        model.addAttribute("hikeList", hikeList);
        return "hikes/hike-home";
    }

    @GetMapping("/add-hike")
    public String redirectAddHike() {
        return "redirect:/create-group-hike";
    }

    @PostMapping("/add-hike")
    public String addHike(@ModelAttribute GroupHikeEntity groupHike) {
        groupHikeService.createHike(groupHike);
        return "redirect:/county"; // Redirect to the hiking list page
    }

    @GetMapping("/create-group-hike")
    public String showCreateGroupHikeForm(Model model) {
        model.addAttribute("groupHike", new GroupHikeEntity());
        return "park/create-group-hike";
    }

    @GetMapping("/grouphikes")
    public List<GroupHikeEntity> findAll() {
        return groupHikeService.fetch();
    }

    @GetMapping("/user-home")
    public String userHome() {
        return "dashboard"; // Assuming "user-home" is the name of your HTML template
    }

}
