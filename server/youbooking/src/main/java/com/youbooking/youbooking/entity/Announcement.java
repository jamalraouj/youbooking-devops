package com.youbooking.youbooking.entity;

import com.youbooking.youbooking.classes.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private LocalDate localDate = LocalDate.now();
    private boolean is_accept = false;

    @OneToOne(cascade = CascadeType.REMOVE , orphanRemoval = true)
//    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Proprietary proprietary;

    public Announcement(String ref, Hotel hotel) {
        this.ref = ref;
        this.hotel = hotel;
        this.localDate = LocalDate.now();
    }
    @Transient
    Message message;
}
