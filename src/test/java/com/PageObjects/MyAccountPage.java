package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@id='content']/h2[1]")
	WebElement msgHeading;
	@FindBy(xpath = "//a[@class='list-group-item'][13]")
	WebElement lnklogout;
	
	public boolean isMyAccountExist() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
		
		
	}

	public void clcklogout() {
		lnklogout.click();
		
	}

	

	

}
