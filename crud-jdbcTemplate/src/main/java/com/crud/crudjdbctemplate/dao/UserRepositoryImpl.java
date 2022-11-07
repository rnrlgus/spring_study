package com.crud.crudjdbctemplate.dao;


import com.crud.crudjdbctemplate.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_QUERY = "INSERT INTO USER(id, name, email) values(?, ?, ?)";
    private static final String UPDATE_USER_BY_ID_QUERY = "UPDATE USER SET name=? WHERE ID=?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USER WHERE ID=?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM USER WHERE ID=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM USER";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getName(), user.getEmail());
        return user;
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) ->{
            return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
        });
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"),rs.getString("name"), rs.getString("email"));
        });
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_QUERY, user.getName(), user.getId());
        return user;
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "user got deleted with id: " + id;
    }
}
