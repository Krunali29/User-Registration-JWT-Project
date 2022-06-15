package com.bridgelabz.userregistration.model;

import com.bridgelabz.userregistration.dto.UserLoginDTO;
import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user_registration")
public class UserRegistrationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id")

    private int userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;

    public UserRegistrationData(){

    }
    public UserRegistrationData(UserRegistrationDTO UserRegistrationDTO) {

        this.firstName = UserRegistrationDTO.firstName;
        this.lastName = UserRegistrationDTO.lastName;
        this.emailId = UserRegistrationDTO.emailId;
        this.password = UserRegistrationDTO.password;
    }

    public UserRegistrationData(UserLoginDTO userLoginDTO) {
        this.emailId = userLoginDTO.emailId;
        this.password = userLoginDTO.password;
    }
}