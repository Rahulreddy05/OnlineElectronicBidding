import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BiddingComponent } from '../Components/bidding/bidding.component';
import { ProductImages } from '../Tsfiles/ProductImages';
import { Products } from '../Tsfiles/products';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

clickId:number;
  bidProduct(clickedId: number) {

    this.clickId=clickedId;
    return clickedId;
    
    
  }
  bProduct()
  {
    console.log(this.clickId)
    return this.clickId;
  }
  constructor(private http:HttpClient) { }

  private url="http://localhost:8081";

  getHomeData():Observable<Products[]>
  {

    return this.http.get<Products[]>(`${this.url}/getProducts`);

  }
  
  getImages():Observable<ProductImages[]>{

    return this.http.get<ProductImages[]>(`${this.url}/getImages`);
  }
}
