package com.youbooking.youbooking.controller;

import com.youbooking.youbooking.controller.vm.ResponseVm;
import com.youbooking.youbooking.entity.Announcement;
import com.youbooking.youbooking.entity.Chamber;
import com.youbooking.youbooking.entity.Hotel;
import com.youbooking.youbooking.entity.Reservation;
import com.youbooking.youbooking.repository.ReservationRepository;
import com.youbooking.youbooking.service.AnnouncementService;
import com.youbooking.youbooking.service.ChamberService;
import com.youbooking.youbooking.service.HotelService;
import com.youbooking.youbooking.service.dto.AnnounceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/youbooking/proprietary")
public class ProprietaryController {
    @Autowired
    HotelService hotelService;
    @Autowired
    ChamberService chamberService;
    @Autowired
    AnnouncementService announcementService;

    @Autowired
    ReservationRepository reservationRepository;

    @PostMapping("/add-hotel")
    public Hotel addHotel(@RequestBody Hotel hotel ){
        return hotelService.add(hotel);
    }
//    @PostMapping("/add-announce")
//    public Announcement addHotel(@RequestBody AnnounceDTO announceDTO , Principal principal){
//        return announcementService.add(principal , announceDTO);
//    }
    @GetMapping(path = {"/get-my-hotel","/",""})
    public ResponseEntity<List<Hotel>> getListHotel(Principal principal){
        System.out.println(true);
        return ResponseEntity.ok(hotelService.getMyHotel(principal));

    }
    @GetMapping("/get-my-announces")
    public List<Announcement> getListAnnounce(Principal principal){
        return hotelService.getMyAnnounces(principal);
    }
    @GetMapping("/get-my-chambers/{id_hotel}")
    public List<Chamber> getListChamersByHotel(@PathVariable Long id_hotel , Principal principal){
        return hotelService.getMyChambers(id_hotel, principal);
    }
    @PostMapping("/get-my-hotel/chamber/add/{id_hotel}")
    public ResponseEntity<Chamber> addChamber(@RequestBody Chamber chamber , @PathVariable Long id_hotel){
        return ResponseEntity.ok(chamberService.add(chamber , id_hotel));
    }
    @PostMapping("/add-announce")
    @ResponseBody
    public ResponseEntity<ResponseVm> addAnnounce(Principal principal ,@RequestBody AnnounceDTO announceDTO ){
        System.out.println("1111111111111111111111111111111111111111111");
         Announcement announcement = announcementService.add(principal,announceDTO );
        System.out.println("true");
         return ResponseEntity.ok(new ResponseVm(HttpStatus.ACCEPTED , "SUCCESS", Collections.singletonList(announcement)));
    }
    @GetMapping("/get-all-reservation")
    @ResponseBody
    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }
}
