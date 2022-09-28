package com.chidiudo.blog.augustblog.security;

import com.chidiudo.blog.augustblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

}
