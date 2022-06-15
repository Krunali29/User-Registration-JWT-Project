package com.bridgelabz.userregistration.services;

import com.bridgelabz.userregistration.dto.UserLoginDTO;
import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import com.bridgelabz.userregistration.model.UserRegistrationData;

import java.util.List;

public interface IUserRegistrationService {
    String loginUser(UserLoginDTO userLoginDTO);

    List<UserRegistrationData> getUserInfo();

    UserRegistrationData registerUser(UserRegistrationDTO userDTO);
}
