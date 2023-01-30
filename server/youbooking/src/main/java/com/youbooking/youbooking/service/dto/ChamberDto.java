package com.youbooking.youbooking.service.dto;


import com.youbooking.youbooking.entity.Chamber;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Chamber} entity
 */
@Data
public class ChamberDto implements Serializable {
    private final String name;
    private final String description;
    private final String image;
}