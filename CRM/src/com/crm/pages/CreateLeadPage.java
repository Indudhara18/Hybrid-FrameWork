package com.crm.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CreateLeadPage 
{
	// Declaration
	
	@FindBy( xpath = "//input[@name='property(Company)']" )
	private WebElement compayTB ;
	
	@FindBy( xpath = "//input[@name='property(Last Name)']" )
	private WebElement lastnameTB ;
	
	@FindBy( xpath = "(//input[@name='Button'])[3]" )
	private WebElement saveBTn ;
	
	@FindBy( xpath = "//select[@name='property(saltName)']" )
	private WebElement firstNameSelectBox ;
	
	@FindBy( xpath = "//img[@title='Campaign Name Lookup']" )
	private WebElement campnameLookUp ;
	
	// Inisialition 
	
	public CreateLeadPage( WebDriver driver )
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilisation
	
	public void setCompany(String cname)
	{
		compayTB.sendKeys(cname);
	}
	
	public void setLastName(String lastname)
	{
		lastnameTB.sendKeys(lastname);
	}

	public void clickSave() 
	{
		saveBTn.click();
	}
	
	public void selectFirstName(int index)
	{
		Select sel = new Select(firstNameSelectBox);
		sel.selectByIndex(index);
	}
	
	public void selectCampaignSource(WebDriver driver) 
	{
		 String pwind = driver.getWindowHandle() ; 
		 campnameLookUp.click();	
		 Set<String> allWind = driver.getWindowHandles() ;
		 for (String eachWind : allWind) 
		 {
			 if ( eachWind.equals( pwind )  ) 
			 { }	
			 else
			 {
				 driver.switchTo().window( eachWind );
				 driver.manage().window().maximize();	 
			//	 driver.findElement(By.xpath("(//a[@class='link'])[1]")).click(); 
				 driver.close();
			 }
		 }
	}	 
}
