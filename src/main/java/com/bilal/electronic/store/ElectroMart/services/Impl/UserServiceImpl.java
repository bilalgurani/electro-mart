package com.bilal.electronic.store.ElectroMart.services.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bilal.electronic.store.ElectroMart.dtos.UserDTO;
import com.bilal.electronic.store.ElectroMart.repositories.UserDAO;
import com.bilal.electronic.store.ElectroMart.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    UserDAO userDAO;
    @Override
    public UserDTO createUser(UserDTO user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        userDAO.createUser(user);
        return user;
    }

    @Override
    public UserDTO updateUser(final UserDTO user, final String email) {
        UserDTO updatedUser = userDAO.updateUser(user, email);
        return updatedUser;
    }

    @Override
    public String deleteUser(final UserDTO user, final String email) {
        return userDAO.deleteUser(user, email);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public UserDTO getUserById(final String id) {
        return null;
    }

    @Override
    public UserDTO getUserByEmailId(final String emailId) {
        return null;
    }

    @Override
    public UserDTO searchUser(final String keyword) {
        return null;
    }
}
