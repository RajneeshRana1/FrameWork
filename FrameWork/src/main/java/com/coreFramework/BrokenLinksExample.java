package com.coreFramework;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksExample {
	
public static void main(String arg[]) throws MalformedURLException, IOException {
	ChromeOptions options = new ChromeOptions();		
	options.addArguments("--remote-allow-origins=*");
	options.setAcceptInsecureCerts(true);
	System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver(options);
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	
	List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));
	SoftAssert a = new SoftAssert();
	for(WebElement link:links) {
	String url=	link.getAttribute("href");
		HttpURLConnection conection =(HttpURLConnection) new URL(url).openConnection();
		conection.setRequestMethod("HEAD");
		conection.connect();
		int responseCode =conection.getResponseCode();
		a.assertTrue(responseCode<400,"This link with TEXT "+ link.getText()+" is broken with code"+ responseCode);
	     
	
	}
	a.assertAll();
	
	
	                 
	
	
	
	
	//broke URL
	//Step 1: - All URL's 
	//String url =driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//	//One connection method of URL class. 
//	HttpURLConnection conection =(HttpURLConnection) new URL(url).openConnection();
//	conection.setRequestMethod("HEAD");
//	conection.connect();
//	int responseCode =conection.getResponseCode();
//	System.out.println(responseCode);
	//Java methods will call URL's and gets you the status code. 
	//if status code > 400 then that usl is not working
	

}
}
