import { Component, OnInit } from '@angular/core';
import {Announcement} from "../../../models/Announcement.model";
import {AnnonceService} from "../../services/annonce/annonce.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-update-hotel',
  templateUrl: './update-hotel.component.html',
  styleUrls: ['./update-hotel.component.css']
})
export class UpdateHotelComponent implements OnInit {
  userGroup: any;
  private id: any;
  announce! :Announcement;
  constructor(private announceService:AnnonceService ,private route: ActivatedRoute ) {
    this.id =this.route.snapshot.params['id']
    this.getHotel();
  }

  ngOnInit(): void {
    this.getHotel();
  }

  getHotel() {

      this.announceService.getOne(this.id).subscribe(
        (response) => {
          this.announce = response;
          // this.chamberList = response.chamberList;
          // console.log(this.announce)
        });

  }
  updateHotel(){}
}
