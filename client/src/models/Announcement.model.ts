import { Hotel } from "./hotel.model";
import { Message } from "./message.model";
import {Proprietary} from "./proprietary.model";

export  class Announcement{
    id?:any;
    ref?:string;
    localDate?:string;
    _accept?:boolean;
    hotel?:Hotel;
    proprietary?:Proprietary
    message?:Message;
}
