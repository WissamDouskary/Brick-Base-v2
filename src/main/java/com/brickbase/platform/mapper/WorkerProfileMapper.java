package com.brickbase.platform.mapper;

import com.brickbase.platform.dto.responseDTO.WorkerProfileResponseDTO;
import com.brickbase.platform.model.WorkerProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = GlobalMapperConfig.class)
public interface WorkerProfileMapper {

    @Mapping(target = "userId", source = "user.id")
    WorkerProfileResponseDTO toResponse(WorkerProfile profile);
}
