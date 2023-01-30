import { Address } from "./address.model";
import { Announcement } from "./Announcement.model";
import { Chamber } from "./chamber.model";

export class Hotel {
    id?: any;
    name?: string;
    description?: string;
    address?:Address|undefined;
    announce?:Announcement;
    chamberList?:Chamber[];

  }
