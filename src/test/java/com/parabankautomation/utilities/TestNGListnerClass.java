package com.parabankautomation.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNGListnerClass implements ITestListener{
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public static ThreadLocal<ExtentTest> extentThreadLocal=new ThreadLocal<ExtentTest>();
	
	public void ConfigureReport()
	{
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY_MM_dd_hh_mm_ss");
		String currentDateTime=now.format(formatter);
		
		htmlreporter = new ExtentSparkReporter("./Reports/summary_report"+currentDateTime+".html");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setDocumentTitle("Final Summary Report");
		
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("Author", "Sateesh");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Project", "QA");
		
	}
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+"is Started");
		test=reports.createTest(result.getName());
		extentThreadLocal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+"is Success");
		test=extentThreadLocal.get();
		test.log(Status.PASS, result.getName()+"is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stubr
		System.out.println(result.getName()+"is Failed");
		test=extentThreadLocal.get();
		test.log(Status.FAIL, result.getName()+"is Failed");
		String testFailedReason=result.getThrowable().getMessage();
		test.fail(testFailedReason);
		
		WebDriver driver=(WebDriver) result.getTestContext().getAttribute("driver");
	   String base64Image=	((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	   test.addScreenCaptureFromBase64String(base64Image);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Tests started");
		ConfigureReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Tests Finished");
		reports.flush();
	}

	
}
