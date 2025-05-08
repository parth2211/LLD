package com.lldprojects.splitwise.service;

import com.lldprojects.splitwise.models.User;
import com.lldprojects.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUserService(String username, String phoneNo, String password){
        User user = new User();
        user.setUsername(username);
        user.setPhoneNo(phoneNo);
        user.setPassword(password);

        return userRepository.save(user);
    }
}
