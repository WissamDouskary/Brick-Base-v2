package com.brickbase.platform.mapper;

import com.brickbase.platform.dto.requestDTO.NotificationRequestDTO;
import com.brickbase.platform.dto.responseDTO.NotificationResponseDTO;
import com.brickbase.platform.model.Notification;
import com.brickbase.platform.model.User;
import org.mapstruct.*;

@Mapper(config = MapperConfig.class)
public interface NotificationMapper {

    @Mapping(target = "user", source = "user")
    Notification toEntity(NotificationRequestDTO dto, User user);

    @Mapping(target = "userId", source = "user.id")
    NotificationResponseDTO toResponse(Notification notification);
}

