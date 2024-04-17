package org.csc340.cardinalv2.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsersController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String handleRequest(@RequestParam(name = "continue", required = false) String continueParam) {
        return "home"; // Return the name of your view/template
    }

}
