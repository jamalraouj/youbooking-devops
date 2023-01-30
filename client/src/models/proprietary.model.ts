import { Address } from "./address.model";
import { Announcement } from "./Announcement.model";
import { Hotel } from "./hotel.model";
import { Message } from "./message.model";
import { UserEntity } from "./userEntity.model";

export class Proprietary extends UserEntity{

    // constructor(id?: any, email?: string, password?: string, isActive?: boolean, address?: Address, message?: Message) {
    //     super(id, email, password, isActive, address, message);
    //     this.role = Role.PROPRIETARY;
    //   }

  constructor(id: any, name: string, lastName: string, email: string, password: string, isActive: boolean) {
    super(id, name, lastName, email, password, isActive);
    this.role = Role.PROPRIETARY;
  }

  hotelList?:Hotel[];
    announcementList?:Announcement[];
    public addHotel(hotel : Hotel){
        this.hotelList?.push(hotel);
    }
    public addAnnounce(announce:Announcement ){
        this.announcementList?.push(announce);
    }

  }
