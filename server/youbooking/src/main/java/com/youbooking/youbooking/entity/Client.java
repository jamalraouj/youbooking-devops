package com.youbooking.youbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
public class Client extends UserEntity{
    public Client(String name , String lastName , String email, String password, boolean isActive) {
        super(name,lastName , email, password, isActive , Role.CLIENT);

    }

    @OneToMany
    private List<Reservation> reservationList;

    public Client() {

    }


    public void addReservation(Reservation reservation){
        this.reservationList.add(reservation);
    }
}
