package com.brickbase.platform.mapper;

import com.brickbase.platform.dto.requestDTO.ReservationRequestDTO;
import com.brickbase.platform.dto.responseDTO.ReservationResponseDTO;
import com.brickbase.platform.model.Reservation;
import com.brickbase.platform.model.User;
import org.mapstruct.*;

@Mapper(config = GlobalMapperConfig.class)
public interface ReservationMapper {

    @Mapping(target = "client", source = "client")
    @Mapping(target = "worker", source = "worker")

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Reservation toEntity(ReservationRequestDTO dto, User client, User worker);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "workerId", source = "worker.id")
    ReservationResponseDTO toResponse(Reservation reservation);
}
