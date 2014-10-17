package com.smc.ll.selenium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestPostCount {
 
 
	 public static void main(String... args){
		 
		 RemoteWebDriver driver = null;
		 
		 DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("internet explorer");  
			
			try{
					driver = new RemoteWebDriver(new URL("http://10.1.2.11:7777/wd/hub"), capabilities);
				}catch (MalformedURLException e){
					e.printStackTrace();
				}     
	
	           // Login to Admin portal
				AdminLoginPage admLoginPage = new AdminLoginPage(driver);
				admLoginPage.login();
			
			   driver.get("http://developerlatonyalewis.wordpress.com/wp-admin");
			   
			   /*Old login implementation */
//	           WebElement email = driver.findElement(By.id("user_login"));
//	           WebElement pwd = driver.findElement(By.id("user_pass"));
//	           WebElement submit = driver.findElement(By.id("wp-submit"));
//	           email.sendKeys("llewis408");
//		       pwd.sendKeys("wordpressmax0727");
//	           submit.click();
			   
	           // Count the number of posts.
	           driver.get("http://developerlatonyalewis.wordpress.com/wp-admin/edit.php");
	           WebElement postsContainer = driver.findElement(By.id("the-list"));
	           List postsList = postsContainer.findElements(By.tagName("tr"));
	           System.out.println(postsList.size());
	    }
	

}
