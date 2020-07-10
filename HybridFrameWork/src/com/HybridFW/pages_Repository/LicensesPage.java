package com.HybridFW.pages_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LicensesPage 
{
	// Declare the WebElements present in Licenses Page
	
	@FindBy(xpath = "//nobr[text()='Issue Date:']/../../td[2]")
	private WebElement issueDate ;
	
	@FindBy( xpath = "//nobr[text()='Product Edition:']/../../td[2]" )
	private WebElement productEdition ;
	
	// Initialise the Declared WebElements
	
	public LicensesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilisation of WebElements 
	
	public void verifyIssueDate(String expectedissuedate)
	{
		String actualIssueDate = issueDate.getText();
		Assert.assertEquals(actualIssueDate, expectedissuedate);
		Reporter.log("Proper Issue Date is displayed-->" +expectedissuedate , true);
	}
	
	public void verifyProductEdition(String expectedProductEdition )
	{
		String actualProductEdition = productEdition.getText() ;
		Assert.assertEquals(actualProductEdition, expectedProductEdition);
		Reporter.log("Proper Product Edition is displayed --> " + expectedProductEdition , true);
		
	//	Assert.assertEquals(actualProductEdition, expectedProductEdition, "dc");
	}
	
	public void verifyLicensePage(WebDriver driver , String expectedTitle)
	{
		String actualTitle = driver.getTitle() ;
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Expected Page is displayed --> " +expectedTitle , true);
	}
}
