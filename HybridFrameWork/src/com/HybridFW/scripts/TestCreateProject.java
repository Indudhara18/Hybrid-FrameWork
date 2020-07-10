package com.HybridFW.scripts;

import org.testng.annotations.Test;

import com.HybridFW.generics.Basetest;
import com.HybridFW.pages_Repository.EnterTimeTrackPage;
import com.HybridFW.pages_Repository.LoginPage;
import com.HybridFW.pages_Repository.TaskListPage;

public class TestCreateProject extends Basetest
{
	@Test
	public void test_CreateProject() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login();
		Thread.sleep(1000);
		
		String expectedTitle = tc.read_XL_Data( XL_DATA_PATH ,"Validcredential", 1, 2);
		
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.verifyETP(driver, expectedTitle);
		etp.clickOnTasksModule();
		Thread.sleep(1000);
		
		String expectedtasklistTitle = tc.read_XL_Data( XL_DATA_PATH ,"TaskListPage", 1, 2);
		
		TaskListPage tlp = new TaskListPage(driver);
		tlp.verifyTaskListPage(driver, expectedtasklistTitle);
		tlp.clickOnAddNewButton();
		Thread.sleep(500);
		tlp.clickOnNewProject();
		Thread.sleep(500);
		tlp.setProjectName( driver , "Fire Ball");
		tlp.clickoncustomerlistforproject();
		Thread.sleep(1000);
		tlp.selectCustomerForProject(driver , "Dauglass Tyre" , "Fire Ball");	
		Thread.sleep(1000);
		tlp.clickOnCreateProjectButon(driver);
	
		
//		WebElement newlycreatedproject = driver.findElement(By.xpath("//div[text()='Fire Ball ']/.."));
//		Assert.assertTrue( newlycreatedproject.isDisplayed() );
//		Reporter.log("newly created project is displayed --> " + newlycreatedproject.getText() , true);
	}
}
