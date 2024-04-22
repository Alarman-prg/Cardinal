package com.csc.cardinal.admin;

import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminService adminService;

    @GetMapping("/admin")
    public String getHome() {
        return "admin/admin-home";
    }

    @GetMapping("/add-user")
    public String redirectAddUser() {
        return "admin/admin-home";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute UserEntity user) {
        adminService.createUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/user-delete-id")
    public String deleteById(@RequestParam("id") Long id) {
        adminService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping("user-delete-username")
    public String deleteByUsername(@RequestParam("username") String username) {
        adminService.deleteByUsername(username);
        return "redirect:/admin";
    }






























    // OLD 4/21/24 8:37pm

//    @GetMapping("/admin")
//    public String admin(Model model) {
//        // Assuming userRepository is autowired
//        List<UserEntity> userList = userRepository.findAll();
//        model.addAttribute("userList", userList);
//        return "admin/admin-home";
//    }
//
//    @PostMapping("/admin")
//    public String adminPost() {
//        return "admin/admin-home";
//    }
//
//    @PostMapping("/user-create")
//    public String createUser(@ModelAttribute UserEntity user) {
//        adminService.createUser(user);
//        return "admin/user-created";
//    }
//

}
