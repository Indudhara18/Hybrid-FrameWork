package com.HybridFW.pages_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage 
{
	// Declare the WebElements present in Login Page
	
	@FindBy( id = "username" )
	private WebElement unTB ;
	
	@FindBy( name = "pwd" )
	private WebElement pwTB ;
	
	@FindBy( id = "keepLoggedInCheckBox" )
	private WebElement checkBox ;
	
	@FindBy( xpath = "//span[text()='Username or Password is invalid. Please try again.']" )
	private WebElement errMessage ;
	
	@FindBy( id = "loginButton" )
	private WebElement loginButton ;
	
	// Initialise the Declared WebElements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilisation of WebElements 
	
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void verifyErrorMessage()
	{
//		if ( errMessage.isDisplayed() )
//			Reporter.log("Error message is displayed" , true);
//		else 
//			Reporter.log("Error message not displayed" , true);
//	
		Assert.assertTrue( errMessage.isDisplayed() );
		Reporter.log("Error Message is displayed --> " + errMessage.getText() , true);
	
	}
	
	public void selectCheckBox()
	{
		checkBox.click();
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}

	public void login(String un, String pw)
	{
		unTB.sendKeys(un);
		pwTB.sendKeys(pw);
		checkBox.click();
		loginButton.click();
	}
	
	public void login()
	{
		unTB.sendKeys("admin");
		pwTB.sendKeys("manager");
		checkBox.click();
		loginButton.click();
	}
	
}
