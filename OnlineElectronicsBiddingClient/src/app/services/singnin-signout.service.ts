import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Users } from '../Tsfiles/users';

@Injectable({
  providedIn: 'root'
})
export class SingninSignoutService {
  private url="http://localhost:8081";
  constructor(private http:HttpClient) { }

	register(user:Users):Observable<Users>
	{
		return this.http.post<Users>(`${this.url}/register`,user).pipe(catchError(this.errorHandle));;
	}
	errorHandle(error: HttpErrorResponse) {
    return throwError(error.message || " Server Error");
  }
}
