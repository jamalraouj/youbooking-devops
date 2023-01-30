import { Component, OnInit } from '@angular/core';
import {Announcement} from "../../../models/Announcement.model";
import {ActivatedRoute} from "@angular/router";
import {AnnonceService} from "../../services/annonce/annonce.service";

@Component({
  selector: 'app-showhotel',
  templateUrl: './showhotel.component.html',
  styleUrls: ['./showhotel.component.css','../../adminstyle.css']
})
export class ShowhotelComponent implements OnInit {
  private id: any;
  announce! :Announcement;
  chamberSize = new Map<string, number>();

  constructor(private announceService:AnnonceService ,private route: ActivatedRoute ) {}

  ngOnInit(): void {
    this.id =this.route.snapshot.params['id']
    this.getOneHotel();

  }

  private getOneHotel() {

    this.announceService.getOne(this.id).subscribe(
      (response:Announcement) => {
        this.announce = response;
        this.calcChamberSize();
        // this.chamberList = response.chamberList;
        // console.log(this.announce)
      });
  }

  private calcChamberSize() {
    // let d = this.announce.hotel?.chamberList?.filter(chamber =>chamber.chamberType==ChamberType.SINGLE).length
    // @ts-ignore
    if (this.announce && this.announce.hotel && this.announce.hotel.chamberList) {
      this.chamberSize.set("ALL" ,this.announce.hotel.chamberList.length );
      this.chamberSize.set("SINGLE" ,this.announce.hotel.chamberList.filter(chamber=>chamber.chamberType=="SINGLE").length );
      this.chamberSize.set("DOUBLE" ,this.announce.hotel.chamberList.filter(chamber=>chamber.chamberType=="DOUBLE").length );
      this.chamberSize.set("TWIN" ,this.announce.hotel.chamberList.filter(chamber=>chamber.chamberType=="TWIN").length );
      this.chamberSize.set("PRESIDENTIAL" ,this.announce.hotel.chamberList.filter(chamber=>chamber.chamberType=="PRESIDENTIAL").length );


      console.log(this.chamberSize)
    }
    }
    // if (this.announce.hotel?.chamberList?.length == true) {
    //   this.announce.hotel?.chamberList?.forEach(i => {
    //     console.log(i.chamberType)
    //   })
    // }
    // console.log(d+'=======================')
  // }
}
