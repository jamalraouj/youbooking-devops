package com.youbooking.youbooking.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youbooking.youbooking.classes.Message;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
//@Setter
//@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Address address;
    @OneToOne(mappedBy = "hotel")
    @JsonIgnore
    private Announcement announcement;
//    @OneToMany(mappedBy ="hotel")//fetch = FetchType.EAGER
//    @JsonIgnore
    @OneToMany( cascade = CascadeType.REMOVE)
    private List<Chamber> chamberList ;
    @Transient
    private Message message;

    public Hotel(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void addChamber(Chamber chamber){
        this.chamberList.add(chamber);
    }





}
