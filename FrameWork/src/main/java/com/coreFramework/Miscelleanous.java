package com.coreFramework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Miscelleanous {

	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();		
		options.addArguments("--remote-allow-origins=*");
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://google.com");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new  File("E://screenshot.png"));
	}

}
