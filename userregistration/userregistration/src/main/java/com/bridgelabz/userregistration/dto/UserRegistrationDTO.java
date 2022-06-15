package com.bridgelabz.userregistration.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;

@Data
@ToString
public class UserRegistrationDTO {
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid First Name")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid Last Name")
    public String lastName;

    @Pattern(regexp = "^([a-z0-9-+]*)[.]{0,1}([0-9a-z]*)@([a-z]+)[.]{1}([a-z]+)$", message = "Invalid Email")
    public String emailId;

    @Pattern(regexp = "^([A-Za-z0-9]*){4,}$", message = "Password should be of min 4 digits or letters")
    public String password;

}
