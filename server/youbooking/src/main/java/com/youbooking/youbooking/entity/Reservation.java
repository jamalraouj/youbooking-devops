package com.youbooking.youbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Chamber chamber;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(Chamber chamber, LocalDate startDate, LocalDate endDate) {
        this.chamber = chamber;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
