package com.HybridFW.pages_Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class TaskListPage 
{
	@FindBy( xpath = "//div[text()='Add New']/parent::div[@class='addNewButton']" )
	private WebElement addNewButton ;
	
	@FindBy( xpath = "//div[text()='+ New Customer']" )
	private WebElement newCustomerButton ;
	
	@FindBy( xpath = "//input[@id='customerLightBox_nameField']" )
	private WebElement customerNameTB ;
	
	@FindBy( xpath = "//textarea[@id='customerLightBox_descriptionField']" )
	private WebElement customerDescriptionTA ;
	
	@FindBy( xpath = "//span[text()='Create Customer']/parent::div[@class='buttonIcon']" )
	private WebElement createCustomerButton ;
	
	@FindBy( xpath = "//a[@class='x-menu-item']" )		
	private List<WebElement> allcustomerslist ;
	
	@FindBy( xpath = "//div[@id='customerLightBox_nameDuplicateError']" )
	private WebElement customerDuplicate ;
	
	@FindBy( xpath = "//div[@id='customerLightBoxCloseButton']" )
	private WebElement closeCustomerXBtn ;

	@FindBy( xpath = "//div[text()='+ New Project']"  )
	private WebElement newProject ;
	
	@FindBy( xpath = "//div[@id='projectPopup_projectNameErrorWrapper']" )
	private WebElement projectName ;
	
	@FindBy( xpath = "//button[@id='ext-gen23']" )
	private WebElement selectCustomerForProject ;
	
	@FindBy( xpath = "//input[@id='projectPopup_projectNameField']" )
	private WebElement projnameTBforProject ;
	
	@FindBy( xpath = "//button[@id='ext-gen23']" )
	private WebElement selcustforproj ;
	
	@FindBy( xpath = "//li[@class='x-menu-list-item ']" )
	private List<WebElement> listOfCustomersforproject ;
	
	@FindBy( xpath = "//div[text()='Project already exists']" )
	private WebElement projectDuplicate ;
	
	@FindBy( xpath = "//div[@id='closeProjectLightBoxBtn']" )
	private WebElement closeProjectXBtn ;
	
	@FindBy( xpath = "//a[text()='-- New Customer --']" )
	private WebElement newcust ;
	
	@FindBy( xpath = "//input[@id='projectPopup_newCustomerNameField']" )
	private WebElement entercustomername ;
	
	@FindBy( xpath = "//input[@id='projectPopup_projectNameField']" )
	private WebElement projnamefield ;
	
	@FindBy( xpath = "//textarea[@id='projectPopup_projectDescriptionField']" )
	private WebElement projectDescriptionTA ;
	
	@FindBy( xpath = "//span[text()='Create Project']/ancestor::div[@id='projectPopup_commitBtn']" )
	private WebElement createProjectButton ;
	
	@FindBy( xpath = "//div[text()='Add New Task']/parent::div[@class='addNewButton']" )
	private WebElement addNewTask ;
	
	@FindBy( xpath = "//div[text()='Create new tasks']" )
	private WebElement createNewTasks ;
		
	@FindBy ( xpath = "//div[@id='createTasksPopup_customerSelector']/table" )
	private WebElement createtaskpopup ;
	
	@FindBy( xpath = "//a[text()='- New Customer -']" )
	private WebElement newcustfortask ;
	
	@FindBy ( xpath = "//li[@class='x-menu-list-item']/../*" )
	private List<WebElement> customerlistfortask ;
	
	@FindBy ( xpath = "//div[@id='createTasksPopup_projectSelector']/table")
	private WebElement createtaskpopupforproj ;
	
	@FindBy( xpath = "//div[@class='x-layer x-menu at-dropdown-list-btn-menu customerProjectListSelector projectListSelector createTasksCustomerProjectSelector']/ul/li" )
	private List<WebElement> projlistfortask ;
	
	@FindBy( xpath = "//button[text()='- Select Customer -']/ancestor::tr[@id='ext-gen318']" )
	private WebElement selectCustomerForTask ;
	
	@FindBy(xpath = "//tr[@id='ext-gen327']")
	private WebElement selectProjectForTask ;
	
	@FindBy( xpath = "//input[@class='inputFieldWithPlaceholder']" )
	private List<WebElement> entertaskname ;
	
	@FindBy( xpath = "//div[@id='closeCreateTasksPopupButton']" )
	private WebElement closeTaskXBTN ;
		
	@FindBy( xpath = "//span[text()='Create Tasks']/../.." )
	private WebElement createTaskButton ;
		
	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddNewButton()
	{
		addNewButton.click();
	}
	
	public void clickOnNewCustomerButton() 
	{
		newCustomerButton.click();
	}
	
	public void clickOnNewProject() 
	{
		newProject.click();
	}
	
	public void clickOnAddNewTask() 
	{
		addNewTask.click();
	}
	
	public void setCustomerName(String customername) 
	{
		customerNameTB.sendKeys(customername);
	}
	
	public void setCustomerDescription( String description ) 
	{
		customerDescriptionTA.sendKeys(description);
	}
	
	public void clickOnCreateCustomerButton( WebDriver driver ) throws InterruptedException 
	{
		createCustomerButton.click();
		Thread.sleep(1000);
		if (customerDuplicate.isDisplayed()) 
		{
			Assert.assertTrue( customerDuplicate.isDisplayed() );
			Reporter.log("Specified Customer is already present" , true);
			closeCustomerXBtn.click();
			Thread.sleep(500);
			driver.switchTo().alert().accept();
		}
	}
	
	public void verifyCustomerIsCreated( WebDriver driver , String cname)
	{
		driver.navigate().refresh();
		
		for (WebElement customer : allcustomerslist) 
		{
			String cn = customer.getText();
			if (cn.equals(cname)) 
			{
				Reporter.log("Customer is created : " + cname , true);	 
			} 
		}
	}
	
	public void setProjectName( WebDriver driver  ,String projectname) 
	{
		driver.switchTo().activeElement().sendKeys(projectname);
	}
	
	public void clickoncustomerlistforproject() 
	{
		selcustforproj.click();
	}
	
	public void selectCustomerForProject( WebDriver driver , String customername , String projectname) throws InterruptedException
	{
		
		for (WebElement c : allcustomerslist) 
		{	
			String cn = c.getText() ;
			Reporter.log(cn , true);
			if (cn.equals(customername)) 
			{
				c.click();	
			}	
		}
		Thread.sleep(1000);
		
		if (newcust.isDisplayed()) 
		{
			projnameTBforProject.clear();
			Reporter.log("The Mentioned customer is not yet created and its creating now"  , true);	
			newcust.click();
			entercustomername.sendKeys(customername);
			projnamefield.sendKeys(projectname);
			Reporter.log("Mentioned customer " + customername + " is created successfully and project " +projectname+ " is created under "+customername  , true);
		}		
	}
	
	public void setProjectDescription( String description ) 
	{
		projectDescriptionTA.sendKeys(description);
	}
	
	public void clickOnCreateProjectButon(WebDriver driver) throws InterruptedException 
	{
		createProjectButton.click();
		
		Thread.sleep(1000);
		if (projectDuplicate.isDisplayed()) 
		{
			Assert.assertTrue( projectDuplicate.isDisplayed() );
			Reporter.log("Specified Project is already present under given customer, project name cannot be same under same customer" , true);
			closeProjectXBtn.click();
			Thread.sleep(500);
			driver.switchTo().alert().accept();
		}
	}
	
	public void clickOnCreateNewTasks() 
	{
		createNewTasks.click();
	}
	 
	public void selectCustomerForTasks( WebDriver driver, String customername ) throws InterruptedException 
	{
		createtaskpopup.click();
		Thread.sleep(500);
		 for (WebElement cust : customerlistfortask) 
		 {
			 String custname = cust.getText() ;
			 Reporter.log(custname , true);
			 if (custname.equalsIgnoreCase(customername)) 
			 {
				 cust.click();
			//	 break ;
			 }
		 }	 
		 Thread.sleep(500);
		 if( newcustfortask.isDisplayed() )
		 {
			 Reporter.log("Mentioned customer "+customername+ " is not yet created, first create customer inorder to create task"  , true);				
		 }
	}
	
	public void selectProjectForTasks(WebDriver driver , String projectname ) throws InterruptedException
	{
		 createtaskpopupforproj.click();
		 Thread.sleep(500);
		 for (WebElement proj : projlistfortask) 
		 {	
			 String projname = proj.getText() ;
			 Reporter.log( projname , true );
			 if (projname.equalsIgnoreCase(projectname)) 
			 {
				 proj.click();
			//	 break ;
			 }
		 }
	}
	
	public void clickOnCreateTasksButton() 
	{
		createTaskButton.click();
	}
	
	public void verifyTaskListPage( WebDriver driver , String expectedTitle )
	{
		String actualTitle = driver.getTitle() ;
		Assert.assertEquals(actualTitle, expectedTitle);
		Reporter.log("Expected Page is displayed--> " +expectedTitle , true);
	}
}
