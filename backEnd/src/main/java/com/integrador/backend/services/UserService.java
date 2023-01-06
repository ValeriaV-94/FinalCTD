package com.integrador.backend.services;

import com.integrador.backend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> searchAllUsers();
    Optional<User> searchUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
}
