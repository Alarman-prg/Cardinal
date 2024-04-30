package com.csc.cardinal.admin;

import com.csc.cardinal.park.ParkRepository;
import com.csc.cardinal.park.ParkService;
import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserRepository;
import com.csc.cardinal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * @Author Jacob Greene
 */
@Service
public class AdminService {

    private UserRepository userRepository;
    @Autowired
    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private ParkRepository parkRepository;
    @Autowired
    public void setParkRepository(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    private ParkService parkService;
    @Autowired
    public void setParkService(ParkService parkService) {
        this.parkService = parkService;
    }

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

    public long parkRepoLength () {
        return parkRepository.count();
    }

}
