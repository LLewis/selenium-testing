package com.smc.ll.selenium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestDeletePost {
	
	    public static void main(String... args) {
	    	 RemoteWebDriver driver = null;
	    	 
			 DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setBrowserName("internet explorer");  
				
				try{
						driver = new RemoteWebDriver(new URL("http://10.1.2.11:1111/wd/hub"), capabilities);
					}catch (MalformedURLException e){
						e.printStackTrace();
					}     
				
	           // Login to Admin portal
			   driver.get("http://developerlatonyalewis.wordpress.com/wp-admin");
	           WebElement email = driver.findElement(By.id("user_login"));
	           WebElement pwd = driver.findElement(By.id("user_pass"));
	           WebElement submit = driver.findElement(By.id("wp-submit"));
	           email.sendKeys("llewis408");
		       pwd.sendKeys("wordpressmax0727");
	           submit.click();	
	           // Go to a All Posts page
	           driver.get("http://developerlatonyalewis.wordpress.com/wp-admin/edit.php");
	            // Click on the post to be deleted
	           WebElement post = driver.findElement(By.linkText("This is descriptionMy First Post"));
	           post.click();
	           // Delete Post
	           WebElement publish = driver.findElement(By.linkText("Move to Trash"));
	           publish.click();
	       }
	}


