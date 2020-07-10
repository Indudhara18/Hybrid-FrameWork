package com.crm.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCampaingPage 
{

	// Declare The WebElements 
	
	@FindBy(xpath="//input[@name='property(Campaign Name)']")
	private WebElement campaignName ;
	
	@FindBy(xpath="//input[@name='property(Start Date)']")
	private WebElement startDate ;

	@FindBy(xpath="//input[@name='property(Expected Revenue)']")
	private WebElement expectedRevenew ;

	@FindBy(xpath="//input[@name='property(Actual Cost)']")
	private WebElement actualCost ;

	@FindBy(xpath="//input[@name='property(Num sent)']")
	private WebElement numsent ;
	
	@FindBy(xpath="//select[@name='property(Type)']")
	private WebElement type ;
	
	@FindBy(xpath="//input[@name='property(End Date)']")
	private WebElement endDate ;

	@FindBy(xpath="//input[@name='property(Budgeted Cost)']")
	private WebElement budgetedCost ;

	@FindBy(xpath="//input[@name='property(Expected Response)']")
	private WebElement  expectedResponse ;
	
	@FindBy(xpath="(//input[@name='Button'])[3]")
	private WebElement savebutton ;
	
	@FindBy( xpath = "//select[@name='property(Type)']" )
	private WebElement typeselectbox ;
	
	@FindBy( xpath = "//select[@name='property(Status)']" )
	private WebElement statusSelectbox ;
	
	// Initiase The WebElements declared
	
	public CreateCampaingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Utilise the WebElements
	
	public void setCampaignName(String cname)
	{
		campaignName.sendKeys(cname);
	}

	public void setStartDate(String startdate)
	{
		startDate.sendKeys(startdate);
	}
	
	public void setExpectedrevenue(String revenue)
	{
		expectedRevenew.sendKeys(revenue);
	}
	
	public void setActualCost(String cost)
	{
		actualCost.sendKeys(cost);
	}
	
	public void setNumSent(String num)
	{
		numsent.sendKeys(num);
	}
	
	public void setType(WebDriver driver)
	{	
		Select sel = new Select( typeselectbox );
		sel.selectByValue("Banner Ads");		
	}
	
	public void setStatus( WebDriver driver )
	{
	  	Select sel = new Select( statusSelectbox );
	  	sel.selectByValue("Active");
	}
	
	public void setEndDate(String enddate)
	{
		endDate.sendKeys(enddate);
	}
	
	public void setBudgetedCost(String budgetedcost)
	{
		budgetedCost.sendKeys(budgetedcost);
	}
	
	public void setExpectedResponse(String revenue)
	{
		expectedResponse.sendKeys(revenue);
	}
	
	public void clickSave()
	{
		savebutton.click();
		
	}
	
	public void handleAlertPopUp(WebDriver driver)
	{
		Alert al = driver.switchTo().alert();
		al.accept();
	}
}
