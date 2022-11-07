package com.crud.crudjdbctemplate.dao;

import com.crud.crudjdbctemplate.domain.User;

import java.util.List;

public interface UserRepository {

    // C
    User saveUser(User user);

    // R
    User getById(int id);

    List<User> allUsers();

    // U
    User updateUser(User user);

    // D
    String deleteById(int id);

}
