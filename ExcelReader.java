package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelReader {
	
	public static  String readData(int row,int col,int sheets) throws IOException {
		
		String path=System.getProperty("user.dir")+"\\TestData2.xlsx";		
		
		File file=new File(path);
		
		FileInputStream fis=new FileInputStream(file);
		
		//Apache poi
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheetAt(sheets);
		
		int sheetValue=(int)sheet.getRow(row).getCell(col).getNumericCellValue();
		
		String value=String.valueOf(sheetValue);
		
		System.out.println(value);
		return value;
	
	}
	
public static void writeData(int row,int col, String value) throws IOException, InvalidFormatException {
		
		String path=System.getProperty("user.dir")+"\\TestData3.xlsx";	
		
		File file =new File(path);
		
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook (fis);
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		sheet.createRow(row).createCell(col).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(file);
		
		wb.write(fos);
		
		wb.close();

	}
	
	

	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\Users\\LENOVO\\Desktop\\Slenium Jar\\Chrome_96\\chromedriver.exe");
		  
		  //Step-1 //Browser open- by creating 
		  WebDriver driver =new ChromeDriver();
		  
		  //Step-2 //maximize the window 
		  driver.manage().window().maximize();
		  
		  //Step-3 //https://opensource-demo.orangehrmlive.com/
		  driver.get("https://www.facebook.com/");
		  
		  //step-4 
		  WebElement emailBox=driver.findElement(By.id("email"));
		  emailBox.sendKeys(readData(5,0,0));
		  
		  //Step-5 
		  WebElement password=driver.findElement(By.name("pass"));
		  password.sendKeys(readData(5,1,0));
		  
		  String title=driver.getTitle(); System.out.println(title);
		
		writeData(0,0,title);
		
		driver.close();
		

	}

}
