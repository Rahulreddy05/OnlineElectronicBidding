package com.capg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	public static WebElement element=null;
	public static WebElement email(WebDriver driver)
    {
	element=driver.findElement(By.name("forgotemail"));
	return element;
    }
	
	public static WebElement forgotPassword(WebDriver driver)
    {
	element=driver.findElement(By.name("forgotpassword"));
	return element;
    }
}
