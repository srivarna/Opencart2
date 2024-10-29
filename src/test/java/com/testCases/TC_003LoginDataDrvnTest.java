package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
import com.PageObjects.MyAccountPage;
import com.testBase.BaseTestClass;
import com.utilities.DataProviders;

import freemarker.log.Logger;

/* Data is valid-----login success----test pased----- logout
 * data is vallid ---login failed still --- test fail --
 * 
 * Data invalid ---login success--test fail--logout
 * Data invalid ---login unsuccess --test pass 
 */

public class TC_003LoginDataDrvnTest extends BaseTestClass {
	
     @Test(dataProvider = " ",dataProviderClass  = DataProviders.class)
     
     // getting dataproviders from other class....     
    // dataproviders class is presnt in other pakage and class so that importing that
     // data providers in same class or No need of this dataprovider.class
	public void verify_login_DDT(String email,String pwd,String exp) {

		logger.info(" ...strating TC_003DDT_logintest.....");
		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmailaddress(null);
			lp.setPassward(null);//see null values gng  check later
			lp.clickLogin();

			// MyAccount
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountExist();
			
			/* Data is valid-----login success----test pased----- logout
			 * data is vallid ---login failed still --- test fail --
			 * 
			 * Data invalid ---login success--test fail--logout
			 * Data invalid ---login unsuccess --test pass 
			 */
			if(exp.equalsIgnoreCase("valid")) {
            	if(targetPage==true) 
            	{
            		Assert.assertTrue(true);
            		macc.clcklogout();
            	}
            	else {
            		Assert.assertTrue(false);
            	}if(exp.equalsIgnoreCase("Invalid")) {
            		if(targetPage==true) 
                	{
            			macc.clcklogout();
                		Assert.assertTrue(false);// invalid pwd and usrnm but loggdin so logout and test sholud failed
                		
                	}
            		else {
            			Assert.assertTrue(true);// in case of invalid case didnt loggdin so test passd with asserttrue 
            		}
            		}
            	}
            	} catch (Exception e) {
			Assert.fail();
		}

		logger.info("...Finished TC_003DDT_loginTest.......");
	}

}
