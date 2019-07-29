package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddNewCustomerPage;
import com.inetbanking.pageobjects.loginpage;

public class TC_AddNewCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		loginpage lp=new loginpage(driver);
		lp.setUserName(userName);
		Logger.info("username entered to login");
		lp.setPassword(password);
		Logger.info("password entered to login");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddNewCustomerPage addcust=new AddNewCustomerPage(driver);
		
		Logger.info("Providing new customer detail..");
		
		addcust.clickAddNewCustomer();
		
		addcust.custName("YssrY");
		addcust.custgender("male");
		addcust.custdob("11", "30", "1982");
		Thread.sleep(3000);
		addcust.custaddress("IT road");
		addcust.custcity("Bangalore");
		addcust.custstate("KA");
		addcust.custpinno("5000067");
		addcust.custtelephoneno("9999999999");
		
		addcust.custemailid(randomstring()+"@gmail.com");//as application expects unique email 
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		Logger.info("Validation Started...");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			Logger.info("Test PASS");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			Logger.info("Test FAIL");
		}
	}
}
