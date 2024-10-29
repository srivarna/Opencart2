package com.testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import bsh.This;
import freemarker.log.Logger;

public class BaseTestClass {

	public WebDriver driver;
	public org.apache.logging.log4j.Logger logger;
	public Properties p;

	@BeforeClass(groups = {"sanity","Regression","Master"})
	public void setUp(@Optional("Windows") String os, @Optional("chrome") String br) throws IOException {

		// loading config.properties file
		FileReader file = new FileReader("./src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println(" invalid browser name");
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get("https://naveenautomationlabs.com/opencart");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	/*
	 * generating random data by following user defined methods
	 */
	public String geRandomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;

	}

	// random data for telephone number
	public String getRandomNumber() {
		String generatedtelphnnumber = RandomStringUtils.randomNumeric(10);
		return generatedtelphnnumber;

	}

	// this method generated alphbets and numric fro pwd values
	public String getrandomAlphaNumeric() {

		String generatedString = RandomStringUtils.randomAlphabetic(3);
		;
		String generatednumber = RandomStringUtils.randomNumeric(4);

		return (generatedString + "@" + generatednumber);

	}

}
