package com.coreFramework;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowExpamle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		By emailLink = By.xpath("//a[@class='blinkingText']");
		By paraText = By.xpath("//p[@class='im-para red']");
		By userNameInput = By.xpath("//input[@id='username']");
		
		driver.findElement(emailLink).click();
		Set<String> windows =driver.getWindowHandles();
	Iterator<String> it =	windows.iterator();
	String parentId = it.next();
	String childId = it.next();
		driver.switchTo().window(childId);
		driver.findElement(paraText).getText();
        String email = driver.findElement(paraText).getText().split("at")[1].trim().split(" ")[0].trim();
       String userName = email.substring(email.indexOf('@')+1,email.indexOf('.'));
        driver.switchTo().window(parentId);
        driver.findElement(userNameInput).sendKeys(userName);
		
	}
}
