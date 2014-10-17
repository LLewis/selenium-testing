package com.smc.selenium.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ExcelDataObject {
	
	public static void main(String args[]) throws IOException{
		try {
		/*Open the Excel file*/
		FileInputStream file = new FileInputStream("C:\\testdata.xls");
		
		/*Access the required test data sheet*/
		//create an object for the workbook - requires the workbook name
		HSSFWorkbook wb = new HSSFWorkbook(file);
		//create an object for the sheet - requires the sheet name
		HSSFSheet sheet = wb.getSheet("testdata");
		
		/*Loop through all rows in the sheet*/
		/*Start a new row 1 as row 0 is our header row*/
		for(int count = 1; count<=sheet.getLastRowNum(); count++){
			HSSFRow row = sheet.getRow(count);
			System.out.println("Running test case"  + row.getCell(0).toString());
			
			/*Run the test for the current test data row*/
			
			runTest(row.getCell(1).toString(),row.getCell(2).toString());
		}
		file.close();
		}catch (IOException e){
			System.out.println("Test data file not found");
		}
	}

	public static void runTest(String strSearchString, String strPageTitle){
		RemoteWebDriver driver = null;
		
		//Set Globally first in order for the driver object to remain the same throught the test
		 DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("internet explorer");  
			
			try {
				driver = new RemoteWebDriver(new URL("http://10.1.2.11:7777/wd/hub"),capabilities);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			driver.get("http://google.com");
			
			/*Enter the search string and send it */
			WebElement element = driver.findElement(By.name("q"));
			element.sendKeys(strSearchString);
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			element.submit();
			
			/*Check the title of the page */
			if (driver.getTitle().equals(strPageTitle)){
				System.out.println("Page title is"  + strPageTitle + ", as expected");
				
			}else {
				System.out.println("Expected page title was" + strPageTitle + ", but was " + driver.getTitle() + " instead");
			}
			
			/*Close the Browser*/
			driver.quit();
	}
	
}
