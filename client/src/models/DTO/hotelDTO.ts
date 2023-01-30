import {Address} from "../address.model";
import {AddressDTO} from "./addressDTO";

export class HotelDTO {
    name?: string;
    description?: string;
    address?:AddressDTO|undefined;

  constructor() {
  }

  }
