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
    public String admin(Model model) {
        // Assuming userRepository is autowired
        List<UserEntity> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "admin/admin-home";
    }

    @PostMapping("/admin")
    public String adminPost() {
        return "admin/admin-home";
    }

    @PostMapping("/user-create")
    public String createUser(@ModelAttribute UserEntity user) {
        adminService.createUser(user);
        return "admin/user-created";
    }

    @PostMapping("/user-delete")
    public String create(@RequestParam("id") Long id) {
        adminService.deleteUser(id);
        return "admin/user-deleted";
    }


}
