import { Hotel } from "./hotel.model";
// @ts-ignore
import { ChamberType } from "./enumChamberType.model";


export class Chamber{
    name?:string;
    description?:string;
    image?:string;
    chamberType?: ChamberType;

}
