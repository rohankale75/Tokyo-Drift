package SoftwareTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTesting {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\New Chrome Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		
		String at = driver.getTitle();		// at = actual title
		
		String et = "Google";				// et = expected title
		
		if(at.equalsIgnoreCase(et)) {
			
			System.out.println("Test is successful");
			
		}
		else System.out.println("Test is unsuccessful");
	}
}
