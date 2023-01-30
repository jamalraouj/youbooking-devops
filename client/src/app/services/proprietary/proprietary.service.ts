import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from 'src/models/hotel.model';
import {Proprietary} from "../../../models/proprietary.model";
import {Announcement} from "../../../models/Announcement.model";
import {TokenService} from "../token/tokenService";

@Injectable({
  providedIn: 'root'
})
export class ProprietaryService {

  apiUrl='http://localhost:8080/youbooking'
  constructor(private http: HttpClient , private tokenService:TokenService) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer `+this.tokenService.getToken()
    });
  }
  public getHotels(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(`${this.apiUrl+'/proprietary/get-my-hotel'}`);
  }
  public getAll(): Observable<Proprietary[]> {
    return this.http.get<Proprietary[]>(`${this.apiUrl+'/admin/proprietary'}`);
  }

  getMyAnnounces():Observable<any> {
    return this.http.get<Announcement[]>(`${this.apiUrl+'/proprietary/get-my-announces'}`, this.tokenService.getRequest())

  }
}
