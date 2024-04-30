package com.csc.cardinal.admin;

import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserRepository;
import com.csc.cardinal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

/***
 * @Author Jacob Greene
 */
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

    @GetMapping("/admin-reports")
    public String getReports(Model model) {
        model.addAttribute("userCount", adminService.userRepoLength());
        model.addAttribute("parkCount", adminService.parkRepoLength());
        return "admin/admin-reports";
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
    public String postDeleteById(@RequestParam("id") Long id) {
        adminService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user-delete-id")
    public String getDeleteById(@RequestParam("id") Long id) {
        adminService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/user-delete-username")
    public String deleteByUsername(@RequestParam("username") String username) {
        adminService.deleteByUsername(username);
        return "redirect:/admin";
    }

}
