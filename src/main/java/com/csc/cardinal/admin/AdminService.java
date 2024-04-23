package com.csc.cardinal.admin;

import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserRepository;
import com.csc.cardinal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public AdminService() {
    }

    public void createUser(UserEntity user) {
        System.out.println("Creating user account" + user.toString());
        userService.save(user);
    }

    public void deleteUser(long id) {
        System.out.println("User " + id + " to be deleted");

        userService.delete(id);

    }

    public void deleteByUsername(String username) {
        System.out.println("User " + username + " to be deleted");

        if (userRepository.findByUsername(username) != null) {
            UserEntity user = userService.findByUsername(username);
            int id = user.getId();
            deleteUser(id);
        } else {
            System.out.println("User " + username + " not found");
        }

    }

    public long userRepoLength () {
        return userRepository.count();
    }


}
