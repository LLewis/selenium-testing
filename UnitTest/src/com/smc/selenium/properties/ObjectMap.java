package com.smc.selenium.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Class retrieves objects from the objectmap.properties 
 * ObjectMap class is defined with a constructor to accept a single
 * argument, which is the path to the objectmap.properties file
 * @author Lewis
 *
 */

public class ObjectMap {
	
	Properties prop;
	
	public ObjectMap(String strPath){
		prop = new Properties();
		
		try{
			FileInputStream file = new FileInputStream(strPath);
			prop.load(file);
			file.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	

	public By getLocator(String strElement) throws Exception{
		
		/*Retrieve the specified object from the object list*/
		String locator = prop.getProperty(strElement);
		
		/*Extract the locator type and value from the object*/
		String locatorType =locator.split(":")[0];  //index 0 first value to left of :
		String locatorValue=locator.split(":")[1]; //index 1 second value to right of :
		
		/*For Testing and Debugging Purposes*/
		/*Will eventually put to log file, if necessary*/
		System.out.println("Retreiving object type: " + locatorType  + "  and value:  " + locatorValue + "  from the object map");
		

		/*Return an instance of the By class based on the type of locator*/
		/*This By can be used by the browser object in the actual test*/
		if(locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if(locatorType.toLowerCase().equals("name"))
				return By.name(locatorValue);		
		else if((locatorType.toLowerCase().equals("classname"))|| (locatorType.toLowerCase().equals("class")))
			return By.className(locatorValue);
		else if ((locatorType.toLowerCase().equals("tagname"))|| (locatorType.toLowerCase().equals("tag")))
			return By.tagName(locatorValue);
		else if((locatorType.toLowerCase().equals("linktext"))|| (locatorType.toLowerCase().equals("link")))
			return By.linkText(locatorValue);
		else if((locatorType.toLowerCase().equals("partiallinktext")))
			return By.partialLinkText(locatorValue);
		else if((locatorType.toLowerCase().equals("csselector"))||(locatorType.toLowerCase().equals("css")))
			return By.cssSelector(locatorValue);
		else if((locatorType.toLowerCase().equals("xpat")))
			return By.xpath(locatorValue);
		else
			throw new Exception("Unknown locator type'" + locatorType +"'" );
		
	}
	
	
	/**
	 * Now that this class can retrieve objects from the objectmap.properteis file, I can use the test script to execute the desired scenarios
	 * See the LoginPageObject
	 */
	


	
}
