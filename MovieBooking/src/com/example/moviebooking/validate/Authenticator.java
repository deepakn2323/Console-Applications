package com.example.moviebooking.validate;

import com.example.moviebooking.datalayer.TheatreRepository;
import com.example.moviebooking.datalayer.UserRepository;
import com.example.moviebooking.dto.Admin;
import com.example.moviebooking.dto.User;

public class Authenticator {
    public boolean authenticateCity(String city) {
        return TheatreRepository.getInstance().getCities().contains(city);
    }

    public User authenticateAndGetUser(String phoneNumber, String password) {
        UserRepository userRepository = UserRepository.getInstance();

        if (userRepository.authenticateUser(phoneNumber, password)) {
            return userRepository.getUserByPhoneNumber(phoneNumber);
        }
        return null;
    }

    public Admin authenticateAndGetAdmin(String name, String password) {
        return new Admin(name, password);
//        return UserRepository.getInstance().authenticateAdmin(name, password);
    }
}
