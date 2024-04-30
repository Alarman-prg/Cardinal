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


    private static GroupHikeService groupHikeService;
    @Autowired
    public void setGroupHikeService(GroupHikeService groupHikeService) {
        this.groupHikeService = groupHikeService;
    }

    private static UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hikes")
    public String hikeHome(Model model) {
        List<GroupHikeEntity> hikeList = groupHikeRepository.findAll();
        model.addAttribute("hikeList", hikeList);
        return "park/hike-home";
    }

    @GetMapping("/add-hike")
    public String redirectAddHike() {
        return "redirect:/create-group-hike";
    }

    @PostMapping("/add-hike")
    public String addHike(@ModelAttribute GroupHikeEntity groupHike) {
        groupHikeService.createHike(groupHike);
        return "redirect:/group-hike"; // Redirect to the hiking list page
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
        return "user/dashboard";
    }

    @GetMapping("/hikes/{groupId}/confirm")
    public String confirmJoinHike(@PathVariable("groupId") Long hikeId, Model model) {
        // Pass the hikeId to the view
        model.addAttribute("groupId", hikeId);
        return "/park/confirm-join-hike";
    }

    @PostMapping("/hikes/{groupId}/join")
    public String joinHike(@PathVariable("groupId") Long hikeId, HttpSession httpSession) {
        UserEntity user = (UserEntity) httpSession.getAttribute("user");
        groupHikeService.joinHike(hikeId, user);
        return "redirect:/group-hike";
    }

}
