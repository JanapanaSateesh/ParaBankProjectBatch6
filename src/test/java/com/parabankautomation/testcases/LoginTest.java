package com.parabankautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.parabankautomation.pages.LoginPage;
import com.parabankautomation.utilities.TestNGListnerClass;


public class LoginTest extends BaseSetup{
	

	@Test(enabled = true, priority = 1, groups = {"smoke", "regression"})
	public void TC001_LoginWithValidCredentials() throws InterruptedException {
		LoginPage loginpageobj=new LoginPage(driver.get());
		loginpageobj.LoginWithValidCredentialsAndVerifyTitle("SateeshJanapana","Sandy@2325","ParaBank | Accounts Overview");
		
	}
	
	@Test(enabled = true, priority = 1, groups = {"regression"})
	public void TC002_LoginWithValidusernameInvalidPassword() throws InterruptedException {
		LoginPage loginpageobj=new LoginPage(driver.get());
		loginpageobj.LoginWithValidUsernameInvalidPassword("SateeshJanapana","Test@123","The username and password could not be verified.");
		
	}
	
	
	

	
	
}
