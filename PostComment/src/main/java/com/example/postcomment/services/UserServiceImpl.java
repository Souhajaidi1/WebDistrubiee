package com.example.postcomment.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.postcomment.entities.User;
import com.example.postcomment.interfaces.IUserService;
import com.example.postcomment.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    @Override
    public User updateUser(User user, Long userID) {

        user.setUserId(userID);
        return userRepository.save(user);

    }

    
}