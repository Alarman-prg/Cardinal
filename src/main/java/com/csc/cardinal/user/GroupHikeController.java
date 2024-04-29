package com.csc.cardinal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class GroupHikeController {

    @Autowired
    GroupHikeRepository groupHikeRepository;

    @Autowired
    GroupHikeService groupHikeService; // Declare the service

    @Autowired
    private UserService userService;

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
        return "redirect:/county";
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
        return "user/user-home";
    }

    @PostMapping("/{id}/join")
    public String joinHike(@PathVariable("id") int hikeId, RedirectAttributes redirectAttributes) {
        // Get the currently logged-in user
        UserEntity user = userService.getUsername();

        // Join the hike
        groupHikeService.joinHike(hikeId, user);

        // Redirect to the hike details page or any other page
        return "redirect:/county";
    }


}
