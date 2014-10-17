package com.smc.selenium;



import java.io.File;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;







import org.junit.Before;
import org.junit.Test;


import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Document;




@SuppressWarnings("hiding")
public class TestLoginPriceLogic<Suite> extends TestCase{
	
	
	
	WebDriver driver = null;
	WebElement login, element = null;
	JavascriptExecutor jse = null;
	
	@Before
	public void setup(){
	
		File file= new File("C:/Selenium/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		driver.get("http://localhost:8080/PriceLogic");

	}
	
	@Test
	public void loginUser() throws Exception{
		element = driver.findElement(By.id("username"));
		element.sendKeys("exlaam@smc3.com");

		element = driver.findElement(By.id("password"));
		element.sendKeys("exla");

		element = driver.findElement(By.name("submit"));
		element.submit();

		
		
//		//Click on Current
//		login = driver.findElement(By.xpath("//a[contains(text(),'Current')]"));
//		login.click();
//	
//		
//		//Click on New -Account Summary Tab
//		login = driver.findElement(By.xpath("//a[contains(text(),'New')]"));
//		login.click();
//		//Select Primary Terminal
//		element = driver.findElement(By.xpath("//select[@name='pricingAdjustment.primaryTerminal.value']"));
//		element.click();
//		element.sendKeys("297-PHOENIX");
//		element.click();
//		//Input Account Name
//		element = driver.findElement(By.xpath("//input[@id='pricingAdjustment.customer.name']"));
//		element.click();
//		element.sendKeys("ABC Company");
//		//Input Contact Name
//		element = driver.findElement(By.xpath("//input[@id='contact.name']"));
//		element.click();
//		element.sendKeys("Mrs. Smith");
//		//Reason for Request
//		element = driver.findElement(By.xpath("//select[@name='pricingAdjustment.reasonForRequest.value']"));
//		element.click();
//		element.sendKeys("Amanda's New Reason for Request");
//		element.click();
//		//Input Contact Email Address
//		element = driver.findElement(By.xpath("//input[@id='contact.email']"));
//		element.click();
//		element.sendKeys("LSmith@smc3.com");
//		//Select Customer Type
//		element = driver.findElement(By.xpath("//select[@name='pricingAdjustment.customerTypeId.value']"));
//		element.click();
//		element.sendKeys("Distributor/Shipper");
//		element.click();
//		//Input Phone
//		element = driver.findElement(By.xpath("//input[@id='contact.phone.phone']"));
//		element.click();
//		element.sendKeys("777-777-7777");
//		//Select 3 Reason EXLA Chosen 
//		element = driver.findElement(By.xpath("//a[@id='selectedReasonChosenArray']"));
//		element.click();
//		driver.findElement(By.xpath("//label[contains(text(),'Conscientious drivers')]")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'Excellent transit times')]")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'Flexible service offering')]")).click();
//		
//		//Click Save button 
//		login = driver.findElement(By.xpath("//a[@onclick='setSaveButton();']"));
//		jse = (JavascriptExecutor)driver;
//		jse.executeScript("arguments[0].click();", login);
//	
//		
//		
		
		//setPrimaryTerminal("297-PHOENIX");
		
		//Click on Current
		//login = driver.findElement(By.xpath("//a[contains(text(),'Current')]"));
		//login.click();
//		
//		
//		//Click on From Existing Account
//		login = driver.findElement(By.xpath("//a[contains(text(),'From Existing Account')]"));
//		login.click();
//		//Click on Current
//		login = driver.findElement(By.xpath("//a[contains(text(),'Current')]"));
//		login.click();
//		
//		//Select Row then Click on Edit  Modify to select any row
//		login = driver.findElement(By.id("row-pricingAdjustmentsUid-1"));
//		login.click();
//		//Click on Edit
//		login = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
//		login.click();
//		//Click on Current
//		login = driver.findElement(By.xpath("//a[contains(text(),'Current')]"));
//		login.click();
//		
//		//Select Row then Click on Edit  Modify to select any row
//		login = driver.findElement(By.id("row-pricingAdjustmentsUid-1"));
//		login.click();
//		//Click on Delete
//		login = driver.findElement(By.xpath("//a[contains(text(),'Delete')]"));
//		login.click();
//		//Click on OK
//		login = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
//		login.click();
//		//Click on Current
//		login = driver.findElement(By.xpath("//a[contains(text(),'Current')]"));
//		login.click();
//		
//		//Click on Download Template
//		//login = driver.findElement(By.xpath("//a[contains(text(),'Download Template')]"));
//		//login.click();
//		
//		//Click on Download Notice of Publication
//		login = driver.findElement(By.xpath("//td[contains(text(),'Published')]"));
//		login.click();
//		//Click on Download NOP
//		login = driver.findElement(By.xpath("//a[contains(text(),'Download Notice of Publication')]"));
//		login.click();
//		//Click on Yes
//		login = driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
//		login.click();
//		
	
	
	}
	
//	public void setPrimaryTerminal(String selectedPrimaryTerminal){
//		String primaryTerminal;
//		element = driver.findElement(By.xpath("//select[@name='pricingAdjustment.primaryTerminal.value']"));
//		if(element !=null)
//		{
//			List<WebElement>options = driver.findElements(By.tagName("option"));
//				Iterator<WebElement>i = options.iterator();
//					while(i.hasNext())
//					{
//						primaryTerminal=(((WebElement)i.next()).getText());
//						if(primaryTerminal.equalsIgnoreCase(selectedPrimaryTerminal)){
//							element.click();
//							element.sendKeys(primaryTerminal);
//							
//						}
//					}
//		}
//
//	
//		
//		
//	
//	
//	}
	
	
	
	
}
