package com.lldprojects.splitwise.service;

import com.lldprojects.splitwise.models.User;
import com.lldprojects.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public User updateUserService(Long id, String newPassword) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(newPassword);
            return userRepository.save(user);
        }
        System.out.println("User with id " + id + "is not present!");
        return null;
    }
}
