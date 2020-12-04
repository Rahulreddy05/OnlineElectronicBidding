package com.capg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	public static WebElement element=null;
	public static WebElement email(WebDriver driver)
    {
	element=driver.findElement(By.name("email"));
	return element;
    }
	public static WebElement password(WebDriver driver)
    {
	element=driver.findElement(By.name("password"));
	return element;
    }
	
	public static WebElement login(WebDriver driver)
    {
	element=driver.findElement(By.name("login"));
	return element;
    }

}
