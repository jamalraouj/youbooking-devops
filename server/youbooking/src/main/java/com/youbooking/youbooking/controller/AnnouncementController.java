package com.youbooking.youbooking.controller;

import com.youbooking.youbooking.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/youbooking/announcement")
public class AnnouncementController {
//create api annoncement
    @Autowired
AnnouncementService announcementService;
//    @PostMapping("/add")
//    public Announcement add(@RequestBody AnnounceDTO announceDTO){
//        return announcementService.add(announceDTO);
//    }

    }
