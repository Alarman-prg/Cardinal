package com.csc.cardinal.admin;

import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserRepository;
import com.csc.cardinal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminService adminService;

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String getHome(Model model) {
        List<UserEntity> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "admin/admin-home";
    }

    @GetMapping("admin/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        model.addAttribute("user", user);
        return "admin/admin-edit"; // Return the name of your update form template
    }

    @PostMapping("admin/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") UserEntity updatedUser) {
        Optional<UserEntity> user = userRepository.findById(id);
        userService.update(updatedUser, id);

        return "redirect:/admin";
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
