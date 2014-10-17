package com.smc.ll.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.LoadableComponent;


public class AdminLoginPage extends LoadableComponent<AdminLoginPage> {
	RemoteWebDriver driver;
	/*Used the enumeration How FindBy declared elements are initialized */
	/*The WebDriver locaetes the element using the locating mechanism ID with the value user_login and assigns that element to the WebElement email*/
//	@FindBy(how=How.ID, using="user_login")
	WebElement email;
	WebElement pwd;
	WebElement submit;

	/*Constructor */
	public AdminLoginPage(RemoteWebDriver driver){
		this.driver = driver;	
		   driver.get("http://developerlatonyalewis.wordpress.com/wp-admin");
	        email = driver.findElement(By.id("user_login"));
	        pwd = driver.findElement(By.id("user_pass"));
	        submit = driver.findElement(By.id("wp-submit"));
	}
	
	 // Login to Admin portal
	public void login(){
		email.sendKeys("llewis408");
	    pwd.sendKeys("wordpressmax0727");
	    submit.click();	
	}
	
	
	@Override
	protected void load(){
		 driver.get("http://developerlatonyalewis.wordpress.com/wp-admin");
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(driver.getCurrentUrl().contains("wp-admin"));
		
	}
	

}
