import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login/login.service';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TokenService} from "../services/token/tokenService";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  baseUrl = 'http://localhost:8080/youbooking';
  userGroup: FormGroup;
  // const tokenService = new TokenService();
  constructor(private tokenService: TokenService,
    private formBuild: FormBuilder,
    private router: Router,
    private loginService: LoginService,
    private http: HttpClient
  ) {
    this.userGroup = this.formBuild.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
  ngOnInit(): void {
  }
data : any;

  onSubmit() {
    console.log(true)
    this.http.post(this.baseUrl + '/auth/authenticate', this.userGroup.value).subscribe(
      data => { this.data = data ;
        console.log(true)
        this.tokenService.saveToken(this.data.data)

        this.router.navigate(['/index']);
      },
        error => {
        console.log(error)
      }
    );
  }


  }

