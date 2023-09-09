package com.splitwise.services;

import com.splitwise.models.User;
import com.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String phoneNumber, String userName, String password){
        User user = new User();
        user.setName(userName);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        user.setPassword(encodedPassword);
        user.setPhoneNumber(phoneNumber);
        return this.userRepository.save(user);
    }

    public void login(String userName, String rawPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<User> optionalUser = this.userRepository.findByName(userName);
        if(optionalUser.isEmpty()){
            System.out.println("User doesn;t exist");
            return;
        }
        User user = optionalUser.get();
        if(encoder.matches(rawPassword, user.getPassword())){
            // login the user
        } else {
            // show error to the user
        }

    }
}
