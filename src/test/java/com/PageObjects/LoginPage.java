package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//input[@placeholder='E-Mail Address']")
	WebElement TxtEmailAddress;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement TxtPassward;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;

	// Actions
	public void setEmailaddress(String email) {
		TxtEmailAddress.sendKeys(email);
	}

	public void setPassward(String pwd) {
		TxtPassward.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}
}
