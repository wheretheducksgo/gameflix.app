package com.jphuey.gameflix.service;

import com.jphuey.gameflix.model.User;

public interface UserService {

    User registerUser(User user) throws Exception;

    boolean usernameExists(String username);

    boolean emailExists(String email);
}