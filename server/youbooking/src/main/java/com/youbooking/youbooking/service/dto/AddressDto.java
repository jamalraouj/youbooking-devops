package com.youbooking.youbooking.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.youcode.youbooking.entity.Address} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {
    private  String address;
    private  String city;
    private  String country;
}