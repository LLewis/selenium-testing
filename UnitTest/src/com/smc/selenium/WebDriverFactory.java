package com.smc.selenium;

import java.util.HashMap;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.IncorrectnessListener;
import com.gargoylesoftware.htmlunit.WebClient;



public class WebDriverFactory {
	public enum Browser{
		FIREFOX, CHROME, IE, HTMLUNIT
	};
	
	/**
	 * Creates a new WebDriver instance determined by the <i>selenium.browser</i> property.
	 * @return webDriver
	 * 
	 */
	//Call method to create preferred browser first then invokes overloaded newInstance 
	public static WebDriver newInstance(){
		HashMap<String, Browser> knownBrowsers = new HashMap<String, Browser>();
		knownBrowsers.put("ie", Browser.IE);
		knownBrowsers.put("firefox", Browser.FIREFOX);
		knownBrowsers.put("chrome", Browser.CHROME);
		knownBrowsers.put("htmlunit", Browser.HTMLUNIT);
		
		WebDriver webDriver;
		Exception err = null;
		String preferredBrowser = System.getProperty("selenium.browser", "ie");
		
		Browser browser = knownBrowsers.get(preferredBrowser.toLowerCase());
		
		if (browser == null)
			throw new RuntimeException("Invalid selenium.browser property: " + preferredBrowser);
		
		try{
			
			webDriver = newInstance(browser);
			assert webDriver !=null;
			return webDriver;
		}catch (Exception e){
			throw new RuntimeException("Unable to create WebDriver instance", err);
		}
		
	}
	
	//Overloaded newInstance
	public static WebDriver newInstance(Browser newBrowser){
		
		switch(newBrowser){
		case IE:
			return new InternetExplorerDriver();
		case FIREFOX:
			return new FirefoxDriver();
		case CHROME:
			return new ChromeDriver();
			/**
			 * Fully capable HtmlUnitDriver and
			 * silence the warnings about text/javascript
			 */
		case HTMLUNIT:
			HtmlUnitDriver htmlDriver = new HtmlUnitDriver(new DesiredCapabilities(
					"htmlunit", "firefox", Platform.ANY)){
				@Override
				protected WebClient modifyWebClient(WebClient client){
					final IncorrectnessListener delegate = client.getIncorrectnessListener();
					client.setIncorrectnessListener(new IncorrectnessListener() {
						@Override
						public void notify(String message, Object origin){
							if (message.contains("Obsolete") && message.contains("/javascript"))
								return;
							
							delegate.notify(message, origin);
						}
					});
					return super.modifyWebClient(client);
								
				}
			};
			return htmlDriver;
			
		default:
			throw new IllegalArgumentException("Invalid browser specified");
			
		}
	}
	/**
	 * Get the base URL specified in system property<i>selenium.baseurl</i>
	 * 
	 */
	public static String getBaseUrl(){
		String baseUrl = System.getProperty("selenium.baseurl");
		return baseUrl;
	}

	
}	