package com.youbooking.youbooking.service;


import com.youbooking.youbooking.entity.Chamber;
import com.youbooking.youbooking.entity.Hotel;
import com.youbooking.youbooking.repository.ChamberRepository;
import com.youbooking.youbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamberService implements IService<Chamber, Long> {
    @Autowired
    ChamberRepository chamberRepository;
    @Autowired
    HotelRepository hotelRepository2;
    @Override
    public Chamber add(Chamber chamber) {

        return chamberRepository.save(chamber);
    }

    public Chamber add(Chamber chamber , Long id_hotel){
        Optional<Hotel> hotel =  hotelRepository2.findById(id_hotel);
        if(hotel.isPresent()) {
//            chamber.setHotel(hotel.get());
            chamberRepository.save(chamber);
            hotel.get().addChamber(chamber);
            hotelRepository2.save(hotel.get());
        }
         return chamber ;
    }
    @Override
    public boolean delete(Long i) {
        return false;
    }
    @Override
    public Chamber findOneById(Long i) {
        return null;
    }

    @Override
    public Chamber update(Chamber chamber) {
        return null;
    }

    @Override
    public List<Chamber> findAll() {
        return chamberRepository.findAll();
    }

//    private StudentDto convertToDto(Student student) {
//        return modelMapper..mapModels(student, StudentDto.class);
//    }


}
