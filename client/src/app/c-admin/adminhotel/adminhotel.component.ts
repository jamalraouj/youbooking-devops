import { Component, OnInit } from '@angular/core';
import {HotelService} from "../../services/hotel/hotel.service";
import {ActivatedRoute} from "@angular/router";
import {Hotel} from "../../../models/hotel.model";
import {Announcement} from "../../../models/Announcement.model";
import {AnnonceService} from "../../services/annonce/annonce.service";
import {ProprietaryService} from "../../services/proprietary/proprietary.service";
import {Proprietary} from "../../../models/proprietary.model";

@Component({
  selector: 'app-adminhotel',
  templateUrl: './adminhotel.component.html',
  styleUrls: ['./adminhotel.component.css','../../adminstyle.css']
})
export class AdminhotelComponent implements OnInit {
  hotels!:Hotel[];
  proprietaries!:any;
  announces!:Announcement[];
  id!:any;
  constructor( private hotelService:HotelService , private announceService:AnnonceService, private route: ActivatedRoute , private proprietaryService:ProprietaryService) {}

  ngOnInit(): void {
    // this.getHotel();
    // this.getAllProprietary();
    this.getAllAnnonces();

  }
  public getHotel(): void {
    this.hotelService.getHotels().subscribe(
      (response:Hotel[]) => {
        this.hotels = response;
        // this.chamberList = response.chamberList;
        console.log(this.hotels)
      });
    console.log("==================================")
    // this.hotelService.getThisHotel().subscribe(
    //   (response: Hotel) => {
    //      response;
    //     console.log(response);
    //   },
    //   (error: HttpErrorResponse) => {
    //     alert(error.message);
    //   }
    // );
  }

  public getAllAnnonces(): void {

    this.announceService.getAllAnnonces().subscribe(
      (response:Announcement[]) => {
        this.announces = response;
        // this.chamberList = response.chamberList;
        console.log(this.announces)
      });
  }
  public getAllProprietary(){
    this.proprietaryService.getAll().subscribe(
      (response:any)=>{
        this.proprietaries= response;
        console.log(this.proprietaries)
      }
    )
  }
  updateAccepted($event: boolean , id:bigint) {
    this.announceService.updateAccepted($event,id).subscribe(
      () => {
        this.ngOnInit();
      });


  }
  delete(id:any){
    this.announceService.delete(id).subscribe(
      () => {
        this.ngOnInit();
      });
  }
}
