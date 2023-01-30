package com.youbooking.youbooking.controller;

import com.youbooking.youbooking.entity.Chamber;
import com.youbooking.youbooking.entity.Reservation;
import com.youbooking.youbooking.service.ChamberService;
import com.youbooking.youbooking.service.ReservationService;
import com.youbooking.youbooking.service.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/youbooking/chambers")
public class ChamberController {
    @Autowired
    ChamberService chamberService;
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public List<Chamber> getAll(){
        return chamberService.findAll();
    }

    @PostMapping("/add/{id_hotel}")
    public ResponseEntity<Chamber> add(@RequestBody Chamber chamber , @PathVariable Long id_hotel){

        return ResponseEntity.ok(chamberService.add(chamber , id_hotel));
    }


    @GetMapping("/all/reserve")
    public ResponseEntity<List<Reservation>> allreserve(){
        return ResponseEntity.ok(reservationService.findAll());
    }

}
