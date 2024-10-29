package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.AccountsRegistrationPage;
import com.PageObjects.HomePage;
import com.testBase.BaseTestClass;

public class TC_001AcountsRegistrationTest extends BaseTestClass {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {

		logger.info(".......strating TC001......");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on my account link");
			hp.clickLogin();
			logger.info("login page clicked");

			hp.clickRegister();
			logger.info("clicked on register link");

			// To access accounts page need to create object
			// Randomly created data getrandomString () used as a user defined method , so
			// randomly created data dynamically at the runtime

			AccountsRegistrationPage regpage = new AccountsRegistrationPage(driver);
			regpage.setFirstName(geRandomString().toUpperCase());// purely alphabetic
			regpage.setLastName(geRandomString().toUpperCase());
			regpage.setEmail(geRandomString() + "@gmail.com");
			regpage.setTelephonmber(getRandomNumber());// purely randomnumber
			logger.info("clicked register link");

			// random data for passwrd by user defibned methd
			// callng two times so genarating different alphanumrics but pwd and cnfrmpwd
			// should same
			// capture that passward padssd to setpassward(,setcnfrmpassword
			// passwordgenerated is passsd to bot set an d cnfrmpassword
			String password = getrandomAlphaNumeric();

			regpage.setPassward(password);
			regpage.setCnfrmPassward(password);
			regpage.clckPolicy();
			regpage.clckContinue();

			String confrmsg = regpage.getconfrmMsg();

			if (confrmsg.equals("Your Account Has Been Created!!!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed");
				logger.debug("Debug faled");
				Assert.assertTrue(false);
			}
			// Assert.assertEquals(confrmsg, "Your Account Has Been Created!");
			logger.info("Validating expected mesge");
		} catch (Exception e) {

			Assert.fail();
		}
	}

}
