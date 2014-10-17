package com.smc.selenium;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.smc.selenium.framework.LoginPageObject;



public class TestNavigatePriceRequest extends TestCase{
	
	
	
	@Before
	public void setup(){
		//WebDriverFactory.newInstance();
		//WebDriverFactory.getBaseUrl();
	}
	
	 
	@Test
	@Category(CurrentPricingRequests_New.class)
	
	public void testNavigateToCurrent()throws Exception{
		
		RemoteWebDriver driver = null;
//		
		//Set Globally first in order for the driver object to remain the same throught the test
		 DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("internet explorer");  
			
			try {
				driver = new RemoteWebDriver(new URL("http://10.1.2.11:7777/wd/hub"),capabilities);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			//Use for home only
//			File file = new File("C:/Selenium/IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//			driver = new InternetExplorerDriver();
			
		LoginPageObject lpo = new LoginPageObject(driver);
		CurrentPricingRequests_New plcn = new CurrentPricingRequests_New(driver);
		
		
		 lpo.doLoginUser();
		// plcn.doNavigate();
		 plcn.doNavigateCurrent();
		 plcn.clickNew();
		 plcn.setPrimaryTerminal("297-PHOENIX");
		 plcn.setAccountName("123 Company");
		 plcn.setContactName("Ms. Smith");
		 plcn.setReasonForRequest("Competitive Match");
		 plcn.setContactEmail("ASmith@smc3.com");
		 plcn.setCustomerType("Manufacturer/Shipper");
		 plcn.setPhone("678-458-1111");
		 plcn.setReasonEXLAChosen();
//		 plcn.setReasonEXLAChosen("Conscientious drivers");
//		 plcn.setReasonEXLAChosen("Excellent transit times");
//		 plcn.setReasonEXLAChosen("Flexible service offering");
		 plcn.doSave();
		 plcn.takeScreenShot();

	}
	
	@After
	public void tearDown()throws Exception{
		
	}
}
