package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;
import com.scm.helpers.ResourceNotFoundException;

@Service // ✅ Marks this class as a Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class); // ✅ Corrected logger

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) { // ✅ Changed String to Long
        logger.info("Fetching user by ID: {}", id);
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        logger.info("Updating user: {}", user);
        
        User existingUser = userRepo.findById(user.getUserId()) // ✅ Ensure getUserId() returns Long
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setProfilePic(user.getProfilePic());
        existingUser.setAbout(user.getAbout());
        existingUser.setEnabled(user.isEnabled());
        existingUser.setEmailVerified(user.isEmailVerified());
        existingUser.setPhoneVerified(user.isPhoneVerified());
        existingUser.setProvider(user.getProvider());
        existingUser.setProviderUserId(user.getProviderUserId());

        User savedUser = userRepo.save(existingUser);
        return Optional.ofNullable(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user2=userRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("user not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(Long userId) { // ✅ Changed String to Long
        User user2=userRepo.findById(userId)
        .orElse(null);
        return user2!=null?true:false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user=userRepo.findByEmail(email).orElse(null);
        return user!=null?true:false;
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userRepo.findAll();
    }
}
