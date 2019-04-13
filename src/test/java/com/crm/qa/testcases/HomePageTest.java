package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	
	public LoginPage loginPage;
	public HomePage homePage;
	public TestUtil testUtil;
public HomePageTest() 
{
	super();

}	

@BeforeMethod
public void setup()
{
   initialization();
   loginPage= new LoginPage();
   loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
   homePage = new HomePage();
   testUtil= new TestUtil();
}

/*TC- To verify the homePageTitle*/
@Test(priority=1)
public void verifyHomePageTitleTest() 
{
	String h_title=homePage.verifyHomePageTitle();
	Assert.assertEquals(h_title, "CRMPRO");

}
/*
TC-To verify the loggedIn user is correct*/
@Test(priority=2)
public void verifyLoggedinUserTest() 
{   
	testUtil.switchToframe("mainpanel");
	String userlabel=homePage.verifyLoggedinUser();
    Assert.assertEquals(userlabel, "  User: Shrutee Sharma");
}

@Test(priority=3)
public void clickOnContactLinkTest() 
{   testUtil.switchToframe("mainpanel");
	homePage.clickOnContactLink();

}

@Test(priority =4)
public void clickOnDealsLinkTest() 
{   testUtil.switchToframe("mainpanel");
	homePage.clickOnDealsLink();
}


@AfterMethod
public void teardown() 
{
driver.close();	
}




	
}
