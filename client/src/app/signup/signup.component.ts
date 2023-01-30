import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TokenService} from "../services/token/tokenService";
import {Router} from "@angular/router";
import {LoginService} from "../services/login/login.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

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
      password: ['', Validators.required],
      name:['' , Validators.required],
      lastname:['',Validators.required],
      ishotelmanager:[false,Validators.required]
    });
  }
  data : any;
  ngOnInit(): void {
  }
  onSubmit() {//continue all apis add chamber / update from angular and announce

    console.log(this.userGroup.value)
    this.http.post(this.baseUrl + '/auth/signup', this.userGroup.value).subscribe(
      data => { this.data = data ;
        this.router.navigate(['/login']);
      },
      error => {
        console.log(error)
      }
    );
  }
}
