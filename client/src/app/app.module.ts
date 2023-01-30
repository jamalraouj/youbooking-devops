import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { IndexComponent } from './index/index.component';
import { NavbarComponent } from './navbar/navbar.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {TokenInterceptor} from "./services/token/tokenInterceptor";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChambersComponent } from './chambers/chambers.component';
import { HotelComponent } from './hotel/hotel.component';
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MatTableModule} from "@angular/material/table";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerModule} from "@angular/material/datepicker";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminComponent } from './admin/admin.component';
import { AdminnavbarComponent } from './adminlayout/adminnavbar/adminnavbar.component';
import { AdminsidebarComponent } from './adminlayout/adminsidebar/adminsidebar.component';
import { AdminfooterComponent } from './adminlayout/adminfooter/adminfooter.component';
import { AdminhotelComponent } from './c-admin/adminhotel/adminhotel.component';
import { ShowhotelComponent } from './c-admin/showhotel/showhotel.component';
import { SignupComponent } from './signup/signup.component';
import { AddAnnounceComponent } from './announce/add-announce/add-announce.component';
import { UpdateHotelComponent } from './c-admin/update-hotel/update-hotel.component';
import { MyAnnounceComponent } from './announce/my-announce/my-announce.component';
import {LocationStrategy, PathLocationStrategy} from "@angular/common";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    IndexComponent,
    NavbarComponent,
    LoginComponent,
    ChambersComponent,
    HotelComponent,
    AdminComponent,
    AdminnavbarComponent,
    AdminsidebarComponent,
    AdminfooterComponent,
    AdminhotelComponent,
    ShowhotelComponent,
    SignupComponent,
    AddAnnounceComponent,
    UpdateHotelComponent,
    MyAnnounceComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
        MatSlideToggleModule,
        MatTableModule,
        MatCardModule,
        MatFormFieldModule,
        MatDatepickerModule,
        FormsModule,
        NgbModule,

    ],
  providers: [{
                provide: HTTP_INTERCEPTORS,
                useClass: TokenInterceptor,
                multi: true
  },
    { provide: LocationStrategy, useClass: PathLocationStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
