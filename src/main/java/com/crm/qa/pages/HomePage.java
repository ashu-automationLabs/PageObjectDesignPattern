package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
public WebDriverWait wait;
//Page Factory-OR
	
@FindBy(xpath="//td[contains(text(),'Sharma')]")
WebElement userNameLabel;

@FindBy(xpath="//a[contains(text(),'Contacts')]")
WebElement contactLink;

@FindBy(xpath="//a[contains(text(),'Deals')]")
WebElement dealsLink;

@FindBy(xpath="//a[contains(text(),'Tasks')]")
WebElement taskLink;

@FindBy(xpath="//a[contains(text(),'New Contact')]")
WebElement newContactLink;


public HomePage() 
{
	
PageFactory.initElements(driver, this);


}

//2. Actions/Functionality/methods

public String verifyHomePageTitle() 
{
	

 return driver.getTitle();

}



public String verifyLoggedinUser() 
{	
	
	return userNameLabel.getText();
}



public ContactsPage clickOnContactLink() 
{
	contactLink.click();
    return new ContactsPage();
}


public DealsPage clickOnDealsLink() 
{
	
	dealsLink.click();
	return new DealsPage();


}


public TasksPage clickOnTaskLink() 
{
	taskLink.click();
	return new TasksPage();
}


public void clickOnNewContactLink() 
{
	Actions action = new Actions(driver);
	action.moveToElement(contactLink).build().perform();
	newContactLink.click();

	
	
}

}
