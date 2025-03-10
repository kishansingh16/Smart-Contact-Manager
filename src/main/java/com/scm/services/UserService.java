package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> updateUser(User userId);
    void deleteUser(Long id);
    boolean isUserExist(Long userId);
    boolean isUserExistByEmail(String email);

    List<User> getAllUsers();
}
