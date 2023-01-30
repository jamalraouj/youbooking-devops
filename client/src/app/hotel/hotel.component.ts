import {Component, Inject, Injectable, OnInit} from '@angular/core';
import {Hotel} from "../../models/hotel.model";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {HotelService} from "../services/hotel/hotel.service";
import * as QueryString from "querystring";
import {ActivatedRoute} from "@angular/router";
import {Chamber} from "../../models/chamber.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})

export class HotelComponent implements OnInit {
  private queryParams: any;
  baseUrl = 'http://localhost:8080/youbooking';
  id!: number;
  data!:any;
   hotel!: Hotel;
  userGroup: FormGroup;
  // chamberType!:ChamberType;

  constructor( private hotelService:HotelService , private route: ActivatedRoute , private formBuild: FormBuilder ,private http: HttpClient) {
    this.userGroup = this.formBuild.group({
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      chamberType:['' , Validators.required],
    });
  }

  ngOnInit(): void {
    this.id =this.route.snapshot.params['id']
    this.getHotel();
  }
  public getHotel(): void {
    this.hotelService.getThisHotel(this.id).subscribe(
      (response:Hotel) => {
        this.hotel = response;
        // this.chamberList = response.chamberList;
        console.log(this.hotel)
    });
    console.log()
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

  reserve() {
    console.log(this.userGroup.value)
    this.http.post(this.baseUrl + '/hotel/1/reserve', this.userGroup.value).subscribe(
      data => { this.data = data ;
        // console.log(this.data)
        // this.router.navigate(['']);
      },
      error => {
        console.log(error)
      }
    );
  }
}
