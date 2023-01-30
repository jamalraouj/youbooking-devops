import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Hotel} from "../../../models/hotel.model";
import {Observable} from "rxjs/internal/Observable";
import {Announcement} from "../../../models/Announcement.model";

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {

  apiUrl='http://localhost:8080/youbooking/admin'
  constructor(private http: HttpClient) {}

  public getAllAnnonces(): Observable<Hotel[]> {
    return this.http.get<Announcement[]>(`${this.apiUrl}`+'/get-all-announces');
  }

  updateAccepted($event: boolean , id:bigint):Observable<any> {
    return this.http.get<any>(`${this.apiUrl}`+'/announce/update-accepted/'+id+'/'+$event);
  }
  getOne(id:bigint):Observable<Announcement>{
    return this.http.get<any>(`${this.apiUrl}`+'/announce/'+id);
  }

  delete(id: any) {
    return this.http.get(`${this.apiUrl}/announce/delete/`+id);
  }
}
