import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { Users } from 'src/app/Tsfiles/users';

@Component({
  selector: 'app-login-logout',
  templateUrl: './login-logout.component.html',
  styleUrls: ['./login-logout.component.css']
})
export class LoginLogoutComponent implements OnInit {


  user:Users=new Users();
	loginForm:FormGroup;
	message: string;
	message1: string;
  returnUrl: string;

  constructor(private formBuilder:FormBuilder,public authService: AuthService,private router: Router) { }

  ngOnInit() {
	 this.loginForm=this.formBuilder.group({
		email:['',[Validators.required,Validators.email]],
		password:['',[Validators.required,Validators.minLength(6)]]
	});
	this.returnUrl = '/home';
    this.authService.logout();
  }

get email(){
	return this.loginForm.get('email');
}
get password(){
	return this.loginForm.get('password');
}
	onSubmit(){
		//console.log(this.loginForm.value);
		this.message="";this.message1="";
		this.user.email=this.loginForm.controls.email.value;
		this.user.password=this.loginForm.controls.password.value;
		//console.log(this.user);
		this.authService.getUser(this.user.email,this.user.password).subscribe(
			user1=>
			{
				
				if(user1)
				{
					this.message="Login Successful.";
					localStorage.setItem('isLoggedIn', "true");
        			localStorage.setItem('token', this.loginForm.controls.email.value);
       			 	this.router.navigate([this.returnUrl]);
      }else
				{
					this.message1="Invalid Credentials.";
				}
				
      }
    
		);
		
	}

}
