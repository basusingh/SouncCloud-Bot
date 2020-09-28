package com.basusingh.scbot;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class StreamMain {
	
	WebDriver driver;
    String baseURL, nodeURL;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    
    
    @BeforeTest
    public void setUp() throws MalformedURLException {
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    	System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
    	nodeURL = "http://192.168.0.108:4499/wd/hub";
        System.out.println("Chrome Browser Initiated");
        
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();            
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        
        ChromeOptions cap = new ChromeOptions(); 
        cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                          UnexpectedAlertBehaviour.IGNORE);
        cap.setExperimentalOption("excludeSwitches", "enable-automation");
        
        driver = new RemoteWebDriver(new URL(nodeURL), cap);
        //driver.get("https://www.soundcloud.com/");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    
    @Test
    public void sampleTest() {
    	 // Test name: 1
        // Step # | name | target | value
        // 1 | open | https://soundcloud.com/iamcardib/wap-feat-megan-thee-stallion | 
        driver.get("https://soundcloud.com/iamcardib/wap-feat-megan-thee-stallion");
        // 2 | setWindowSize | 1456x876 | 
        driver.manage().window().setSize(new Dimension(1456, 876));
        // 3 | mouseOver | css=.loginButton:nth-child(1) | 
        {
          WebElement element = driver.findElement(By.cssSelector(".loginButton:nth-child(1)"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        // 4 | click | css=.loginButton:nth-child(1) | 
        driver.findElement(By.cssSelector(".loginButton:nth-child(1)")).click();
        // 5 | mouseOver | css=.loginButton:nth-child(1) | 
        {
          WebElement element = driver.findElement(By.cssSelector(".loginButton:nth-child(1)"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        // 6 | mouseOut | css=.loginButton:nth-child(1) | 
        {
          WebElement element = driver.findElement(By.tagName("body"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element, 0, 0).perform();
        }
        // 7 | selectFrame | index=0 | 
        driver.switchTo().frame(0);
        // 8 | type | id=sign_in_up_email | nk.vashisat@gmail.com
        driver.findElement(By.id("sign_in_up_email")).sendKeys("nk.vashisat@gmail.com");
        // 9 | sendKeys | id=sign_in_up_email | ${KEY_ENTER}
        driver.findElement(By.id("sign_in_up_email")).sendKeys(Keys.ENTER);
        // 10 | type | id=enter_password_field | 9871890142
        driver.findElement(By.id("enter_password_field")).sendKeys("9871890142");
        // 11 | sendKeys | id=enter_password_field | ${KEY_ENTER}
        driver.findElement(By.id("enter_password_field")).sendKeys(Keys.ENTER);
        // 12 | selectFrame | relative=parent | 
        driver.switchTo().defaultContent();
        // 13 | click | linkText=Settings and more | 
        driver.findElement(By.linkText("Settings and more")).click();
        // 14 | click | linkText=Sign out | 
        driver.findElement(By.linkText("Sign out")).click();
        // 15 | close |  | 
        driver.close();

    }

}
