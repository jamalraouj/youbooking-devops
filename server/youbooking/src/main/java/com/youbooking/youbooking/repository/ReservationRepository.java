package com.youbooking.youbooking.repository;

import com.youbooking.youbooking.entity.Chamber;
import com.youbooking.youbooking.entity.ChamberType;
import com.youbooking.youbooking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("SELECT r FROM Reservation r WHERE r.startDate BETWEEN :startDate AND :endDate AND r.chamber.chamberType = :chamberType")
    Reservation reserveChamber(
            @Param("chamberType") ChamberType chamberType,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    //this query is not ran try use pgAdmin query
    @Query("SELECT r FROM Chamber c inner join Reservation r WHERE r.chamber.id = :idChamber AND r.startDate = :startDate AND r.endDate = :endDate")
    Chamber findChamberAndDateRange(
            @Param("idChamber") Long idChamber,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
