package com.coreFramework;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExample {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		
		//implicit Wait: - Defining wait time globally. eg. wait for n sec before throwing any exception. 
		//if the element visible in 2 sec. selenium continue to perform action.
		//disadvantage: - If somewhere in aplication any action takes more than 5 sec. 
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
		
		//Explicit Wait
		//Come with two type 1. driverWait and Fluent wait
		//target specific element and ask driver to wait till the element action. 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		
		//Thread.Sleep
		//Halt the execution till define. ex. Thread.sleep(20);
		//It will halt the execution till 20 even the result loaded in 4 sec. 
		//Not a good practice to have a Thread.sleep in our code. 
		
		//Fluent Wait
		
	}

}
