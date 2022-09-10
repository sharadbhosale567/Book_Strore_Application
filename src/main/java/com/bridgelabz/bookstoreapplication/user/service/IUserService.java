package com.bridgelabz.bookstoreapplication.user.service;

import com.bridgelabz.bookstoreapplication.user.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.user.dto.ResponseDTO;
import com.bridgelabz.bookstoreapplication.user.dto.UserDTO;
import com.bridgelabz.bookstoreapplication.user.model.User;

import java.util.List;

public interface IUserService {
    public ResponseDTO createUserData(UserDTO userDTO);

    public List<User> getAllUsers();

    public ResponseDTO updateUserData(int userId, UserDTO userDTO);

    public ResponseDTO deleteUserData(int userId);

    public User getUserDataById(int userId);

    public ResponseDTO loginValidation(LoginDTO loginDTO);

    public Boolean verifyUser(String token);

    User forgotPassword(String emailId, String password);
}
