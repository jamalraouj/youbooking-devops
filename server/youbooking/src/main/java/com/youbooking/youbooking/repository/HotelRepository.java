package com.youbooking.youbooking.repository;


import com.youbooking.youbooking.entity.Announcement;
import com.youbooking.youbooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
     @Query("SELECT h FROM Hotel h INNER JOIN Announcement a ON h.id = a.hotel.id WHERE a.is_accept = true")
     List<Hotel> findAllByAnnouncementIsAccept();
}
