package com.crm.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import com.crm.generics.BaseTest;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class TestValidLoginPage extends BaseTest
{
	
	@Test
	public void test_ValidLoginPage() throws InterruptedException
	{
		 String expectedHPtitle = tc.read_XL_Data(TESTDATA, VALIDCREDENTIAL, 1, 2);
	
		 LoginPage lp = new LoginPage(driver);
		 lp.Login();
		 Thread.sleep(1000);
		 
		 HomePage hp = new HomePage(driver);
		 tc.verifypage(driver, expectedHPtitle);
	}

}
