package com.capg.stepdefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.capg.pages.ChangePassword;
import com.capg.pages.ForgotPasswordPage;
import com.capg.pages.Login;
import com.capg.pages.SignUpPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	@Before
	public void setBrowserEnv1() {

//		System.setProperty("webdriver.chrome.driver", "/Users/rahulreddy/Downloads/chromedriver");
		WebDriverManager.chromedriver().setup();
		
	}
	
	@Given("^Open Chrome Browser And Navigate to signup$")
	public void open_Chrome_Browser_And_Navigate_to_signup() throws Throwable {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/siginin-signout");
	}

	@When("^User enters name \"(.*?)\"$")
	public void user_enters_name(String name) throws Throwable {
		WebElement nameElement= SignUpPage.name(driver);
		  nameElement.sendKeys(name);
	}

	@When("^User enters a valid email \"(.*?)\"$")
	public void user_enters_a_valid_email(String email) throws Throwable {
		WebElement mailElement=SignUpPage.mailId(driver);
		mailElement.sendKeys(email);
	}

	@When("^user enters password \"(.*?)\"$")
	public void user_enters_password(String pwd) throws Throwable {
		WebElement pwdElement= SignUpPage.password(driver);
	    pwdElement.sendKeys(pwd);
	}

	@When("^User enters a valid phonenumber \"(.*?)\"$")
	public void user_enters_a_valid_phonenumber(String phonenumber) throws Throwable {
		WebElement phonenumberElement= SignUpPage.phoneNumber(driver);
	    phonenumberElement.sendKeys(phonenumber);
	}



	@When("^User enters address \"(.*?)\"$")
	public void user_enters_address(String address) throws Throwable {
		WebElement addElement=SignUpPage.address(driver);
		addElement.sendKeys(address);
	}

	@Then("^User clicks on signup button$")
	public void user_clicks_on_signup_button() throws Throwable {
		WebElement subElement=SignUpPage.signUp(driver);
		/*
		 * js=(JavascriptExecutor)driver; String script="alert('Email will be sent');";
		 */ 
		subElement.click();
		//js.executeScript(script);
	}
	
//	@Given("^Open Chrome Browser And Navigate to forgotpassword$")
//	public void open_Chrome_Browser_And_Navigate_to_forgotpassword() throws Throwable {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:4200/forgot-password");
//	}
//
//	@When("^User enters email \"(.*?)\"$")
//	public void user_enters_email(String arg1) throws Throwable {
//	    WebElement email=ForgotPasswordPage.email(driver);
//	    email.sendKeys(arg1);
//	}
//
//	@Then("^User clicks on forgotpassword button$")
//	public void user_clicks_on_forgotpassword_button() throws Throwable {
//	    WebElement forgotPassword=ForgotPasswordPage.forgotPassword(driver);
//		/*
//		 * js=(JavascriptExecutor)driver; String
//		 * script="alert('Email will be sent to change password');";
//		 */
//	    forgotPassword.click();
//	  //  js.executeScript(script);
//	}
//	
//	@Given("^Open Chrome Browser And Navigate to changepassword$")
//	public void open_Chrome_Browser_And_Navigate_to_changepassword() throws Throwable {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:4200/reset-password");
//	}
//	@When("^User enters new password \"(.*?)\"$")
//	public void user_enters_new_password(String arg1) throws Throwable {
//	   WebElement nPassword=ChangePassword.nPassword(driver);
//	   nPassword.sendKeys(arg1);
//	}
//
//	@When("^user enters confirm password \"(.*?)\"$")
//	public void user_enters_confirm_password(String arg1) throws Throwable {
//		WebElement cPassword=ChangePassword.cPassword(driver);
//		cPassword.sendKeys(arg1);
//	}
//
//	@Then("^User clicks on changepassword button$")
//	public void user_clicks_on_changepassword_button() throws Throwable {
//		WebElement changePassword=ChangePassword.changePassword(driver);
//		/*
//		 * js=(JavascriptExecutor)driver; String
//		 * script="alert('Email will be sent to change password');";
//		 */
//		changePassword.click();
//	//	js.executeScript(script);
//	}
	@Given("^Open Chrome Browser And Navigate to loginpage$")
	public void open_Chrome_Browser_And_Navigate_to_loginpage() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/login-logout");
	}

	@When("^User enters login email \"(.*?)\"$")
	public void user_enters_login_email(String arg1) throws Throwable {
		WebElement email=Login.email(driver);
		email.sendKeys(arg1);
	}
	@When("^user enters login password \"(.*?)\"$")
	public void user_enters_login_password(String arg1) throws Throwable {
	    WebElement password=Login.password(driver);
	    password.sendKeys(arg1);
	}

	@Then("^User clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		WebElement login=Login.login(driver);
		login.click();
	}

	

}