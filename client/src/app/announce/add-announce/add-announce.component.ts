import { Component, OnInit } from '@angular/core';
import {TokenService} from "../../services/token/tokenService";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {LoginService} from "../../services/login/login.service";
import {HttpClient, HttpHeaders , HttpInterceptor, HttpRequest, HttpHandler, HttpEvent} from "@angular/common/http";
import {AnnounceDTO} from "../../../models/DTO/announceDTO";
import {Address} from "../../../models/address.model";
import {HotelDTO} from "../../../models/DTO/hotelDTO";
import {AddressDTO} from "../../../models/DTO/addressDTO";

@Component({
  selector: 'app-add-announce',
  templateUrl: './add-announce.component.html',
  styleUrls: ['./add-announce.component.css']
})
export class AddAnnounceComponent implements OnInit  {
  baseUrl = 'http://localhost:8080/youbooking';
  userGroup: FormGroup;
  data : any;
  requestOptions!:any;
  // announce:AnnounceDTO= new AnnounceDTO();


  constructor(private tokenService: TokenService,
              private formBuild: FormBuilder,
              private router: Router,
              // private loginService: LoginService,
              private http: HttpClient ) {
    // if()
    this.userGroup = this.formBuild.group({

        name: ['', Validators.required],
        description: ['', Validators.required],
        country:['' , Validators.required],
        city:['',Validators.required],
        address:['',Validators.required]
    });
  }

  ngOnInit(): void {
    this.tokenService.extractAuthorities();
    console.log(this.tokenService.decodedToken)
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer `+this.tokenService.getToken()
    });
    this.requestOptions = { headers};
  }

  onSubmit() {
    let address = new AddressDTO();
    let hotel = new HotelDTO();
    let announce = new AnnounceDTO();
    address.city=this.userGroup.value.city;
    address.country = this.userGroup.value.country;
    address.address = this.userGroup.value.address;
    hotel.name = this.userGroup.value.name;
    hotel.description = this.userGroup.value.description;
    hotel.address = address;
    announce.hotel = hotel;
    console.log(announce)
    console.log( this.tokenService.getToken())
    let request = this.requestOptions;
    let header = new HttpHeaders().set("Authorization", "Bearer " + this.tokenService.getToken());
    this.http.post(this.baseUrl + '/proprietary/add-announce', announce,request).subscribe(
      data => { this.data = data ;
        // console.log(this.data)
        this.router.navigate(['announce/my-announce']);
      },
      error => {
        console.log(error)
      }
    );
  }
}
