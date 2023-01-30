package com.youbooking.youbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chamber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private ChamberType chamberType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @OneToMany
    private List<Reservation> reservation;



    public Chamber(String name, String description, String image , ChamberType chamberType) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.chamberType = chamberType;
    }

}
