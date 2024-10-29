package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.PageObjects.MyAccountPage;
import com.testBase.BaseTestClass;

public class TC_002LoginTest extends BaseTestClass {
	
	@Test(groups = {"Sanity","Master"})
	public void verify_Login() {
		logger.info("..........Strating home page..........");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("..........strating login page..........");
		LoginPage lp=new LoginPage(driver);
		lp.setEmailaddress(p.getProperty("email"));
		lp.setPassward(p.getProperty("passward"));
		lp.clickLogin();
		
		//Myaccout page valiadtion 
		
		MyAccountPage MAc=new MyAccountPage(driver);
		boolean targetPage=((MyAccountPage) MAc).isMyAccountExist();
		//Assert.assertEquals(targetPage, true,"Login failed");//just this is for fail TCS
		Assert.assertTrue(targetPage);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("........login finished.........");
	}

}
