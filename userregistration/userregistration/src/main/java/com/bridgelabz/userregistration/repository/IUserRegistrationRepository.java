package com.bridgelabz.userregistration.repository;

import com.bridgelabz.userregistration.model.UserRegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserRegistrationRepository extends JpaRepository<UserRegistrationData, Integer> {

    @Query(value = "select *from user_registration where email_id = :emailId", nativeQuery = true)
    List<UserRegistrationData> findByEmailId(String emailId);

    Optional<UserRegistrationData> findByEmailIdAndPassword(String emailId, String password);
}

