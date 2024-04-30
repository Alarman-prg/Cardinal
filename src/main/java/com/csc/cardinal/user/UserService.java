package com.csc.cardinal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/***
 * @Author Jacob
 * @Author Christian
 */
@Service
public class UserService {

    private static UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Add a record to the users table
     *
     * @param user
     * @return UserEntity
     */
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    /**
     * Get all records from user table
     *
     * @return List<UserEntity>
     */
    public List<UserEntity> fetch() {
        return (List<UserEntity>) userRepository.findAll();
    }

    /**
     * Update record in users table
     *
     * @param user
     * @param id
     * @return
     */
    public UserEntity update(UserEntity user, Long id) {

        UserEntity userDB = userRepository.findById(id).get();

        if (Objects.nonNull(user.getUsername())) {
            userDB.setUsername(user.getUsername());
        }
        if (Objects.nonNull(user.getEmail())) {
            userDB.setEmail(user.getEmail());
        }
        if (Objects.nonNull(user.getPassword())) {
            userDB.setPassword(user.getPassword());
        }
        if (Objects.nonNull(user.getFirstName())) {
            userDB.setFirstName(user.getFirstName());
        }
        if (Objects.nonNull(user.getLastName())) {
            userDB.setLastName(user.getLastName());
        }
        return userRepository.save(userDB);
    }

    /**
     * Delete record from users table
     *
     * @param id
     */
    public void delete(Long id) {
        userRepository.deleteById(id);
    }


    public static UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserEntity getUsername() {
        return new UserEntity.getUsername();
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).get();
    }
}
