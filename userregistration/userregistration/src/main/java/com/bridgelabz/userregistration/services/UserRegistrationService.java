package com.bridgelabz.userregistration.services;

import com.bridgelabz.userregistration.dto.UserLoginDTO;
import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import com.bridgelabz.userregistration.model.UserRegistrationData;
import com.bridgelabz.userregistration.repository.IUserRegistrationRepository;
import com.bridgelabz.userregistration.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class UserRegistrationService implements IUserRegistrationService {

    @Autowired
    private IUserRegistrationRepository iUserRegistrationRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenUtil tokenUtil;

    /**
     * Method :- Method for User Login.
     */
    @Override
    public String loginUser(UserLoginDTO userLoginDTO) {
        UserRegistrationData userData = null;
        userData = new UserRegistrationData(userLoginDTO);
        String token = tokenUtil.createToken(userData.getUserId());
        log.info("LoginUser Service Method Successfully executed");
        String message = "Logged in Successfully!! Your token is : " + token;
        return message;

    }

    /**
     * Method :- Method for User Registration.
     */
    @Override
    public UserRegistrationData registerUser(UserRegistrationDTO userDTO) {

        String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        log.info("registerUser Service Method Successfully executed");
        UserRegistrationData userData = null;
        userData = new UserRegistrationData(userDTO);
        iUserRegistrationRepository.save(userData);
        return userData;
    }

    /**
     * Method :- Method to Get All User Records.
     */
    @Override
    public List<UserRegistrationData> getUserInfo() {
        log.info("getUserInfo Service Method Successfully executed");
        return iUserRegistrationRepository.findAll();
    }

}