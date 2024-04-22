package com.csc.cardinal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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

    @GetMapping("/login")
    public String login() {
        return "/user/login";
    }

    @PostMapping("/login")
    public String processLogin(Model model) {
        return "user/user-home";
    }


}
