package com.csc.cardinal.dataLoading;

import com.csc.cardinal.user.UserEntity;
import com.csc.cardinal.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserDataLoading implements CommandLineRunner {


    private static UserRepository userRepository;

    @Autowired
    public DefaultUserDataLoading(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert default values into the database
        create("jacob", "email@email.com", "password", "Jacob", "Greene");
        create("andrew", "email@email.com", "password", "Andrew", "Nice");
        create("christian", "email@email.com", "password", "Christian", "Wilson");
    }

    public void create(String username, String email, String password, String firstName, String lastName) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
    }
}
