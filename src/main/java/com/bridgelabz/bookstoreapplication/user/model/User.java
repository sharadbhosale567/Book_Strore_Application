package com.bridgelabz.bookstoreapplication.user.model;

import com.bridgelabz.bookstoreapplication.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private LocalDate dob;
    private LocalDate registerDate;
    private Boolean verify;
    private LocalDate updatedDate;

    public void createUser(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.emailId = userDTO.getEmailId();
        this.password = userDTO.getPassword();
        this.dob = userDTO.getDob();
        this.registerDate = userDTO.getRegisterDate();
        this.verify = userDTO.getVerify();
    }

    public void updateUser(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.emailId = userDTO.getEmailId();
        this.password = userDTO.getPassword();
        this.dob = userDTO.getDob();
        this.registerDate = userDTO.getRegisterDate();
        this.verify = userDTO.getVerify();
        this.updatedDate = userDTO.getUpdatedDate();
    }

}
