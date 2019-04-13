package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;


public class TestBase {
	public static  WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistner;
	
	public TestBase() 
	{
		prop= new Properties();
		try {
			FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\CRMAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		     prop.load(fis);
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
	}
	

	public static void initialization() 
	{
		String browserName = prop.getProperty("Browser");
		if(browserName.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\Jars\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(prop.getProperty("Browser").equals("Firefox")) 
		{  System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\geckodriver.exe");
		   driver= new FirefoxDriver();
		}else if(prop.getProperty("Browser").equals("Edge")) 
		{
			System.setProperty("webdriver.edge.driver","E:\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventlistner=new WebEventListener();
		e_driver.register(eventlistner);
		
		driver= e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}
	
	
	
}
