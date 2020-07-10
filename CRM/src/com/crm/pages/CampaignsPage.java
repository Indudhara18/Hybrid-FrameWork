package com.crm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CampaignsPage 
{
	// Declare The WebElements 
	
	@FindBy(xpath="//input[@value='New Campaign']")
	private WebElement newcampaign ;
	
	@FindBy( xpath = "(//tr)[13]" )
	private WebElement recentCampaign ;
	
	
	// Initiase The WebElements declared
	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Utilise the WebElements
	
	public void clickNewCampaigns()
	{
		newcampaign.click();
	}
	
	public void verifyCamapaignCreated() 
	{
		Assert.assertTrue(recentCampaign.isDisplayed());
		Reporter.log("campaign is created succesfully : " + recentCampaign.getText() , true);
	}
	
}
