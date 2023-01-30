import { Injectable } from '@angular/core';
// import { JwtHelperService } from "@auth0/angular-jwt";
import * as jwt_decode from 'jwt-decode';
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TokenService {
 decodedToken!: { [key: string]: string };
  headers:any;
  requestOptions :any;
  constructor() {
    this.headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer `+ this.getToken()
    });

  }
  getRequest():any{
    let headers = this.headers;
    this.requestOptions = { headers};
    return this.requestOptions;
  }
  public saveToken(token: string): void {
    window.localStorage.setItem('token', token);
  }

  public getToken(): string {

    // @ts-ignore
    return window.localStorage.getItem('token').toString();
  }
  public extractAuthorities(): void {
      if (this.getToken()) {

        // this.decodedToken = jwt_decode(this.getToken());

    }
  }

  public deleteToken(): void {
    window.localStorage.removeItem('token');
  }
  // public extractsAuthorities():string{
  //   // return window.localStorage.getItem('token').
  //   const decodedToken = this.jwtHelper.decodeToken("token");
  //   // const authorities = decodedToken.authorities;
  //   return decodedToken.authorities;
  // }
}
