import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './Components/about/about.component';
import { AddProductComponent } from './Components/add-product/add-product.component';
import { BiddingComponent } from './Components/bidding/bidding.component';
import { CustomerpageComponent } from './Components/customerpage/customerpage.component';
import { HomeComponent } from './Components/home/home.component';
import { HomeappliencesComponent } from './Components/homeappliences/homeappliences.component';
import { LaptopsComponent } from './Components/laptops/laptops.component';
import { LoginLogoutComponent } from './Components/login-logout/login-logout.component';
import { LogoutComponent } from './Components/logout/logout.component';
import { MobilesComponent } from './Components/mobiles/mobiles.component';
import { ProductListComponent } from './Components/product-list/product-list.component';
import { SingninSignoutComponent } from './Components/singnin-signout/singnin-signout.component';
import { AuthguardGuard } from './Guard/authguard.guard';
import { WinnerComponent } from './Components/winner/winner.component';

export const routes: Routes = [   {path: '', redirectTo: '/home', pathMatch: 'full'},
{ path: 'home', component:HomeComponent  },
{ path: 'login-logout', component:LoginLogoutComponent  },
{ path: 'siginin-signout', component: SingninSignoutComponent },
{ path: 'productList', component:ProductListComponent  },
{ path: 'about', component:AboutComponent  },
{ path: 'mobile', component:MobilesComponent  },
{ path: 'Laptop', component:LaptopsComponent  },
{ path: 'homeappliences', component:HomeappliencesComponent  },
{ path: 'CustomerPage', component:CustomerpageComponent  ,canActivate:[AuthguardGuard]},
{ path: 'Logout', component:LogoutComponent  ,canActivate:[AuthguardGuard]},
{ path: 'customerAddProduct', component:AddProductComponent  ,canActivate:[AuthguardGuard]},
{path:'bidding',component:BiddingComponent},
{path:'winner',component:WinnerComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
