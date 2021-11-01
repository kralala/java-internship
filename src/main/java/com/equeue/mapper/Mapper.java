package com.equeue.mapper;

import com.equeue.dto.ReservationDTO;
import com.equeue.dto.UserDTO;
import com.equeue.entity.Reservation;
import com.equeue.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ModelMapper modelMapper;

    public Mapper() {
        this.modelMapper = new ModelMapper();
    }

    public User toUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO toUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public Reservation toReservation(ReservationDTO reservationDTO) {
        return modelMapper.map(reservationDTO, Reservation.class);
    }

    public ReservationDTO toReservationDTO(Reservation reservation) {
        return modelMapper.map(reservation, ReservationDTO.class);
    }

}
