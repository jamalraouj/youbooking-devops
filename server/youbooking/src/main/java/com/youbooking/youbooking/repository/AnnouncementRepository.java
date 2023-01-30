package com.youbooking.youbooking.repository;

import com.youbooking.youbooking.entity.Announcement;
import com.youbooking.youbooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {


    @Query("SELECT a FROM Announcement a INNER JOIN Hotel h ON h.id = a.hotel.id WHERE a.is_accept = true")
    List<Hotel> findAllHotels();


}
