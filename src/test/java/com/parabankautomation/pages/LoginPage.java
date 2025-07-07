package com.parabankautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parabankautomation.commands.UiActions;
import com.parabankautomation.helpers.UiHelpers;
import com.parabankautomation.utilities.TestNGListnerClass;

public class LoginPage {

	WebDriver driver;
	UiActions uiactionsobj;

	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;		
		PageFactory.initElements(driver, this);
		
		uiactionsobj=new UiActions(driver);
	}
	
	
	@FindBy (css = "input[name='username']")
	private WebElement usernameLocator;
	
	@FindBy (css = "input[name='password']")
	private WebElement passwordLocator;
	
	@FindBy (css = "input[value='Log In']")
	private WebElement loginbuttonLocator;
	
	@FindBy(xpath = "//p[@class='error']")
	private WebElement invalidcredentialserror;
	
	public void LoginWithValidCredentials(String username, String Password) {
		ExtentTest test= TestNGListnerClass.extentThreadLocal.get();
		
		try {
			uiactionsobj.Type(usernameLocator, username);
			test.log(Status.PASS, "Entered username:"+username);
			uiactionsobj.Type(passwordLocator, Password);
			test.log(Status.PASS, "Entered Password:"+Password);
			uiactionsobj.Click(loginbuttonLocator);
			test.log(Status.PASS, "Clicked on Login Button");
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		
	}
	
	public void LoginWithValidCredentialsAndVerifyTitle(String username, String Password,String ExpectedTitle) {
		ExtentTest test= TestNGListnerClass.extentThreadLocal.get();
		
		try {
			uiactionsobj.Type(usernameLocator, username);
			test.log(Status.PASS, "Entered Username:"+username);
			uiactionsobj.Type(passwordLocator, Password);
			test.log(Status.PASS, "Entered Password:"+Password);
			uiactionsobj.Click(loginbuttonLocator);
			test.log(Status.PASS, "Clicked on Login Button");
			String ActualTitle= uiactionsobj.getTitle();
			
			UiHelpers.CompareStrings(ActualTitle, ExpectedTitle);
			test.log(Status.PASS, "Actual Title"+ActualTitle+" and Expected Title"+ExpectedTitle+" are matched");
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
	public void LoginWithValidUsernameInvalidPassword(String username, String Password,String ExpectedErrorMessage) {
		ExtentTest test= TestNGListnerClass.extentThreadLocal.get();
		
		try {
			uiactionsobj.Type(usernameLocator, username);
			test.log(Status.PASS, "Entered Username:"+username);
			uiactionsobj.Type(passwordLocator, Password);
			test.log(Status.PASS, "Entered Password:"+Password);
			uiactionsobj.Click(loginbuttonLocator);
			test.log(Status.PASS, "Clicked on Login Button");
			String ActualErromessage= uiactionsobj.GetText(invalidcredentialserror);
			UiHelpers.CompareStrings(ActualErromessage, ExpectedErrorMessage);
			test.log(Status.PASS, "Actual Error Message"+ActualErromessage+" and Expected Error Message"+ExpectedErrorMessage+" are matched");
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
	
	
	
}
