package com.bridgelabz.userregistration.controller;

import com.bridgelabz.userregistration.dto.ResponseDTO;
import com.bridgelabz.userregistration.dto.UserLoginDTO;
import com.bridgelabz.userregistration.dto.UserRegistrationDTO;
import com.bridgelabz.userregistration.model.UserRegistrationData;
import com.bridgelabz.userregistration.services.UserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userregistration")
@Slf4j
public class UserRegistrationController {
    @Autowired
    UserRegistrationService IUserRegistrationService;

    /**
     * Method :- Method for User Login.
     *
     * @param  :- passing UserRegistrationDTO as Input
     * @return :- Returning Token.
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("inside userLogin Controller Method");
        ResponseDTO responseDTO = new ResponseDTO("User Logged In Successfully!!!",
                IUserRegistrationService.loginUser(userLoginDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    /**
     * Method :- Method for User Registration.
     *
     * @param userDTO :- passing UserRegistrationDTO as Input
     * @return :- Returning UserData
     */
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserRegistrationDTO userDTO) {
        UserRegistrationData userData = null;
        log.info("inside registerUser Controller Method");
        userData = IUserRegistrationService.registerUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Added Successfully.", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);

    }

    /**
     * Method :- Method to Get All User Records.
     *
     * @return :- Returning  All User Records Present in Database.
     */
    @GetMapping("/getUserInfo")
    public ResponseEntity<ResponseDTO> getUserInfo() {
        List<UserRegistrationData> userDataList = null;
        userDataList = IUserRegistrationService.getUserInfo();
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info ", userDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}


