package com.smc.selenium;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverCommandProcessor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitWebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.smc.selenium.components.Button;
import com.smc.selenium.framework.LoginPageObject;
import com.gargoylesoftware.htmlunit.javascript.HtmlUnitWrapFactory;
import com.thoughtworks.selenium.Selenium;

/**
 * This Tab Panel Class is a User Service that creates a New Pricing Request on the PriceLogic 
 * Current Requests  page  
 * @author llewis
 * 
 */

public class CurrentPricingRequests_New {
	public WebElement element = null;
	//public WebDriver driver;
	public RemoteWebDriver driver = null;
	public Selenium selenium;
	public String primaryTerminal;
	public JavascriptExecutor jse = null;

	/*
	 * Constructor	
	 */
	public CurrentPricingRequests_New(RemoteWebDriver driver){
		this.driver = driver;
	 
	}
	
	/**USER ACTION
	 *Navigates to PriceLogic login page
	 *@throws Exception 
	 */
	public void doNavigate()throws Exception{
		/*Original code for  local testing*/
		File file = new File("C:/Selenium/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver();
				driver.get("http://test4.smc3.com/PriceLogic");
				driver.get("http://snap4.smc3.com/PriceLogic");
				driver.get("http://localhost:8080/PriceLogic");
				driver.manage().window().maximize();				
	}
	
	
	//Takes a screen shot of the page
	public void takeScreenShot() throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Selenium\\screenshot.png"));
			System.out.println(scrFile.getAbsolutePath());
		
	}
	
	/**
	 * USER ACTION
	 * Navigates to Current then New tab
	 * @throws Exception
	 */
	public void doNavigateCurrent() throws Exception{
		element = driver.findElement(By.xpath("//a[contains(text(),'Current')]"));
		element.click();	
	}
	
	/**
	 *USER ACTION
	 * Clicks on the  New 
	 * @throws Exception
	 */
	public void clickNew() throws Exception{
		element = driver.findElement(By.xpath("//a[contains(text(),'New')]"));
		Thread.sleep(20000);
		element.click();
	}
	
	/**
	 * USER ACTION
	 * Sets the value in the setPrimaryTermial method combo field
	 * @param selectedPrimaryTerminal
	 * @throws Exception
	 */
	public void setPrimaryTerminal(String selectedPrimaryTerminal)throws Exception{

		element = driver.findElement(By.xpath("//select[@id='pricingAdjustment.primaryTerminal.value']"));
		element.click();
		element.sendKeys(selectedPrimaryTerminal);
		element.click();
	}
	
	/**
	 * USER ACTION
	 * Sets the value in the setAccountName method text field
	 * @param accountName
	 * @throws Exception
	 */
	public void setAccountName(String accountName)throws Exception{
	
		element = driver.findElement(By.xpath("//input[@id='pricingAdjustment.customer.name']"));
		element.click();
		element.sendKeys(accountName);
	}
	
	/**
	 * USER ACTION
	 * Sets the value in the setContactName method text field
	 * @param contactName
	 * @throws Exception
	 */
	public void setContactName(String contactName)throws Exception{
		element = driver.findElement(By.xpath("//input[@id='contact.name']"));
		element.click();
		element.sendKeys(contactName);
	}

	/**
	 * USER ACTION
	 * Sets the value in the setReasonForRequest method combo field
	 * @param reasonForRequest
	 * @throws Exception
	 */
	public void setReasonForRequest(String reasonForRequest)throws Exception{
		element = driver.findElement(By.xpath("//select[@name='pricingAdjustment.reasonForRequest.value']"));
		element.click();
		element.sendKeys(reasonForRequest);
		element.click();
	}
	
	/**
	 * USER ACTION
	 * Sets the setContactEmail method text field
	 * @param contactEmail
	 * @throws Exception
	 */
	public void setContactEmail(String contactEmail)throws Exception{
		element = driver.findElement(By.xpath("//input[@id='contact.email']"));
		element.click();
		element.sendKeys(contactEmail);
	}
	
	/**
	 * USER ACTION
	 * Sets the setCustomerType method combo field
	 * @param customerType
	 * @throws Exception
	 */
	public void setCustomerType(String customerType)throws Exception{
		element = driver.findElement(By.xpath("//select[@name='pricingAdjustment.customerTypeId.value']"));
		element.click();
		element.sendKeys(customerType);
		element.click();
	}
	
	/**
	 * USER ACTION
	 * Sets the setPhone method text field
	 * @param phone
	 * @throws Exception
	 */
	
	public void setPhone(String phone)throws Exception{
		element = driver.findElement(By.xpath("//input[@id='contact.phone.phone']"));
		element.click();
		element.sendKeys(phone);	
	}
	
	/**
	 * USER ACTION
	 * Sets the setReasonEXLAChosen combo field
	 * @throws Exception
	 */
	public void setReasonEXLAChosen()throws Exception{
		ArrayList <String> reportNameList = new ArrayList<String>();
		String xpathText = driver.findElement(By.xpath("//label")).getText().trim();
		for(int x = 0; x< reportNameList.size() ; x++){
			reportNameList.add(xpathText);
		}
		
		}
//		driver.findElement(By.xpath("//span[contains(text(),'Select Options')]")).click();
//		
//		element = driver.findElement(By.xpath("//select[@name = 'sStartHour']"));	
//		element.click();
//		
//		   if (element !=null){
//			   List<WebElement> options   = driver.findElements(By.tagName("option")); 
//			   	Iterator<WebElement> i = options.iterator();
//			   		while(i.hasNext())
//			   		{
//			   			hour = (((WebElement)i.next()).getText());
//			   			if(hour.equalsIgnoreCase(hours)){
//			   				
//				   			element.click();
//							Thread.sleep(2000);
//				   			element.sendKeys(hour);
//			   			}
//			   		}	
//
//		   }
//		return hours; 			   
//		
//	

		
		//element = driver.findElement(By.xpath("//html/body/div[4]/div[2]/form/div[4]/div[2]/div[1]/div[10]/div/label[1]"));
		//element.click();
		
		
		
		
		
		
		
//		
//		List<WebElement> list = driver.findElements(By.xpath("//*[@id='selectedReasonChosenArray']/div/label[1]"));
//
//		for(int i=0;i<list.size();i++){
//
//		   list.get(i).getText();
//
//		  }
	
//		driver.findElement(By.xpath("//span[contains(text(),'Select Options')]")).click();	
//		//WebElement dropDown = driver.findElement(By.xpath("//span[contains(text(),'Select Options')]"));
//		//dropDown.click();
//		
//		List<WebElement> allOptions = driver.findElements(By.xpath("//input[@name='selectedReasonChosenArray']/div/label"));
//		for(WebElement option: allOptions){
//			if(text.equalsIgnoreCase(option.getText()))
//				option.click();
//			
//		}	

	
	
//	WebElement dropDown = driver.findElement(By.xpath("//span[contains(text(),'Select Options')]")); ////label[contains(text(), '')]
//	dropDown.click();
//
//	List<WebElement> allOptions = dropDown.findElements(By.xpath("//input[@name='selectedReasonChosenArray']"));
//	for(WebElement we: allOptions){
//		we.sendKeys(Keys.DOWN);
//		Thread.sleep(300);
//		if(we.getText().equalsIgnoreCase(text));
//			we.click();
//	}
//		
//		element = driver.findElement(By.xpath("//span[contains(text(),'Select Options')]"));
//		element.click();
//		
//	
//		element = driver.findElement(By.xpath("//label[contains(text(),'Conscientious drivers')]"));
//		element.click();
//		
//		element = driver.findElement(By.xpath("//label[contains(text(),'Excellent transit times')]"));
//		element.click();
//	
//		element = driver.findElement(By.xpath("//label[contains(text(),'Flexible service offering')]"));
//		element.click();
//	}
	
	/**
	 * Clicks on the Save button to save new pricing request
	 * @throws Exception
	 */
	public void doSave()throws Exception{
		element = driver.findElement(By.xpath("//a[contains(text(),'Save')]"));
		//element = driver.findElement(By.xpath("//li//a[@onclick='setSaveButton();']"));
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", element);
	}
	
}
