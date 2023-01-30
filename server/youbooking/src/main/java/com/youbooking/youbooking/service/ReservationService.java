package com.youbooking.youbooking.service;

import com.youbooking.youbooking.DtoToEntity;
import com.youbooking.youbooking.entity.Chamber;
import com.youbooking.youbooking.entity.Hotel;
import com.youbooking.youbooking.entity.Reservation;
import com.youbooking.youbooking.repository.ChamberRepository;
import com.youbooking.youbooking.repository.HotelRepository;
import com.youbooking.youbooking.repository.ReservationRepository;
import com.youbooking.youbooking.service.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Service
public class ReservationService implements IService<Reservation , Long> {

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ChamberRepository chamberRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Override
    public Reservation add(Reservation reservation) {
        return null;
    }

    public Reservation add(Long id_hotel ,ReservationDTO reservationDTO) {
        Optional<Hotel> h = hotelRepository.findById(id_hotel);
        AtomicReference<Reservation> reservation1 = new AtomicReference<>(new Reservation());
        System.out.println("111111111111");
        if (h.isPresent()){
            System.out.println("prisent");
            Stream<Chamber> chambers = h.get().getChamberList().stream().filter(chamber -> chamber.getChamberType() == reservationDTO.getChamberType());
            chambers.forEach(chamber ->{
                Stream<Reservation> reservationStream = Stream.ofNullable(new Reservation());

                reservationStream = chamber.getReservation().stream().filter(r->r.getStartDate().equals(reservationDTO.getStartDate()));
//               reservationStream.forEach(o->{
//                       System.out.println("||||||||||||||||||||||||||||||||||||||||");
//
//               });
                if(reservationStream.count()==0){
                    if(reservation1.get().getId()==null) {
                            reservation1.set(DtoToEntity.reservationDtoToReservation(reservationDTO));
                            reservation1.get().setChamber(chamber);
                            reservationRepository.save(reservation1.get());

                    }
                }





                System.out.println("chamber list");
                System.out.println("TRUE ============> "+chamber.getChamberType());

//                if(reservation1.get().getId()==null) {
//                    if(chamber.getReservation().size() == 0){
//                        reservation1.set(DtoToEntity.reservationDtoToReservation(reservationDTO));
//                        reservation1.get().setChamber(chamber);
//                        reservationRepository.save(reservation1.get());
//                    }
//                     chamber.getReservation().stream().forEach(reservation -> {
//                         if(reservation1.get().getId()==null) {
//                             if (reservation.getStartDate() != reservationDTO.getStartDate() && reservation.getEndDate() != reservationDTO.getEndDate()) {
//                                 reservation1.set(DtoToEntity.reservationDtoToReservation(reservationDTO));
//                                 reservation1.get().setChamber(chamber);
//                                 reservationRepository.save(reservation1.get());
//                             }
//                         }
////                         if(!(reservation.getStartDate().isAfter(reservationDTO.getStartDate())  &&
////                                 reservation.getStartDate().isBefore(reservationDTO.getEndDate())) &&
////                                 !(reservation.getEndDate().isAfter(reservationDTO.getStartDate()) &&
////                                         reservation.getEndDate().isBefore(reservationDTO.getEndDate()))){
////                             System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
////
////                         }
////                         !(reservation.getStartDate().isAfter(reservationDTO.getStartDate())  &&
////                                 reservation.getStartDate().isBefore(reservationDTO.getEndDate())) &&
////                                 !(reservation.getEndDate().isAfter(reservationDTO.getStartDate()) &&
////                                         reservation.getEndDate().isBefore(reservationDTO.getEndDate()))
//                     });
//
////                    System.out.println("000"+r.findFirst().get());
////
////
////                    if (!r.findFirst().isPresent()) {
////                        reservation1.set(DtoToEntity.reservationDtoToReservation(reservationDTO));
////                        reservation1.get().setChamber(chamber);
////
////                        System.out.println("reserv IS not Prisent");
////
////
////                        return;
////                    }
//                }
//                System.out.println(r.findFirst().get());
                System.out.println("else place");
//                chamber.getReservation().forEach(reservation->{
//                    reservation.setChamber(chamber);
//                    Reservation d = DtoToEntity.reservationDtoToReservation(reservationDTO);
//                    System.out.println(d+" trurururudcjsnc");
//                   reservation1.set(DtoToEntity.reservationDtoToReservation(reservationDTO));
////                    reservationRepository.save(reservation1.get());
//                   return;
//
//
////                    if (reservation.getStartDate() )
////                    continue json ignore with relation chamber and reservation
//                });
            });
        }
//       Reservation r =  reservationRepository.reserveChamber(reservationDTO.getChamberType() , reservationDTO.getStartDate() , reservationDTO.getEndDate());
//        System.out.println(r);
            return reservation1.get();
    }

    @Override
    public boolean delete(Long i) {
        return false;
    }

    @Override
    public Reservation findOneById(Long i) {
        return null;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
