package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.loginpage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDTest_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDTest(String user,String pwd) throws InterruptedException
	{
		loginpage lp=new loginpage(driver);
		
		lp.setUserName(user);
		Logger.info("user name entered");
		lp.setPassword(pwd);
		Logger.info("password entered");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert for invalid login data
			driver.switchTo().defaultContent();
			Logger.warn("Login FAIL");
		}
		else
		{
			Assert.assertTrue(true);
			Logger.info("Login PASS");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	
	public boolean isAlertPresent()//user defined method created to check alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData()throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData.xlsx";
		
		int rowcnt=XLUtils.getRowCount(path,"Sheet1");
		int colcnt=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rowcnt][colcnt];
		
		for(int i=1;i<=rowcnt;i++)
		{
			for(int j=0;j<colcnt;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
	}
}
