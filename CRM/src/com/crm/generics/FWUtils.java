package com.crm.generics;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.BaseTestMethod;


/**
 * This class is used for complete FrameWork
 * @author Indudhara
 *
 */

public class FWUtils implements IAutoConstants
{

	/**
	 * This method is used to get title from current webpage and verify that Webpage 
	 * @param driver
	 * @param expectedTitle
	 */
	public void verifypage(WebDriver driver, String expTitle )
	{
		 String expectedtitle = expTitle ;
		 String actualTitle = driver.getTitle();
		 if ( actualTitle.equals(expectedtitle) ) 
		 {
			System.out.println("Expected Page is displayed :" + expectedtitle);
		 }
		 else
		 {
			 System.out.println("Expected Page not displayed :" + actualTitle);
		 }
	}
	
	
	/**
	 * This method is used to take screenshot
	 * @param driver
	 * @param path
	 * @throws IOException
	 */
	public void takeScreenshot(WebDriver driver, String path) 
	{
		try
		{
		 TakesScreenshot ts = (TakesScreenshot) driver ;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File des = new File(path);
		 FileUtils.copyFile(src, des);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method is used to get/read data from Excel
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
	public String read_XL_Data(String path , String sheet , int row , int cell)
	{
		String data = "" ;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	
	
	
	
	/**
	 * This method is used to count last row in Excel
	 * @param path
	 * @param sheet
	 * @return
	 */
	public int x_l_RowCount(String path , String sheet)
	{
		int rowcount = 0 ;
		
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rowcount = wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowcount ;
	}
	
	/**
	 * This method  is used to handle the alert popup
	 * @param driver
	 */
	
	public void handleAlertPopUp(WebDriver driver)
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	
	/**
	 * This method is used to create explicitly wait object
	 * @return
	 */
	
	public WebDriverWait explicitlyWait(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, ITO);
		return wait ;
	}
	
	
	/**
	 * This method is to handle Noticefication Popup
	 */
	public void handleNoticifictaionPopup()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments( "--disable-notifications" ) ;
		
		FirefoxOptions options = new FirefoxOptions() ;
		options.addArguments( "--disable-notifications" );
	}

	public void downloadFile( WebDriver driver, WebElement element , String xpathExpresssion )
	{
		element = driver.findElement(By.xpath(xpathExpresssion));
		element.click();
		
		try
		{
		Robot rbt	= new Robot();
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyPress(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
