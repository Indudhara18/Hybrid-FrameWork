package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LeadsPage 
{
		// Declare the webelements present in CreateLeadsPage
	
		@FindBy( xpath = "//input[@value='New Lead' and @class='button']" )
		private WebElement leadsBTN ;
		
		@FindBy( xpath = "(//a[@class='link'])[1]" )
		private WebElement newlycreatedlead ;
				
		
		// Initilisation
		
		public LeadsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		// utilisation
		
		public void clickOnLeadsBTN()
		{
			leadsBTN.click();
		}
		
		public void verifyNewlyCreatedLead()
		{
			Assert.assertTrue( newlycreatedlead.isDisplayed() );
			Reporter.log("Lead is successfully created : " + newlycreatedlead.getText() , true);
		}
		
}
