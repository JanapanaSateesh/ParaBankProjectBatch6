package com.parabankautomation.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	
	@DataProvider
	public Object[][] TestData_TC004() throws IOException {
		Object[][] data= ReadDataFromExcel.getData("UpdateTestCaseTestData","Sheet1");
		return data;
	}
	
	@DataProvider
	public Object[][] TestData_TC003() throws IOException {
		Object[][] data= ReadDataFromExcel.getData("UpdateTestCaseTestData","VerfAmtTestData");
		return data;
	}
}
