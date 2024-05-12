package com.coreFramework;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheckExample {
	public static void main(String[] args) {

			ChromeOptions options = new ChromeOptions();
			Proxy proxy = new Proxy();
			//proxy.setHttpProxy("ipaddress:4444");
			//options.setCapability("proxy", proxy);
			options.addArguments("--remote-allow-origins=*");
			options.setAcceptInsecureCerts(true);
		//	options.setCapability("proxy", false);
			System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://expired.badssl.com/");
			System.out.println(driver.getTitle());
	}

}
