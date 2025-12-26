package com.brickbase.platform.mapper;


import com.brickbase.platform.dto.requestDTO.UserRequestDTO;
import com.brickbase.platform.dto.responseDTO.UserResponseDTO;
import com.brickbase.platform.enums.RoleName;
import com.brickbase.platform.model.Role;
import com.brickbase.platform.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = GlobalMapperConfig.class)
public interface UserMapper {

    @Mapping(target = "role", source = "role", qualifiedByName = "stringToRole")
    User toEntity(UserRequestDTO dto);

    @Mapping(target = "role", source = "role", qualifiedByName = "roleToString")
    UserResponseDTO toResponse(User user);

    @Named("stringToRole")
    default Role stringToRole(String roleName) {
        if (roleName == null) return null;
        Role role = new Role();
        role.setName(Enum.valueOf(RoleName.class, roleName.toUpperCase()));
        return role;
    }

    @Named("roleToString")
    default String roleToString(Role role) {
        if (role == null) return null;
        return role.getName().name();
    }
}
