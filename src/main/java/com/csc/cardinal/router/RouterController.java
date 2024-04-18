package com.csc.cardinal.router;

import com.csc.cardinal.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RouterController {

    @GetMapping("/login")
    public String login(Model model) {
        return "user/login";
    }
    @PostMapping("/login")
    public String processLogin(Model model) {
        return "user/user-home";
    }





}
