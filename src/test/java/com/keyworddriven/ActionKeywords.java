package com.keyworddriven;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ActionKeywords {
    public static WebDriver driver;

    public static void openBrowser() {
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void navigate()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com");
    }
    public static void inputUsername()
    {
        driver.findElement(By.id("Email")).sendKeys("sirinshaikh942@gmail.com");
    }
    public static void clickNext()
    {
        driver.findElement(By.id("next")).click();
    }
    public static void inputPassword()
    {
        driver.findElement(By.id("passwd")).sendKeys("sirin123");
    }
    public static void clickSignin()
    {
        driver.findElement(By.id("SignIn")).click();
    }
    public static void closeBrowser()
    {
        driver.quit();
    }

}