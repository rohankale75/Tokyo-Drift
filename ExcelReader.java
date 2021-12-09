package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelReader {
	
	public static  String readData(int row,int col) throws IOException {
		
		String path=System.getProperty("user.dir")+"\\TestData2.xlsx";		
		
		File file=new File(path);
		
		FileInputStream fis=new FileInputStream(file);
		
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		String value=sheet.getRow(row).getCell(col).getStringCellValue();
		System.out.println(value);
		return value;
	
	}
	

	public static void main(String[] args) throws IOException {
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Desktop\\Slenium Jar\\Chrome_96\\chromedriver.exe");
		
		//Step-1
		//Browser open- by creating 
		WebDriver driver =new ChromeDriver();
		
		//Step-2
		//maximize the window
		driver.manage().window().maximize();
		
		//Step-3
		//https://opensource-demo.orangehrmlive.com/
		driver.get("https://www.facebook.com/");
		
		//step-4
		WebElement emailBox=driver.findElement(By.id("email"));
		emailBox.sendKeys(readData(0,0));
		
		//Step-5
		WebElement password=driver.findElement(By.name("pass"));
		password.sendKeys(readData(0,1));
		

	}

}
