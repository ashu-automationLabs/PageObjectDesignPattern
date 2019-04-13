package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {


//1. Define your Page Factory -Object Repository	
//Page Factory -OR
	
@FindBy(name="username")
WebElement username;

@FindBy(name="password")
WebElement password;	
	
@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
WebElement loginBtn;

@FindBy(xpath="//a[contains(@href,'register')]/font")
WebElement SignUpBtn;

@FindBy(xpath="//img[contains(@class,'img-responsive') and contains(@src,'img/logo')]")
WebElement crmLogo;




public LoginPage() {

	PageFactory.initElements(driver, this);

//Interview Question: How will you intialize your Page Factory?	
//Answer: We have this one method PageFactory.initElements(driver,this(means current class object))	
	
}

//2.Actions/Functionality/Methods/Features


public String validateLoginPageTitle() 
{
	return driver.getTitle();

}


public boolean validateCrmLogoImage() 
{
	return crmLogo.isDisplayed();
}



public HomePage login(String Uname,String Pass) 
{
	username.sendKeys(Uname);
	password.sendKeys(Pass);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	loginBtn.click();
	
	return new HomePage();

}


public void verifyLoginPageLinks() 
{
	//This is the assignment

}

}
