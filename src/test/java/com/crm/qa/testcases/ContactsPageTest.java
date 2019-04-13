package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contact;
	
	String sheetName="Contacts";
	
	public ContactsPageTest() 
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
       testUtil.switchToframe("mainpanel");
       homePage.clickOnContactLink();
       contact= new ContactsPage();


}

@Test(priority=1)
public void verifyContactPageLabel() 
{
	Assert.assertTrue(contact.verifyContactLabel(), "contact Page label is wrong or you are not on right page");

}


@Test(priority=2)
public void selectSingleContactTest() 
{
	
contact.selectContactbyName("abc abc");


}


@Test(priority=3)
public void multiplecontactSelect() 
{
	contact.selectContactbyName("a11 a11");
	contact.selectContactbyName("beta test");
	

}


@DataProvider
public Object[][] getTestData() 
{
	Object data[][]=testUtil.getTestDataFromExcel(sheetName);

	return data;


}

@Test(priority=4,dataProvider="getTestData")
public void validateCreateNewContact(String title,String Fname,String LName,String CmpName) 
{
	homePage.clickOnNewContactLink();
	contact.createNewContact(title, Fname, LName, CmpName);

}


@AfterMethod
public void tearDown() 
{
	driver.quit();


}



	
}
