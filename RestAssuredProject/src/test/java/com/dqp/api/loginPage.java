package com.dqp.api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class loginPage {
	
	public static WebDriver driver ;
	
	@Test
	public static void main() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("http://192.168.9.11:25200/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.quit();
	}
	

}
