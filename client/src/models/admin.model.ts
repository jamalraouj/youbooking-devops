import { Address } from "./address.model";
import { Announcement } from "./Announcement.model";
import { Hotel } from "./hotel.model";
import { Message } from "./message.model";
import { UserEntity } from "./userEntity.model";

export class Admin extends UserEntity{

    constructor(id?: any, email?: string, password?: string, isActive?: boolean, address?: Address, message?: Message) {
        super(id, email, password, isActive, address, message);
        this.role = Role.ADMIN;
      }
      
    announcementList?:Announcement[];

    public addAnnounce(announce:Announcement ){
        this.announcementList?.push(announce);
    }
    
  }