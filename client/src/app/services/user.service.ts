import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Hotel } from 'src/models/hotel.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiUrl = "http://localhost:8080/youbooking/hotel/";
  constructor(private http: HttpClient) { }

  getData() {
    return this.http.get('http://localhost:8080/youbooking/hotel/');
  }
  public getHotels(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(`${this.apiUrl}`);
  }
  // name="Hello index";
  // public getName(){
  //   return this.name;
  // }

}
