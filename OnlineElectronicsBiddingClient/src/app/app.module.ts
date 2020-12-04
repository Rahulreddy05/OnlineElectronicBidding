import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import { ProductListComponent } from './Components/product-list/product-list.component';
import { HttpClientModule } from "@angular/common/http";
import { ProductService } from './services/product.service';
import { LoginLogoutComponent } from './Components/login-logout/login-logout.component';
import { SingninSignoutComponent } from './Components/singnin-signout/singnin-signout.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule  } from '@angular/router';
import {routes} from './app-routing.module';
import { AboutComponent } from './Components/about/about.component'
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MobilesComponent } from './Components/mobiles/mobiles.component';
import { LaptopsComponent } from './Components/laptops/laptops.component';
import { HomeappliencesComponent } from './Components/homeappliences/homeappliences.component';
import { CustomerpageComponent } from './Components/customerpage/customerpage.component';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { LogoutComponent } from './Components/logout/logout.component';
import { AddProductComponent } from './Components/add-product/add-product.component';
import { BiddingComponent } from './Components/bidding/bidding.component';
import { WinnerComponent } from './Components/winner/winner.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductListComponent,
    LoginLogoutComponent,
    SingninSignoutComponent,
    AboutComponent,
    MobilesComponent,
    LaptopsComponent,
    HomeappliencesComponent,
    CustomerpageComponent,
    LogoutComponent,
    AddProductComponent,
    BiddingComponent,
    WinnerComponent,


  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    NgbModule.forRoot(),
    InfiniteScrollModule,

  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
