package com.HybridFW.pages_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage 
{
	
	
	@FindBy(xpath = "//title[text()='actiTIME -  Enter Time-Track']")
	private WebElement title ;
	
	@FindBy( id = "logoutLink" )
	private WebElement logoutButton ;
	
	@FindBy( xpath = "//div[text()='TASKS']/parent::a[@class='content tasks']" )
	private WebElement tasksmodule ;
	
	@FindBy( xpath = "//div[contains(text(),'Settings')]/parent::div[@class='popup_menu_button popup_menu_button_settings']" )
	private WebElement settings ;
	
	@FindBy( xpath = "//a[text()='Licenses']" )
	private WebElement licenses ;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	public void clickOnLogout()
	{
		logoutButton.click();
	}
	
	public void clickOnTasksModule()
	{
		tasksmodule.click();
	}
	
	public void clickOnSettings()
	{
		settings.click();
	}
	
	public void clickOnLicenses()
	{
		licenses.click();
	}
	
	public void verifyETP(WebDriver driver ,  String expectedTitle)
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle , expectedTitle);
		Reporter.log("Expected page is displayed ---> " +expectedTitle , true);
	}
}
