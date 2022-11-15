package com.datadriven;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataDriven {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    public void readExcel(String filePath, String fileName, String sheetName) throws IOException {
        File file=new File(filePath+"\\"+fileName);
        FileInputStream fis=new FileInputStream(file);
        Workbook loginWorkbook = null;

        String fileExtension=fileName.substring(fileName.indexOf("."));

        if (fileExtension.equals(".xlxs"))
        {
            loginWorkbook=new XSSFWorkbook(fis);
        }
        else if (fileExtension.equals("xls"))
        {
            loginWorkbook=new HSSFWorkbook(fis);
        }
        Sheet loginSheet=loginWorkbook.getSheet(sheetName);

        int rowCount=loginSheet.getLastRowNum()-loginSheet.getFirstRowNum();
        for (int i=1;i<rowCount+1;i++)
        {
            Row row=loginSheet.getRow(i);
            String username=row.getCell(0).getStringCellValue();
            String password=row.getCell(1).getStringCellValue();
            test(username,password);
        }
    }
    public void test(String username, String password)
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String baseURL="http:www.gmail.com";
        driver.get(baseURL);
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).sendKeys(password);
        driver.findElement(By.id("signIn")).click();
        driver.quit();

    }
    public static void main(String[] args) throws IOException {
        DataDriven readFile=new DataDriven();

        String filePath="C:\\Users\\HP\\Desktop\\";

        readFile.readExcel(filePath, "DataExcel.xlsx","Sheet1");
    }
}
