package com.brickbase.platform.service;

import com.brickbase.platform.dto.requestDTO.WorkerProfileRequestDTO;
import com.brickbase.platform.dto.responseDTO.WorkerProfileResponseDTO;
import com.brickbase.platform.enums.JobTypes;
import com.brickbase.platform.exception.ResourceNotFoundException;
import com.brickbase.platform.mapper.WorkerProfileMapper;
import com.brickbase.platform.model.User;
import com.brickbase.platform.model.WorkerProfile;
import com.brickbase.platform.repository.UserRepository;
import com.brickbase.platform.repository.WorkerProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkerProfileService {

    private final WorkerProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final WorkerProfileMapper mapper;

    public WorkerProfileResponseDTO completeProfile(WorkerProfileRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        WorkerProfile workerProfile = profileRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));

        workerProfile.setSkills(dto.getSkills());
        workerProfile.setPricePerDay(dto.getPricePerDay());
        workerProfile.setDescription(dto.getDescription());
        workerProfile.setCategory(dto.getCategory());
        workerProfile.setJobTitle(JobTypes.valueOf(dto.getJobTitle()));
        WorkerProfile saved = profileRepository.save(workerProfile);
        return mapper.toResponse(saved);
    }
}
