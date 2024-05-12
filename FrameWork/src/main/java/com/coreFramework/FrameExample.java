package com.coreFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FrameExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		By frameId = By.xpath("//iframe[@class='demo-frame']");
		By frameText = By.xpath("//div[@id='draggable']//p");
		By frameId1 = By.xpath("//div[@id='draggable']");
		By frameId2 = By.xpath("//div[@id='droppable']");
		
		
		WebElement frame = driver.findElement(frameId);
	//	System.out.println(driver.findElement(frameText).getText());
		driver.switchTo().frame(frame);
		System.out.println(driver.findElement(frameText).getText());
		
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(frameId1), driver.findElement(frameId2)).build().perform();
		
	}

}
