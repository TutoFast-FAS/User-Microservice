package com.api.safetech.userservice.user.domain.service;

import com.api.safetech.userservice.user.domain.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long userId);
    User getByEmail(String email);
    List<User> getByFirstNameAndLastName(String firstName, String lastName);
    User create(User user);
    User update(Long userId, User user);
    User delete(Long userId);
}