package com.smc.ll.selenium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


public class TestAddNewPost {
	
	 public static void main(String[] args) {
		RemoteWebDriver driver = null;
		
		//Set Globally first in order for the driver object to remain the same throught the test
		 DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("internet explorer");  
			try {
				driver = new RemoteWebDriver(new URL("http://10.1.2.11:1111/wd/hub"),capabilities);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//			File file = new File("C:/Selenium/IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//			driver = new InternetExplorerDriver();
	    
	       // Login to Admin portal - Moved to pageObject AdminLoginPage
			//Here instantiate the AdminLoginPage Object and pass the RemoteWebDriver driver into to use pass by reference
			AdminLoginPage admLoginPage = new AdminLoginPage(driver);
			admLoginPage.login();
	
	       // Go to AllPosts page
	  
	       driver.get("http://developerlatonyalewis.wordpress.com/wp-admin/edit.php");
	      // Add New Post
	       WebElement addNewPost = driver.findElement(By.linkText("Add New"));
	       addNewPost.click();
	       
	       // Add New Post's Content
	       driver.switchTo().frame("content_ifr");
	       
	       WebElement postBody = driver.findElement(By.id("tinymce"));
	       postBody.sendKeys("This is description");
	       driver.switchTo().defaultContent();
	       WebElement title = driver.findElement(By.id("title"));
	       title.click();
	       title.sendKeys("My First Post");
	       
	       
	      // Publish the Post
	       WebElement publish = driver.findElement(By.id("publish"));
	       publish.click();

	      
	}
	 }


