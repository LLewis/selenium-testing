package com.smc.selenium.framework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.smc.selenium.properties.ObjectMap;

public class LoginPageObject {
	
	WebElement email,pwd, submit, element;
	RemoteWebDriver driver = null;
	ObjectMap objMap = new ObjectMap("resources/objectmap.properties");
	
	/**
	 * Sets class driver to internet explorer browser
	 * and locates elements for user login
	 * @param driver
	 * @throws Exception
	 */
	public LoginPageObject(RemoteWebDriver driver) throws Exception{
		this.driver = driver;
		driver.get("http://test4.smc3.com/PriceLogic");
		
		/*retrieving objects from the objectmap.properties file*/
		email = driver.findElement(objMap.getLocator("pl.loginPage.email"));
		//email = driver.findElement(By.id("username"));
		pwd = driver.findElement(objMap.getLocator("pl.loginPage.pwd"));
		//pwd = driver.findElement(By.id("password"));
		submit = driver.findElement(objMap.getLocator("pl.loginPage.submit"));
		//submit = driver.findElement(By.name("submit"));
	}
	
	/**
	 * Sets user login name and password
	 * @throws Exception 
	 */
	public void doLoginUser()throws Exception{
		email.sendKeys("exlaam@smc3.com");
		pwd.sendKeys("exla");
		submit.submit();
	}
	
	
}
