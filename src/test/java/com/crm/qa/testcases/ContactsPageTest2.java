package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
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
import com.crm.qa.util.TestUtil2;

public class ContactsPageTest2 extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil2 testUtil;
	ContactsPage contact;
	
	String sheetName="Contacts";
	
	public ContactsPageTest2() 
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
	   testUtil= new TestUtil2();
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

@Test(priority =5)
public void validateCreateNewContact() 
{
	homePage.clickOnNewContactLink();
	contact.createNewContact("Miss", "Rakhi", "Khatri", "Wipro");

}


@DataProvider
public Object[][] getCRMTestData() 
{
   Object[][] data=testUtil.getTestDatafromExcel("Contacts");	
   return data;
}


@Test(priority=4, dataProvider="getCRMTestData")
public void createNewContact(String title,String Fname,String LName,String CmpName) 
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
