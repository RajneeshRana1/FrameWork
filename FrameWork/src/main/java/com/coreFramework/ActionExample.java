package com.coreFramework;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ActionExample {
	
	
	 private static File downloadImage(String imageUrl) throws IOException {
	        // Write code to download the image and save it to a file
	        // Example:
	         URL url = new URL(imageUrl);
	         BufferedImage image = ImageIO.read(url);
	         int newWidth = 300; // Adjust as needed
	            int newHeight = (int) Math.round(image.getHeight() * (newWidth / (double) image.getWidth()));
	            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
	            resizedImage.getGraphics().drawImage(image.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH), 0, 0, null);
	         File outputFile = new File("image.png");
	         ImageIO.write(image, "png", outputFile);
	         return outputFile;
	       
	    }
	 
	 
	 private static String performOCR(File imageFile) throws TesseractException {
	        // Write code to perform OCR using Tesseract OCR
	        // Example:
	         Tesseract tesseract = new Tesseract();
	         tesseract.setDatapath("src/main/resources/tessdata");
	         String result = tesseract.doOCR(imageFile);
	         return result;
	         
	         
	        //return null; // Replace this with actual implementation
	    }
	 
	 
	 public void enterCaptcha() {
		 
	 }

	public static void main(String[] args) throws IOException, TesseractException, InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
		System.setProperty("TESSDATA_PREFIX", "/FrameWork/src/main/resources/tessdata");


		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		


		
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		By hoveraction = By.xpath("//span[normalize-space(text())='Account & Lists']/parent::a");
		By imageInput = By.xpath("//div[@class='a-row a-text-center']//img");
		By captchaInputBox = By.xpath("//input[@id='captchacharacters']");
		By continueButtonInput= By.xpath("//button[normalize-space(text())='Continue shopping']");

	int i =0;
        
        while(i<50) {
        	WebElement imageElement = driver.findElement(imageInput);
            String imageUrl = imageElement.getAttribute("src");

            File imageFile = downloadImage(imageUrl);
            String extractedText = performOCR(imageFile);

            // Print the extracted text
            System.out.println("Extracted Text: " + extractedText);
        	   driver.findElement(captchaInputBox).sendKeys(extractedText);
        	   Thread.sleep(1000);
               driver.findElement(continueButtonInput).click();
               Thread.sleep(10000);
               if(driver.getCurrentUrl().equals("https://www.amazon.com")) {
            	   System.out.println("breaked");
            	   break;
               }
               i++;
        	
        }
        
     

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(hoveraction));

		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(hoveraction)).contextClick();
		action.moveToElement(driver.findElement(hoveraction)).build().perform();
	}

}
