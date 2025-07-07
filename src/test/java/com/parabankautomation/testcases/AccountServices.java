package com.parabankautomation.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.parabankautomation.pages.AccountServicesPage;
import com.parabankautomation.pages.LoginPage;
import com.parabankautomation.utilities.DataProviderClass;
import com.parabankautomation.utilities.TestNGListnerClass;


public class AccountServices extends BaseSetup {
	LoginPage loginpageobj;
	AccountServicesPage accountservicespageobj;

	@Test(enabled = true, priority = 3, dataProviderClass = DataProviderClass.class,dataProvider = "TestData_TC003", groups = {"smoke","regression"})
	public void TC003_VerifyDefaultAmount(String ActualAmount) throws InterruptedException {
		loginpageobj=new LoginPage(driver.get());
		accountservicespageobj=new AccountServicesPage(driver.get());
		
		loginpageobj.LoginWithValidCredentials("SateeshJanapana", "Sandy@2325");
		
		accountservicespageobj.VerifyDefaultAmount(ActualAmount);
		// VerfAmtTestData
	}
	
	@Test(enabled = true, priority = 4, dataProviderClass = DataProviderClass.class, dataProvider = "TestData_TC004" , groups = {"regression"})
	public void TC004_VerifyUpdateContactInfo(String CityToBeUpdated, String ProfileUpdateValidationMsg, String ResetCity) throws InterruptedException {
		loginpageobj=new LoginPage(driver.get());
		accountservicespageobj=new AccountServicesPage(driver.get());
		
		loginpageobj.LoginWithValidCredentials("raju1234", "raju@123");
		
		accountservicespageobj.VerifyUpdateContactInfo(CityToBeUpdated, ProfileUpdateValidationMsg, ResetCity);
	}
	
	

	

	
	
}
