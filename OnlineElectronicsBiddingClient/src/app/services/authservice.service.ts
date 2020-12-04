import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Users } from '../Tsfiles/users';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  private url="http://localhost:8081";
  constructor(private http:HttpClient) { }
  getUser(email:string,password:string):Observable<Users>
	{
		return this.http.get<Users>(`${this.url}/getUser/`+email+`/`+password).pipe(catchError(this.errorHandle));;
  }

	logout(): void {
    sessionStorage.setItem('isLoggedIn', "false");
    sessionStorage.removeItem('token');
  } 
  errorHandle(error: HttpErrorResponse) {
    return throwError(error.message || " Server Error");
  }
}
