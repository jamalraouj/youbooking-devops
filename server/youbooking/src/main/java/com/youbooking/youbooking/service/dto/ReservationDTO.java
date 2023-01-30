package com.youbooking.youbooking.service.dto;

import com.youbooking.youbooking.entity.ChamberType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;

@Setter
@Getter
@NoArgsConstructor
public class ReservationDTO implements Serializable{
        private LocalDate startDate;
        private LocalDate endDate;
        private ChamberType chamberType;

        public ReservationDTO(LocalDate startDate, LocalDate endDate, ChamberType chamberType) {
                this.startDate = LocalDate.now(ZoneId.from(startDate));
                this.endDate = LocalDate.now(ZoneId.from(endDate));
                this.chamberType = chamberType;
        }
}
