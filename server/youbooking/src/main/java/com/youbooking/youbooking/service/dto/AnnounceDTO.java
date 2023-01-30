package com.youbooking.youbooking.service.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnnounceDTO implements Serializable {

    private String announceRef;
    private HotelDto hotel;

    public AnnounceDTO(HotelDto hotel) {
        this.hotel = hotel;
    }
}
