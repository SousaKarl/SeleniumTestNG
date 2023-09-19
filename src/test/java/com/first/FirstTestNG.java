package com.first;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.percy.selenium.Percy;

public class FirstTestNG {
	
	
	WebDriver driver = null;
	
	@BeforeTest
	
	public void setupTest()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 driver  = new ChromeDriver();
		 
		 Percy percy = new Percy(driver);
		
		//Browsing to the Website
		driver.get("https://www.smartenergygb.org/");
		
		
		//Take a percy snap shot
				percy.snapshot("First");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		
	}
	
	@Test
	
	public void Acceptcookie()
	
	{
		
		//Accepting the cookie pop up
				driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
				
				
				System.out.println("The cookie has been accepted");
	}
	
	@AfterTest
	
	public void down()
	{
		//close browser
		
		driver.close();
		driver.quit();
		System.out.println("Test Passed successfully");
	}
	

}
