package com.coreFramework;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LinkCont {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> linkCount = driver.findElements(By.tagName("a"));
		
		System.out.println(linkCount.size());
		
		By footerSection = By.xpath("//div[@id='gf-BIG']");
		//limit the web driver scope only for footer section
		
		WebElement footer =driver.findElement(footerSection);
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		WebElement colDriver = footer.findElement(By.xpath("//div[@id='gf-BIG']//table//td[1]/ul"));
		System.out.println(colDriver.findElements(By.tagName("a")).size());
		
		//click on each link in the coloum. 
		
		for(int i =1; i<colDriver.findElements(By.tagName("a")).size();i++){
			
			String clickOnLink= Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			colDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}
			Set<String> tabs = driver.getWindowHandles();
			Iterator<String> it =tabs.iterator();
			while(it.hasNext()) {
			driver.switchTo().window(it.next());	
			System.out.println(driver.getTitle());
			}
			
		
		
	
		
	}

}
