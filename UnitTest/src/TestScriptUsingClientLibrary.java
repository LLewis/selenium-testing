import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TestScriptUsingClientLibrary{
	public RemoteWebDriver driver = null;
	
	@Test
	public void testScriptUsingClientLib(){
		/*Create a session with RemoteWebDriver to open IE*/
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("internet explorer");

		try{
			//RemoteWebDriver instance that tries to connect to 10.1.2.11 where the RemoteWebDriver server is running and listening for requests
				driver = new RemoteWebDriver(new URL("http://10.1.2.11:4444/wd/hub"),capabilities);
			}catch (MalformedURLException e){
				e.printStackTrace();
			}
		
		/*Navigate to google.com Search pae*/
		driver.get("http://google.com");
		/*Find SearchBox Element*/
		WebElement element = driver.findElement(By.name("q"));
		/*Type Packt Publishing SearchBox*/
		element.sendKeys("Packt Publishing");
		
		/*End the Session*/
		driver.quit();
	}

}
