package com.youbooking.youbooking.controller;

import com.youbooking.youbooking.entity.Announcement;
import com.youbooking.youbooking.entity.Proprietary;
import com.youbooking.youbooking.service.AnnouncementService;
import com.youbooking.youbooking.service.HotelService;
import com.youbooking.youbooking.service.ProprietaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/youbooking/admin")
public class AdminController {
    @Autowired
    AnnouncementService announcementService;
    @Autowired
    HotelService hotelService;
    @Autowired
    ProprietaryService proprietaryService;

    @GetMapping("/get-all-announces")
    @ResponseBody
    public List<Announcement> getAllAnnounces(){
        return announcementService.findAll();
    }
    ///announce/update-accepted/
    @GetMapping("/announce/update-accepted/{id}/{accept}")
    @ResponseBody
    public boolean updateAcceptedAnnounce(@PathVariable Long id , @PathVariable boolean accept){

        return announcementService.updateAccepted(accept , id);
    }
    @GetMapping("/announce/{id}")
    @ResponseBody
    public Announcement getAnnounceById(@PathVariable Long id){
        return announcementService.getById(id);
    }
    @DeleteMapping("/announce/delete/{id_prop}/{id_ann}")
    @ResponseBody
    public boolean deleteHotel(@PathVariable Long id_prop , @PathVariable Long id_ann){
        System.out.println(true+"WWWWWWWWWW");
        return announcementService.delete(id_prop , id_ann);
    }
    @GetMapping("/proprietary")
    @ResponseBody
    public List<Proprietary> getAllProp(){
        return proprietaryService.findAll();
    }


//    @GetMapping("/get-all-announces/{id_prop}")
//    public List<Announcement> getAllAnnounces(@PathVariable Long id_prop){
//        return announcementService.getAnnouncesByProp(id_prop);
//    }
}
