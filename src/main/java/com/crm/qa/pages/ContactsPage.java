package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
//1. Page Factory	
	
	@FindBy(xpath="//*[@id=\"vContactsForm\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	@FindBy(xpath="//input[@name='cs_name']")
	WebElement fname;
	
	@FindBy(xpath="//input[@name='cs_company_name']")
	WebElement cmpName;
	
	@FindBy(xpath="//input[@name='cs_submit']")
	WebElement submit;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement first_name;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement last_name;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company_name;
	
	@FindBy(xpath="//form[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	public ContactsPage() 
	{
		
		PageFactory.initElements(driver, this);
		
		
	}


//2. Actions/Functionality

	public boolean verifyContactLabel() 
	{
		return contactsLabel.isDisplayed();
		
		
	}
	
	
	public void selectContactbyName(String name) 
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']/input[@name='contact_id']")).click();
		
	}
	
	public void searchContact(String Name,String Company) 
	{
	   fname.sendKeys(Name);
	   cmpName.sendKeys(Company);
	   submit.click();
		
		
	}
	
	public void createNewContact(String title,String Fname,String LName,String CmpName) 
	{
		Select select =new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		
		first_name.sendKeys(Fname);
		last_name.sendKeys(LName);
		company_name.sendKeys(CmpName);
		saveBtn.click();
		
	}
	
	
}
