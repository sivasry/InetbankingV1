package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.loginpage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException, InterruptedException
	{

		Logger.info("URL is opened");
		
		loginpage lp= new loginpage(driver);
		lp.setUserName(userName);
		Logger.info("username entered");
		
		lp.setPassword(password);
		Logger.info("pwd entered");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Logger.info("TEST PASS");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			Logger.info("TEST FAIL");
		}
	}
}
