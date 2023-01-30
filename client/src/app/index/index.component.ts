import { enableProdMode } from '@angular/core';
import { Component, OnInit } from '@angular/core';

import {Hotel} from '../../models/hotel.model';
import { HttpErrorResponse } from '@angular/common/http';
import { ProprietaryService } from '../services/proprietary/proprietary.service';
import {Token} from "@angular/compiler";
import { NgbAlertModule, NgbDatepickerModule, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

import {TokenService} from "../services/token/tokenService";
import {HotelService} from "../services/hotel/hotel.service";


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['../../styles.css'],
})

export class IndexComponent implements OnInit {

  // hotels:any;
  hotels?:Hotel[];

  // currentTutorial: Tutorial = {};
  // currentIndex = -1;
  // title = '';

  constructor(private hotelService:HotelService) { }


  ngOnInit(): void {

    this.getHotels();
   // this.hotels = this.proprietaryService.getHotels();
   // console.log(this.proprietaryService.getHotels());
  }

  public getHotels(): void {
    // console.log(this.tokenService.extractsAuthorities());
    this.hotelService.getHotels().subscribe(
      (response: Hotel[]) => {
        this.hotels = response;

      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }



}
