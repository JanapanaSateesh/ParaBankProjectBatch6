package com.parabankautomation.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.parabankautomation.utilities.ReadConfigData;

public class BaseSetup {

//public WebDriver driver;
public ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	@BeforeMethod(alwaysRun = true)
	public void Setup(ITestContext context) throws InterruptedException, IOException {
		ReadConfigData configdata=new ReadConfigData();
		String url=configdata.getUrl();
		String browser=configdata.getBrowserName();
		switch(browser.toUpperCase()) 
		{
		case "CHROME": driver.set(new ChromeDriver());
		
		  break;
		  
		case "EDGE": driver.set(new EdgeDriver());
		  break;
		  
		  default : throw new IllegalArgumentException("Please provide valid browser name");
		  
		}	
		context.setAttribute("driver", driver.get());
		
		
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get().get(url);
		Thread.sleep(5000);
	}
	
	@AfterMethod(alwaysRun = true)
	public void TearDown() {
		//driver.get().quit();
	}
}
