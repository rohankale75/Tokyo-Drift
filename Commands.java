package Software;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Commands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Drivers\\New Chrome Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement UN = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));				//Username
		WebElement Pass = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));		//Password
		Thread.sleep(2000);
		
		if(UN.isSelected() == false) {
			
			UN.click();
			
		}
		Thread.sleep(2000);
		
		if(UN.isDisplayed() && UN.isEnabled()) {
			
			UN.sendKeys("abc@gmail.com");
		}
		
		Thread.sleep(2000);
		if(Pass.isDisplayed() && Pass.isEnabled()) {
			
			Pass.sendKeys("Pass@123");
		}
		
		driver.close();
//		driver.quit();
		
	}

}
