package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	// Declaration of WebElements present in HomePage
	
	@FindBy(xpath = "(//a[@class='topLink'])[6]")
	private WebElement logout ;
	
	@FindBy(xpath="Home")
	private WebElement home ;
		
	@FindBy(xpath="//a[text()='Leads']")
	private WebElement leads ;

	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaign ;
	
	@FindBy(xpath="Accounts")
	private WebElement accounts ;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts ;

	@FindBy(xpath="//a[text()='Potentials']")
	private WebElement potentials ;

	@FindBy(xpath="//a[text()='Reports']")
	private WebElement reports ;

	@FindBy(xpath="//a[text()='Dashboards']")
	private WebElement dashboard ;

	@FindBy(xpath="//a[text()='Forecasts']")
	private WebElement forecasts ;

	@FindBy(xpath="//a[text()='Activities']")
	private WebElement activities ;

	@FindBy(xpath="//a[text()='Products']")
	private WebElement products ;

	@FindBy(xpath="//a[text()='Cases']")
	private WebElement cases ;

	@FindBy(xpath="//a[text()='Solutions']")
	private WebElement solution ;

	@FindBy(xpath="//a[text()='Vendors']")
	private WebElement vendor ;

	@FindBy(xpath="//a[text()='Price Books']")
	private WebElement pricebook ;
	
	@FindBy(xpath="//a[text()='Quotes']")
	private WebElement  quotes ;

	@FindBy(xpath="//a[text()='Sales Orders']")
	private WebElement salesorder  ;

	@FindBy(xpath="//a[text()='Purchase Orders']")
	private WebElement purchaseorder  ;
	
	@FindBy(xpath="//a[text()='Invoices']")
	private WebElement  invoice ;

	
	
	
	
	
	
	// Initialisation of declared WebElements in constructor
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Utilisation of WebElements
	
	public void clickLogout()
	{
		logout.click();
	}
	
	public void clickHome()
	{
		home.click();
	}
	
	public void clickLeads()
	{
		leads.click();
	}
	
	public void clickCampaing()
	{
		campaign.click();
	}
	

	public void clickAccounts()
	{
		accounts.click();
	}


	public void clickContacts()
	{
		contacts.click();
	}


	public void clickPotentials()
	{
		potentials.click();
	}


	public void clickReports()
	{
		reports.click();
	}


	public void clickDashboard()
	{
		dashboard.click();
	}


	public void clickForecast()
	{
		forecasts.click();
	}


	public void clickActivities()
	{
		activities.click();
	}


	public void clickProducts()
	{
		products.click();
	}


	public void clickCases()
	{
		cases.click();
	}


	public void clickSolutions()
	{
		solution.click();
	}


	public void clickVendors()
	{
		vendor.click();
	}

	public void clickPriceBooks()
	{
		pricebook.click();
	}


	public void clickQuotes()
	{
		quotes.click();
	}


	public void clickSalesorder()
	{	
		salesorder.click();
	}

	public void clickPurchaseOrder()
	{
		purchaseorder.click();
	}

	public void clickInvoices()
	{
		invoice.click();
	}


	
	
	
	
}

