package com.bridgelabz.bookstoreapplication.user.service;

import com.bridgelabz.bookstoreapplication.exception.GlobalException;
import com.bridgelabz.bookstoreapplication.user.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.user.dto.ResponseDTO;
import com.bridgelabz.bookstoreapplication.user.dto.UserDTO;
import com.bridgelabz.bookstoreapplication.user.model.User;
import com.bridgelabz.bookstoreapplication.user.repository.UserRepository;
import com.bridgelabz.bookstoreapplication.util.TokenUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private ModelMapper modelMapper;
    /**
     * This method creates user registration with new user data
     * @param userDTO
     * @return ResponseDto
     */
    @Override
    public ResponseDTO createUserData(UserDTO userDTO) {

        Optional<User> isUserPresent = userRepository.findByEmailId(userDTO.getEmailId());
        if (isUserPresent.isPresent()) {
            throw new GlobalException("User Already Exists.");
        } else {
            User user = new User();
            user.createUser(userDTO);
            userRepository.save(user);
            return new ResponseDTO("User Created Successfully", user);
        }
    }

    /**
     * This method shows all user data from user repository
     * @return list of users data
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * This method shows user data by taking user id
     * @param userId
     * @return UserData
     */
    @Override
    public User getUserDataById(int userId) {
        Optional<User> isUserPresent = userRepository.findById(userId);
        if (isUserPresent.isPresent()) {
            return userRepository.findById(userId).orElseThrow(() -> new GlobalException("User Id Not Found"));
        }
        else {
            throw new GlobalException("Invalid Id");
        }
    }

    /**
     * This method updates user data by user id
     * @param userId
     * @param userDTO
     * @return ResponseDTO
     */
    @Override
    public ResponseDTO updateUserData(int userId, UserDTO userDTO) {
        User user = this.getUserDataById(userId);

        Optional<User> isUserPresent = userRepository.findById(userId);
        if (isUserPresent.isPresent()) {
            user.updateUser(userDTO);
            userRepository.save(user);
            return new ResponseDTO("User Details Successfully Updated", user);
        }
        else {
            throw new GlobalException("User is not present");
        }
    }

    /**
     * This method deletes user data by user id
     * @param userId
     * @return ResponseDTO
     */
    @Override
    public ResponseDTO deleteUserData(int userId) {
        Optional<User> isUserPresent = userRepository.findById(userId);

        if (isUserPresent.isPresent()) {
            userRepository.deleteById(userId);
            return new ResponseDTO("User Successfully Deleted", "Deleted User Id : " + userId);
        }
        else {
            throw new GlobalException("User is not Present!");
        }
    }

    /**
     * This method validates login credentials
     * @param loginDTO
     * @return ResponseDTO
     */
    @Override
    public ResponseDTO loginValidation(LoginDTO loginDTO) {
        String token;
        Optional<User> isUserPresent = userRepository.findByEmailId(loginDTO.getEmailId());

        if (isUserPresent.isPresent()) {
            String password = isUserPresent.get().getPassword();
            if (password.equals(loginDTO.getPassword())) {
                token = tokenUtil.createToken(isUserPresent.get().getUserId());
                return new ResponseDTO("User is Found", token);
            } else throw new GlobalException("Password is Wrong");
        }
        else {
            throw new GlobalException("Email Id or Password is Wrong");
        }
    }

    /**
     * This method verifies user by token
     * @param token
     * @return boolean
     */
    @Override
    public Boolean verifyUser(String token) {
        int id = tokenUtil.decodeToken(token);

        Optional<User> isUserPresent = userRepository.findById(id);
        if (isUserPresent.isPresent()) {
            isUserPresent.get().setVerify(true);
            userRepository.save(isUserPresent.get());
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method recovers password if user forgets
     * @param emailId
     * @param password
     * @return User Data
     */
    @Override
    public User forgotPassword(String emailId, String password) {
        Optional<User> isUserPresent = userRepository.findByEmailId(emailId);
        if (isUserPresent.isPresent()) {
            isUserPresent.get().setPassword(password);
            return userRepository.save(isUserPresent.get());
        } else {
            throw new GlobalException("Invalid Email");
        }
    }
}
