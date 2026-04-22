package com.praktikumDB.deploy.service;

import com.praktikumDB.deploy.model.User;
import com.praktikumDB.deploy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User addUser (User Request) {
        return userRepository.save(Request);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElse (null);
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User updateUser (String id, User request) {
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser != null){
            existingUser.setName(request.getName());
            existingUser.setNim(request.getNim());
            return userRepository.save(existingUser);

        }
        return null;
    }
}
