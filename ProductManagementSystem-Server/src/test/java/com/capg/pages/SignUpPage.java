package com.capg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
	
	public static WebElement element=null;
	
	public static WebElement name(WebDriver driver)
    {
	element=driver.findElement(By.name("name"));
	return element;
    }
	
	public static WebElement mailId(WebDriver driver)
	{
		element=driver.findElement(By.name("signupemail"));
		return element;
	}
	
	public static WebElement password(WebDriver driver)
	{
		element = driver.findElement(By.name("pwd"));
		return element;
	}
	
	public static WebElement phoneNumber(WebDriver driver)
	{
		element=driver.findElement(By.name("phonenumber"));
		return element;
	}
	

	
	public static WebElement address(WebDriver driver)
	{
		element=driver.findElement(By.name("address"));
		return element;
	}
	
	
	public static WebElement signUp(WebDriver driver)
	{
		element=driver.findElement(By.id("submit"));
		return element;
	}

}