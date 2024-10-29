package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	// locators
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccunt;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkregister;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li[2]")
	WebElement lnkLogin;

	//Actions
	public void clickMyAccount() {
		lnkMyaccunt.click();
	}

	public void clickRegister() {
		lnkregister.click();
	}
	public void clickLogin() {
		lnkLogin.click();
	}
	
}
