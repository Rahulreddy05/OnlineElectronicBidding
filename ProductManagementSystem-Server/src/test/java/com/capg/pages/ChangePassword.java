package com.capg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePassword {
	public static WebElement element=null;
	public static WebElement nPassword(WebDriver driver)
    {
	element=driver.findElement(By.name("npassword"));
	return element;
    }
	public static WebElement cPassword(WebDriver driver)
    {
	element=driver.findElement(By.name("cpassword"));
	return element;
    }
	
	public static WebElement changePassword(WebDriver driver)
    {
	element=driver.findElement(By.name("changepassword"));
	return element;
    }
}
