import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {map} from'rxjs/operators';
import {  Products} from "../Tsfiles/products";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl='http://localhost:8080/api/product'

  constructor(private httpClient:HttpClient) { }

  getProductList(): Observable<Products[]>{

    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(map(response=> response._embedded.products))

  }
  

}
interface GetResponse{
    _embedded:{
      products:Products[];
    }
}
 