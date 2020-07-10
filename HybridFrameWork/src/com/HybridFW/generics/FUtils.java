package com.HybridFW.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * For File Utilisation
 * @author Indudhar
 *
 */
public class FUtils 
{
	/**
	 * read the data from Excel File
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
	public String read_XL_Data(String path , String sheet, int row , int cell)
	{
		String data = "" ;
		try {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e) { e.printStackTrace(); }
		return data ;
	}
	
	/**
	 * Count Number of data row in Excel work sheet
	 * @param path
	 * @param sheet
	 * @return
	 */
	public int count_Row_Number(String path , String sheet)
	{
		int data = 0 ;
		try {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		data = wb.getSheet(sheet).getFirstRowNum() ;
		}
		catch(Exception e) { e.printStackTrace(); }
		return data ;
	}
	
	/**
	 * Write the data into excel work sheet
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param passCount
	 */
	public void write_XL_Data(String path , String sheet , int row , int cell , int passCount)
	{
		try {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(passCount);
		wb.write(new FileOutputStream(path));
		}
		catch(Exception e) 
		{ e.printStackTrace(); }
	}
	
	public void write_XL_Data1(String path , String sheet , int row , int cell , int passCount)
	{
		try {
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(passCount);
		wb.write(new FileOutputStream(path));
		}
		catch(Exception e) 
		{ e.printStackTrace(); }
	}
	
	/**
	 * Take Screenshot when Testcase is failed
	 * @param driver
	 * @param path
	 */
	public void takeScreenShot(WebDriver driver , String path)
	{
		try {
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File src = ts.getScreenshotAs(OutputType.FILE) ;
		File des = new File(path) ;
		FileUtils.copyFile(src, des);	}
		catch( Exception e )	
		{ e.printStackTrace(); }
	}
	
	/**
	 * To Verify the page
	 * @param driver
	 * @param expectedTitle
	 */
	public void verifyPage(WebDriver driver , String expectedTitle)
	{
		String actualTitle = driver.getTitle() ;
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("The Page is verified -->" +expectedTitle , true);
	}
	
}
