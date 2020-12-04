import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Products } from '../Tsfiles/products';

@Injectable({
  providedIn: 'root'
})
export class AddProductService {
  private url="http://localhost:8081";
  uploadImage(fileToUpload: File): Observable<string> {
    console.log(fileToUpload);
    const formData: FormData = new FormData();
    formData.append('imageFile', fileToUpload);
    console.log(formData);
    return this.http.post<string>(`${this.url}/imageUpload`,formData);

}
  
  addProduct(product: Products):Observable<Products> {
    return this.http.post<Products>(`${this.url}/addProduct`, product).pipe(catchError(this.errorHandle));
  }
  errorHandle(error: HttpErrorResponse) {
    return throwError(error.message || " Server Error");
  }

  constructor(private http:HttpClient) { }
}
