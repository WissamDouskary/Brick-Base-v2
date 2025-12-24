package com.brickbase.platform.mapper;

import com.brickbase.platform.dto.requestDTO.UserRequestDTO;
import com.brickbase.platform.dto.responseDTO.UserResponseDTO;
import com.brickbase.platform.model.Role;
import com.brickbase.platform.model.User;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    User toEntity(UserRequestDTO dto);

    @Mapping(target = "roles", expression = "java(mapRoles(user.getRoles()))")
    UserResponseDTO toResponse(User user);

    default Set<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(role -> role.getName().name())
                .collect(Collectors.toSet());
    }
}

