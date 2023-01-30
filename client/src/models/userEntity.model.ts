import { Address } from "./address.model";
import { Message } from "./message.model";

export class UserEntity{
    id?: any;
    name?:string;
    lastName?:string;
    email?:string;
    password?:string;
    isActive?:boolean;
    role?:Role;
    address?:Address;
    message?:Message;
    constructor(id?: any,name?:string , lastName?:string , email?: string, password?: string, isActive?: boolean) {
        this.id = id;
        this.name = name;
        this.lastName =lastName;
        this.email = email;
        this.password = password;
        this.isActive = isActive;


    }

}
