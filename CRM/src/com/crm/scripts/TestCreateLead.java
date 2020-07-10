package com.crm.scripts;

import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.generics.BaseTest;
import com.crm.pages.CreateLeadPage;
import com.crm.pages.HomePage;
import com.crm.pages.LeadsPage;
import com.crm.pages.LoginPage;

public class TestCreateLead extends BaseTest
{

	@Test
	public void test_createLead() throws InterruptedException
	{
		tc.verifypage(driver, LOGINPGTITLE);
		
		LoginPage lp = new LoginPage(driver);
		lp.Login();
		Thread.sleep(1000);
		tc.verifypage(driver, HOMEPGTITLE);
		
		HomePage hp = new HomePage(driver);
		hp.clickLeads();
		Thread.sleep(1000);
		tc.verifypage(driver, LEADSPAGE);
		
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnLeadsBTN();
		Thread.sleep(1000);
		tc.verifypage(driver, CREATELEAD);
		
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.selectFirstName(1);
		Thread.sleep(1000);
		clp.setCompany("Infosys");
		Thread.sleep(1000);
		clp.setLastName("Sudha murthy");
		Thread.sleep(1000);
		clp.selectCampaignSource(driver);
		Thread.sleep(2000);
		clp.clickSave();
		Thread.sleep(1000);
		tc.verifypage(driver, LEADDETAILS);
		
//		hp.clickLeads();
//		Thread.sleep(1000);
//		lep.verifyNewlyCreatedLead();
//		
		
	}
	
}
