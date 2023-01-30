package com.youbooking.youbooking.service;

import com.youbooking.youbooking.classes.Message;
import com.youbooking.youbooking.entity.Address;
import com.youbooking.youbooking.entity.Announcement;
import com.youbooking.youbooking.entity.Hotel;
import com.youbooking.youbooking.entity.Proprietary;
import com.youbooking.youbooking.repository.*;
import com.youbooking.youbooking.service.dto.AddressDto;
import com.youbooking.youbooking.service.dto.AnnounceDTO;
import com.youbooking.youbooking.service.dto.HotelDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Service
public class AnnouncementService implements IService<Announcement,Long> {
    @Autowired
    AnnouncementRepository announcementRepository;
    @Autowired
    ChamberRepository chamberRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ProprietaryRepository proprietaryRepository;
    @Override
    public Announcement add(Announcement announcement){
        return  null;
    }

    public Announcement add(Principal principal,AnnounceDTO announceDTO){
        Optional<Announcement> announcement = Optional.of(new Announcement());
        Message message = new Message();
        if(announceDTO != new AnnounceDTO()){
            if(announceDTO.getAnnounceRef() == null || announceDTO.getAnnounceRef()=="") {
                announceDTO.setAnnounceRef(UUID.randomUUID().toString());
            }
            System.out.println(announceDTO+"PP");
            if(!announceDTO.getHotel().equals(new HotelDto())){
                if (announceDTO.getHotel().getName() != null && announceDTO.getHotel().getName()!="" && announceDTO.getHotel().getDescription() != null && announceDTO.getHotel().getDescription()!="") {
                    if(announceDTO.getHotel().getAddress()!=new AddressDto()) {
                        if (announceDTO.getHotel().getAddress().getAddress() != "" && announceDTO.getHotel().getAddress().getAddress()!=null && announceDTO.getHotel().getAddress().getCity() != "" && announceDTO.getHotel().getAddress().getCountry() != ""){

                            Hotel hotel = new Hotel();
                            Address address = new Address();
                            BeanUtils.copyProperties(announceDTO.getHotel(), hotel);
                            BeanUtils.copyProperties(announceDTO.getHotel().getAddress(), address);

                            announcement.get().setRef(announceDTO.getAnnounceRef());
                            addressRepository.save(address);
                            hotel.setAddress(address);

                            hotelRepository.save(hotel);
                            announcement.get().setHotel(hotel);
                            Proprietary proprietary = proprietaryRepository.findByEmail(principal.getName());//principal.getName()
//                            announcement.get().setProprietary(proprietar);
                            announcementRepository.save(announcement.get());
                            proprietary.addAnnouncement(announcement.get());
                            proprietaryRepository.save(proprietary);
                            message.setMessage("SUCCESS");
                            message.setState("SUCCESS");

                    }else {
                        message.setMessage("some details of hotel Address is null");
                        message.setState("ERROR");
                    }}else {
                        message.setMessage("Address of hotel is null");
                        message.setState("ERROR");
                    }
                }else {
                    message.setMessage("Name or description are null");
                    message.setState("ERROR");
                }
            }else {
                message.setMessage("hotel is null");
                message.setState("ERROR");
            }

         }else {
            message.setMessage("data is null");
            message.setState("ERROR");
        }
        announcement.get().setMessage(message);
        System.out.println(announcement.get());
        return announcement.get();
    }


//    public Announcement add(AnnounceDTO announceDTO) {
//
//        Optional<Announcement> announcement = null;
//        Message message = new Message();
//        if(announceDTO.getIdHotel() >= 0 || announceDTO.getIdHotel() != null){
//            if(announceDTO.getId_chamber() >=0 || announceDTO.getId_chamber() != null){
//                if(announceDTO.getAnnounceRef() != null && announceDTO.getAnnounceRef() != ""){
//                    Optional<Hotel> hotel = hotelRepository.findById(announceDTO.getIdHotel());
//                    if(hotel.isPresent()){
//                        Chamber chamber = (Chamber) hotel.get().getChamberList().stream().filter(ch -> ch.getId() == announceDTO.getId_chamber());
//                        announcement.get().setChamber( chamber);
//                        announcement.get().setRef(announceDTO.getAnnounceRef());
//                        announcementRepository.save(announcement.get());
//                    }
//                }else {
//                    message.setMessage("reference of an announce is null");
//                    message.setState("ERROR");
//                }
//            }else {
//                message.setMessage("chamber is null");
//                message.setState("ERROR");
//            }
//        }
//        else {
//            message.setMessage("hotel is null");
//            message.setState("ERROR");
//        }
////        if(announce.isPresent()){
//////            Optional<Hotel> hotel = hotelRepository.findById(idHotel);
//////            if(hotel.isPresent()) {
//////
//////                announce.get().getChamber().getAnnouncement().getChamber().getAnnouncement().getChamber()
//////                chamberRepository.save();
//////                announcementRepository.save(announce.get());
//////            }
////        }
//        return announcement.get();
//    }

    @Override
    public boolean delete(Long id) {
        Optional<Announcement> a = announcementRepository.findById(id);
        if (a.isPresent()){

            announcementRepository.deleteById(id);
            System.out.println(true+"qqqq");
            return true;
        }
        return false;
    }
    public boolean delete(Long id_prop ,Long id_ann) {
        Optional<Proprietary> proprietary = proprietaryRepository.findById(id_prop);
        AtomicReference<Announcement> announcement = new AtomicReference<>(new Announcement());
        if(proprietary.isPresent()){
            proprietary.get().getAnnouncementList().stream().filter(ann -> ann.getId() == id_ann)
                   .forEach(announce->{
                       announcement.set(announce);
                   });
            proprietary.get().getAnnouncementList().remove(announcement.get());
            announcementRepository.delete(announcement.get());
            proprietaryRepository.save(proprietary.get());
            return true;

        }
//
//        System.out.println("ooooooooo"+announcement.get());
//        Optional<Announcement> a = announcementRepository.findById(id);
//        if (a.isPresent()){
//
//            announcementRepository.deleteById(id);
//            System.out.println(true+"qqqq");
//            return true;
//        }
        return false;
    }

    @Override
    public Announcement findOneById(Long i) {
        return null;
    }

    @Override
    public Announcement update(Announcement announcement) {
        return null;
    }

    @Override
    public List<Announcement> findAll() {
        return announcementRepository.findAll();
    }

    public List<Announcement> getAnnouncesByProp(Long id_prop) {
        return null;
    }

    public boolean updateAccepted(boolean accept, Long id) {
       Optional<Announcement> announcement =  announcementRepository.findById(id);
       if (announcement.isPresent()){
           announcement.get().set_accept(accept);
           announcementRepository.save(announcement.get());
           return true;
       }
       else return false;
    }

    public Announcement getById(Long id) {
       Optional<Announcement> announcement =  announcementRepository.findById(id);
       if(announcement.isPresent()){
           return announcement.get();
       }
       else {
           announcement.get().getMessage().setMessage("ERROR : Not found");
           return announcement.get();
       }
    }
}
