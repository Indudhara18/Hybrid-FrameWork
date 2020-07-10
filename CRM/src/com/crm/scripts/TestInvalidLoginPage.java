package com.crm.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.generics.BaseT1;
import com.crm.generics.BaseTest;
import com.crm.generics.FWUtils;
import com.crm.pages.LoginPage;

public class TestInvalidLoginPage extends BaseT1
{	
		@Test
		public void test_InvalidLogin() throws InterruptedException
		{
			int rowcount = tc.x_l_RowCount(TESTDATA, INVALIDCREDENTIAL);
			Reporter.log("Row Count :" + rowcount);
			
			tc.verifypage(driver, LOGINPGTITLE );
			LoginPage lp = new LoginPage(driver);
			
			for( int i=0; i<=rowcount; i++ )
			{	
				String un = tc.read_XL_Data(TESTDATA, INVALIDCREDENTIAL, i, 0);
				String pw = tc.read_XL_Data(TESTDATA, INVALIDCREDENTIAL, i, 1);
				
				lp.setLoginName(un);
				lp.setPassword(pw);
				lp.clickSignIn();
				Thread.sleep(250);
				lp.checkErrmsg();
			}	
		
			String un = tc.read_XL_Data(TESTDATA, VALIDCREDENTIAL, 1, 0);
			String pw = tc.read_XL_Data(TESTDATA, VALIDCREDENTIAL, 1, 1);
			
			lp.setLoginName(un);
			lp.clickSignIn();
			lp.manageAlertPopUp(driver);
			lp.clearLoginName();
			
			lp.setPassword(pw);
			lp.clickSignIn();
			lp.manageAlertPopUp(driver);
			lp.clearPassword();
			
			lp.clickSignIn();
			lp.manageAlertPopUp(driver);
			
			lp.setLoginName(un);
			lp.setPassword("12345");
			lp.clickSignIn();
			Thread.sleep(250);
			lp.checkInvalidErrmsg();
			
			lp.setLoginName("rashmi");
			lp.setPassword(pw);
			lp.clickSignIn();
			Thread.sleep(500);
			lp.checkErrmsg();
		}
		
		
	
	
}
