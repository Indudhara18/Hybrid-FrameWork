package com.crm.scripts;

import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.generics.BaseTest;
import com.crm.generics.FWUtils;
import com.crm.pages.CampaignsPage;
import com.crm.pages.CreateCampaingPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class TestCreateCampaign extends BaseTest
{
		@Test
		public void test_CreateCampaign() throws InterruptedException
		{
			String un = tc.read_XL_Data(TESTDATA, "Createcampaign", 1, 0);		
			String pw = tc.read_XL_Data(TESTDATA, "Createcampaign", 1, 1);
			String campaigname = tc.read_XL_Data(TESTDATA, "Createcampaign", 2, 2 );
			String startdate = tc.read_XL_Data(TESTDATA, "Createcampaign", 2, 3 );
			String expectedrevenue = tc.read_XL_Data(TESTDATA, "Createcampaign", 2, 4 );
			String actualcost = tc.read_XL_Data(TESTDATA, "Createcampaign", 2, 5 );
			String numsent = tc.read_XL_Data(TESTDATA, "Createcampaign", 2, 6 );
			String enddate = tc.read_XL_Data(TESTDATA, "Createcampaign", 2, 7 );
			String budgetedcost = tc.read_XL_Data(TESTDATA, "Createcampaign", 2, 8 );
			String expectedresponse = tc.read_XL_Data(TESTDATA, "Createcampaign", 2, 9 );
				
			tc.verifypage(driver, LOGINPGTITLE);
		
			LoginPage lp = new LoginPage(driver);
			lp.Login();
			Thread.sleep(1000);
			tc.verifypage(driver, HOMEPGTITLE);
		
			HomePage hp = new HomePage(driver);
			hp.clickCampaing();
			tc.verifypage(driver, CAMPAIGNPAGE);
		
			CampaignsPage cp = new CampaignsPage(driver);
			cp.clickNewCampaigns();
			tc.verifypage(driver, CREATECAMPAIGN);
		
			CreateCampaingPage ccp = new CreateCampaingPage(driver);
			ccp.setCampaignName(campaigname);
			ccp.setStartDate(startdate);
			ccp.setExpectedrevenue(expectedrevenue);
			ccp.setActualCost(actualcost);
			ccp.setNumSent(numsent);
			ccp.setType(driver);
			ccp.setStatus(driver);
//			ccp.setEndDate(enddate);
			ccp.setBudgetedCost(budgetedcost);
			ccp.setExpectedResponse(expectedresponse);
	 		ccp.clickSave();
			tc.verifypage(driver, CAMPAIGNDETAILS);
			hp.clickCampaing();
			Thread.sleep(1000);
			cp.verifyCamapaignCreated();
					
	}
}
