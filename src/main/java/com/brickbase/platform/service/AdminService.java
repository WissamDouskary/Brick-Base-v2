package com.brickbase.platform.service;

import com.brickbase.platform.exception.ResourceNotFoundException;
import com.brickbase.platform.model.User;
import com.brickbase.platform.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    private final UserRepository userRepository;

    public void approveWorker(String userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setEnabled(true);
        userRepository.save(user);
    }
}
