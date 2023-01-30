import { Component, OnInit } from '@angular/core';
import {ProprietaryService} from "../../services/proprietary/proprietary.service";
import {Announcement} from "../../../models/Announcement.model";
import {HttpHeaders} from "@angular/common/http";
import {TokenService} from "../../services/token/tokenService";

@Component({
  selector: 'app-my-announce',
  templateUrl: './my-announce.component.html',
  styleUrls: ['./my-announce.component.css']
})
export class MyAnnounceComponent implements OnInit {
  announcements!:Announcement[];
  constructor(private proprietaryService:ProprietaryService , private  tokenService:TokenService) {}

  ngOnInit(): void {
    this.getMyAnnounce();
  }
  public getMyAnnounce(){
    console.log(this.tokenService.getRequest());
    this.proprietaryService.getMyAnnounces().subscribe(
      (response:Announcement[])=>{
        this.announcements=response;
        console.log(this.announcements)
      }
    )
  }

}
