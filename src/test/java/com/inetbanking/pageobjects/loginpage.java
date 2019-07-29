package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver localdriver;
	
	public loginpage(WebDriver remotedriver)
	{
		localdriver=remotedriver;
		PageFactory.initElements(remotedriver,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup	
	WebElement txtUserName;

	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
	@CacheLookup
	WebElement lnklogout;
	
	public void setUserName(String Uname)
	{
		txtUserName.sendKeys(Uname);
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnklogout.click();
	}
}
