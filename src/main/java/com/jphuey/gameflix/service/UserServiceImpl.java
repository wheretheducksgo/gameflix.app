package com.jphuey.gameflix.service;

import com.jphuey.gameflix.model.Role;
import com.jphuey.gameflix.model.User;
import com.jphuey.gameflix.repository.RoleRepository;
import com.jphuey.gameflix.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) throws Exception {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new Exception("Username already taken");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("Email already taken");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new Exception("ROLE_USER not found"));

        user.setRoles(new HashSet<>());
        user.getRoles().add(userRole);

        return userRepository.save(user);
    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}