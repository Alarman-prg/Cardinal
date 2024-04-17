package org.csc340.cardinalv2.users.service;

import org.csc340.cardinalv2.users.entity.UsersEntity;
import org.csc340.cardinalv2.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UsersEntity> getUser = usersRepository.findByUsername(username);
        UserDetails user = new User(username, getUser.get().getPassword(),
                true, true, true, true, AuthorityUtils.createAuthorityList(getUser.get().getRole()));

        return user;
    }
}
