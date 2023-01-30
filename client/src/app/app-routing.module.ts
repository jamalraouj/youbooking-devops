import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { IndexComponent } from './index/index.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import {ChambersComponent} from "./chambers/chambers.component";
import {HotelComponent} from "./hotel/hotel.component";
import {AdminComponent} from "./admin/admin.component";
import {AdminhotelComponent} from "./c-admin/adminhotel/adminhotel.component";
import {ShowhotelComponent} from "./c-admin/showhotel/showhotel.component";
import {SignupComponent} from "./signup/signup.component";
import {AddAnnounceComponent} from "./announce/add-announce/add-announce.component";
import {UpdateHotelComponent} from "./c-admin/update-hotel/update-hotel.component";
import {MyAnnounceComponent} from "./announce/my-announce/my-announce.component";

const routes: Routes = [
  {path:"about",component:AboutComponent},
  {path:"home",component:HomeComponent},
  {path:"index",component:IndexComponent},
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"admin",component:AdminComponent},
  {path:"announce/add-announce",component:AddAnnounceComponent},
  {path:"announce/my-announce",component:MyAnnounceComponent},
  {path:"admin/hotel",component:AdminhotelComponent},
  {path:"admin/hotel/show/:id",component:ShowhotelComponent},
  {path:"admin/hotel/update/:id",component:UpdateHotelComponent},
  {path:"hotel/:id"  ,component:HotelComponent}

];



@NgModule({
  imports: [RouterModule.forRoot(
    routes,

  )],
  exports: [RouterModule]

})
export class AppRoutingModule { }
