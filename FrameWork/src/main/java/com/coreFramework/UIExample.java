package com.coreFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIExample {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String monthNumber ="June";
		String date = "15";
		String year ="2027";
		By calenderButtonInput = By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']");
		By yearHeardInput = By.xpath("//button[@class='react-calendar__navigation__label']");
		By yearInput = By.xpath("//button[text()='"+year+"']");
		By monthInput =  By.xpath("//abbr[text()='"+monthNumber+"']");
		By dateInput = By.xpath("//abbr[text()='"+date+"']");
		By completeDate = By.xpath("//div[@class='react-date-picker__inputGroup']//input[@name='date']");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(30000));
		
		driver.findElement(calenderButtonInput).click();
		


		driver.findElement(yearHeardInput).click();


		driver.findElement(yearHeardInput).click();


		driver.findElement(yearInput).click();


		driver.findElement(monthInput).click();


		driver.findElement(dateInput).click();
		


		System.out.println(driver.findElement(completeDate).getAttribute("value"));
		
	}

}
