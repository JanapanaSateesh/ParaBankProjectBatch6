package com.parabankautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parabankautomation.commands.UiActions;
import com.parabankautomation.helpers.UiHelpers;
import com.parabankautomation.utilities.TestNGListnerClass;

public class AccountServicesPage {

	WebDriver driver;
	UiActions uiactionsobj;
	
	public AccountServicesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		uiactionsobj=new UiActions(driver);
	}
	
	//---------Account Overiview-------
	@FindBy(xpath = "((//tbody//tr)[last()]//td)[2]//b")
	private WebElement DefaultAmount;
	
	
	//------------Update Contact Info-------------
	@FindBy(xpath = "//a[text()='Update Contact Info']")
	private WebElement object_updatecontactinfolink;
	
	@FindBy(id = "customer.address.city")
	private WebElement object_cityfield;
	
	@FindBy(xpath = "//input[@value='Update Profile']")
	private WebElement object_updateprofile;
	
	@FindBy(xpath = "//div[@id='updateProfileResult']//h1")
	private WebElement object_profileupdateText;
	
	
	
	public void VerifyDefaultAmount(String ExpectedAmount) throws InterruptedException {
		Thread.sleep(4000);
		ExtentTest test= TestNGListnerClass.extentThreadLocal.get();
		
		String ActualDefaultAmount= uiactionsobj.GetText(DefaultAmount);
		test.log(Status.PASS,"ActualDefaultAmount is:"+ActualDefaultAmount);
		
		UiHelpers.CompareStrings(ActualDefaultAmount, ExpectedAmount);
		test.log(Status.PASS,"Compared Actual Amount with Expected Amount is Success");
	}
	
	public void VerifyUpdateContactInfo(String CityToBeUpdated,String ExpectedUpdateMessage,String DefaultCity) throws InterruptedException {
		Thread.sleep(4000);
		uiactionsobj.Click(object_updatecontactinfolink);
		Thread.sleep(2000);
		uiactionsobj.ClearInput(object_cityfield);
		Thread.sleep(2000);
		uiactionsobj.Type(object_cityfield, CityToBeUpdated);
		uiactionsobj.Click(object_updateprofile);
		Thread.sleep(3000);
		
		uiactionsobj.ExplicitWaitVisibilityElement(object_profileupdateText);
		
		String ActualUpdatedMessage= uiactionsobj.GetText(object_profileupdateText);
		UiHelpers.CompareStrings(ActualUpdatedMessage, ExpectedUpdateMessage);
		uiactionsobj.Click(object_updatecontactinfolink);
		Thread.sleep(3000);
//		
//		String UpdatedCity= uiactionsobj.GetText(object_cityfield);
//		UiHelpers.CompareStrings(UpdatedCity, CityToBeUpdated);
		Thread.sleep(2000);
		ResetUpdate(DefaultCity);
		Thread.sleep(2000);
	}
	
	public void ResetUpdate(String DefaultCity) throws InterruptedException {
		uiactionsobj.ClearInput(object_cityfield);
		Thread.sleep(2000);
		uiactionsobj.Type(object_cityfield, DefaultCity);
		uiactionsobj.Click(object_updateprofile);
		Thread.sleep(2000);
	}
}
