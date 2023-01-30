package com.youbooking.youbooking;


import com.youbooking.youbooking.entity.Reservation;
import com.youbooking.youbooking.entity.UserEntity;
import com.youbooking.youbooking.service.dto.RegisterDTO;
import com.youbooking.youbooking.service.dto.ReservationDTO;
import org.modelmapper.ModelMapper;

public class DtoToEntity {
    public static UserEntity userDtoToUser(RegisterDTO registerDTO) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(registerDTO, UserEntity.class);
    }
    public static Reservation reservationDtoToReservation(ReservationDTO reservationDTO) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(reservationDTO, Reservation.class);
    }


}
