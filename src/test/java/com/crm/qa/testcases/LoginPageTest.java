package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	
	
	
	public LoginPageTest() 
	{
		
	super();	
		
	}
	
	
@BeforeMethod
public void setup() 
{
	initialization();
	loginPage= new LoginPage();

}

/*TC001- To verify that user is able to launch the application*/
@Test(priority=1)
public void validateLoginPageTitleTest() 
{
	String title=loginPage.validateLoginPageTitle();
    Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");

}

/*TC002- To verify that user is able to see the application logo*/
@Test(priority=2)
	public void crmlogoImageTest() 
	{
	
	boolean flag=loginPage.validateCrmLogoImage();
	Assert.assertTrue(flag);


}

/*TC003- To verify that user is able to login into the application successfully using valid credentials*/
@Test(priority=3)
public void loginTest() 
{ 
	loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	
     
}



@AfterMethod
public void teardown() 
{
	
 driver.quit();
}


	
}
