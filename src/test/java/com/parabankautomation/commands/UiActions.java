package com.parabankautomation.commands;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiActions {
	WebDriver driver;
	
	public UiActions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public String getTitle() {
		String ActualTitle= driver.getTitle();
		return ActualTitle;
	}
	
	public void Type(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public void Click(WebElement element) {
		element.click();
	}
	
	public String GetText(WebElement element) {
		String extractedValue= element.getText();
		return extractedValue;
	}
	
	public void ClearInput(WebElement element) {
		element.clear();
	}
	
	public void ExplicitWaitVisibilityElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void ExplicitWaitElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void FluentWait() {
		//Declare and initialise a fluent wait
		
//		//Specify the timout of the wait
//		wait.withTimeout(5000, TimeUnit.MILLISECONDS);
//		//Sepcify polling time
//		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
//		//Specify what exceptions to ignore
//		wait.ignoring(NoSuchElementException.class)
//
//		//This is how we specify the condition to wait on.
//		//This is what we will explore more in this chapter
//		wait.until(ExpectedConditions.alertIsPresent());
	}

}
