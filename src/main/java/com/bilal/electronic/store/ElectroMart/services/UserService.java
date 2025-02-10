package com.bilal.electronic.store.ElectroMart.services;

import java.util.List;

import com.bilal.electronic.store.ElectroMart.dtos.UserDTO;

public interface UserService {
    // Create
    UserDTO createUser(UserDTO user);

    // Update
    UserDTO updateUser(UserDTO user, String email);

    // Delete
    String deleteUser(UserDTO user, String email);

    // get All
    List<UserDTO> getAllUsers();

    // get single
    UserDTO getUserById(String id);

    // get single user by email id
    UserDTO getUserByEmailId(String emailId);

    // search user
    UserDTO searchUser(String keyword);
}
