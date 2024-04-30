package com.csc.cardinal.user;

import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SessionAttributes("userEntity")
@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        return "redirect:login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("username") String usernameHtml, HttpSession httpSession) {
        UserEntity userEntity = UserService.findByUsername(usernameHtml);
        long userId = userEntity.getId();
        String username = userEntity.getUsername();
        String email = userEntity.getEmail();
        String firstName = userEntity.getFirstName();
        String lastName = userEntity.getLastName();

        httpSession.setAttribute("userId", userId); // Store user ID in session
        httpSession.setAttribute("username", username);
        httpSession.setAttribute("email", email);
        httpSession.setAttribute("firstName", firstName);
        httpSession.setAttribute("lastName", lastName);

        return "redirect:dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession httpSession, Model model) {
        long userId = (Long) httpSession.getAttribute("userId");
        String username = (String) httpSession.getAttribute("username");
        String email = (String) httpSession.getAttribute("email");
        String firstName = (String) httpSession.getAttribute("firstName");
        String lastName = (String) httpSession.getAttribute("lastName");

        model.addAttribute("sessionId", userId);
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "/user/dashboard";
    }

    @PostMapping("/users")
    public UserEntity save(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @GetMapping("/users")
    public List<UserEntity> fetch() {
        return userService.fetch();
    }

    @PutMapping("/users/{id}")
    public UserEntity update(
            @RequestBody UserEntity userEntity,
            @PathVariable Long id
    ){
        return userService.update(userEntity, id);
    };

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }




}
