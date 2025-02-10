package com.bilal.electronic.store.ElectroMart.repositories;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bilal.electronic.store.ElectroMart.dtos.UserDTO;

public class UserDAO {

    JdbcTemplate jdbcTemplate;


    public void createUser(final UserDTO user) {
        String query = "INSERT INTO user() VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getGender());
    }

    public UserDTO updateUser(final UserDTO user, final String emailId) {
        String query = "UPDATE user SET name = ?, email = ?, password = ?, gender = ?  WHERE emailId = ?";
        jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getPassword(), user.getGender(), emailId);
        return user;
    }

    public String deleteUser(final UserDTO user, final String emailId) {
        String query = "UPDATE user SET deleted = true WHERE emailId = ?";
        int deleted = jdbcTemplate.update(query, emailId);
        if (deleted > 0) {
            return "User with the Email " + emailId + "deleted successfully!";
        } else {
            return "User with the Email " + emailId + "not found!";
        }
    }

    public List<UserDTO> getAllUsers() {
        String query = "SELECT name, email, gender FROM user";
        return jdbcTemplate.query(query, (rs, rowNum) -> new UserDTO(
            null,
            rs.getString("name"),
            rs.getString("email"),
            null,
            rs.getString("gender"),
            null
        ));
    }

    public List<UserDTO> getAllUsers(final int limit, final int offset) {
        String query = "SELECT name, email, gender FROM user LIMIT ? OFFSET ?";
        return jdbcTemplate.query(query, (rs, rowNum) -> new UserDTO(
            null,
            rs.getString("name"),
            rs.getString("email"),
            null,
            rs.getString("gender"),
            null
        ), limit, offset);
    }
}
