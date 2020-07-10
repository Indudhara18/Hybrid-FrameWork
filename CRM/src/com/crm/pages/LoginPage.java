package com.crm.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	// declare the elements present in Loginpage
	
	@FindBy(xpath="//input[@id='userName']")
	private WebElement loginnameTB ;
	
	@FindBy(xpath="//input[@id='passWord']")
	private WebElement pwTB ;
	
	@FindBy(xpath="//td[text()='Remember Me']")
	private WebElement remembermeCHECKBOX ;
	
	@FindBy(xpath="//input[@title='Sign In']")
	private WebElement signinBTN ;
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	private WebElement forgotPassword ;
	
	@FindBy(xpath="//img[@title='New User Registration']")
	private WebElement newUserReg ;
	
	@FindBy(xpath="//td[contains( text(),'configured')]")
	private WebElement errMSg ;
	
	@FindBy(xpath="//td[text()=' Invalid loginName/password ']")
	private WebElement invalidErrmessgage ;
	
	// initialise the declared WebElements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	// utilisation of WebElements
	
	
	public void setLoginName(String un)
	{
		loginnameTB.sendKeys(un);
	}
	
	public void clearLoginName()
	{
		loginnameTB.clear();
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void Login()
	{
		loginnameTB.sendKeys("rashmi@dell.com");
		pwTB.sendKeys("123456");
		signinBTN.click();
	}
	
	public void clearPassword()
	{
		pwTB.clear();
	}
	
	public void selectCheckBox()
	{
		remembermeCHECKBOX.click();
	}
	
	public void clickSignIn()
	{
		signinBTN.click();
	}

	public void clickForgotPassword()
	{
		forgotPassword.click();
	}

	public void clickNewUserReg()
	{
		newUserReg.click();
	}
	
	public void manageAlertPopUp(WebDriver driver)
	{
		Alert al = driver.switchTo().alert();
		al.dismiss();
		System.out.println("Alert pop handled");
	}
	
	public void checkErrmsg()
	{
		if( errMSg.isDisplayed() )
			System.out.println("Error message displayed :" + errMSg.getText());
		else
			System.out.println("Error message not dislplayed");
	}
	
	public void checkInvalidErrmsg()
	{
		if( invalidErrmessgage.isDisplayed() )
			System.out.println("Error message displayed :" + invalidErrmessgage.getText());
		else
			System.out.println("Error message not dislplayed");
	}
}
