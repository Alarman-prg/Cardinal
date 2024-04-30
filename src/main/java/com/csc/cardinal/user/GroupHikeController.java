package com.csc.cardinal.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GroupHikeController {

    @Autowired
    GroupHikeRepository groupHikeRepository;

    @Autowired
    GroupHikeService groupHikeService;

    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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

    @PostMapping("/hikes/{id}/join")
    public String joinHike(@PathVariable("id") Long hikeId, RedirectAttributes redirectAttributes, HttpSession httpSession) {
        Long userId = (Long) httpSession.getAttribute("userId");

        UserEntity user = userService.findById(userId);

        // Join the hike
        groupHikeService.joinHike(hikeId, user);

        return "redirect:/county";
    }

}
