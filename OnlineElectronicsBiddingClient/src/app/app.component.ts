import { Component } from '@angular/core';
import { AuthguardGuard } from "./Guard/authguard.guard";
import { AuthService } from './services/auth.service';
import { Users } from './Tsfiles/users';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'OnlineElectronicsBidding';
  user:Users;
  name:String="Rahul";
constructor(private loginService:AuthguardGuard,private authService: AuthService)
{
  loginService=this.loginService;
 

}
  onScroll() {
    console.log('scrolled!!');
  }
}
