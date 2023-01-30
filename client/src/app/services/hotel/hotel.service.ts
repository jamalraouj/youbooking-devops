import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Hotel } from 'src/models/hotel.model';
import {Chamber} from "../../../models/chamber.model";

@Injectable({
  providedIn: 'root'
})

export class HotelService {
  apiUrl='http://localhost:8080/youbooking/hotel'
  constructor(private http: HttpClient) { }

  getData() {
     return this.http.get('http://localhost:8080/youbooking/hotel/').subscribe(
    );
  }
  public getHotels(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(`${this.apiUrl}`+'/');
  }
  getAllHotel():Observable<any>{
    return this.http.get(`${this.apiUrl}`+'/')
  }

  getThisHotel(id: Number) {
    return this.http.get<Hotel>(`${this.apiUrl}/get/`+id);

  }


}
