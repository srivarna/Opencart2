package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/* page object classes only for locators an actipon methods 
 * validation are in test cases class..
 * */
public class AccountsRegistrationPage extends BasePage {

	public AccountsRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtfrstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassward;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement cnfrmpasward;

	@FindBy(xpath = "//input[@id='input-newsletter']")
	WebElement radioSubscribe;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkpolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confrmesge;

	// methods/actons
	public void setFirstName(String fname) {
		txtfrstName.sendKeys(fname);
	}

	public void setLastName(String LName) {
		txtLastName.sendKeys(LName);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephonmber(String telphnenumber) {
		txtTelephone.sendKeys(telphnenumber);
	}

	public void setCnfrmPassward(String pwrd) {
		cnfrmpasward.sendKeys(pwrd);
	}

//here pad and cnfrm pawd are same so passed as an argument as same
	public void setPassward(String pwrd) {
		txtpassward.sendKeys(pwrd);
	}

	public void setSubscribe() {
		radioSubscribe.click();
	}

	public void clckPolicy() {
		chkpolicy.click();
	}

	public void clckContinue() {
		btncontinue.click();
	}

	public String getconfrmMsg() {
		try {
			return (confrmesge.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

}
