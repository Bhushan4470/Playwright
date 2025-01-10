package com.base;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.microsoft.playwright.Page;
import com.pages.HomepagemenuPage;
import com.pages.OpenNewAccountPage;
import com.pages.RegistrationPage;

import com.pages.TransferFundsPage;

import com.pages.BillPayPage;

import com.pages.AccountsOverviewPage;

public class BaseTest {
	
	PlaywrightBase pb;
	protected Page page;
   protected RegistrationPage registrationPage;
   protected HomepagemenuPage homepagemenu; 
   protected OpenNewAccountPage openNewAccountPage;
   protected AccountsOverviewPage accountsOverviewPage;
   protected TransferFundsPage transferFundsPage;
   protected BillPayPage billPayPage;
    

    @BeforeSuite
    public void setUp() {
    	pb= new PlaywrightBase();
    	page=  pb.setup();
        registrationPage = new RegistrationPage(page);
        openNewAccountPage = new OpenNewAccountPage(page);
        homepagemenu = new HomepagemenuPage(page);
         accountsOverviewPage = new AccountsOverviewPage(page);
         transferFundsPage = new TransferFundsPage(page);
         billPayPage = new BillPayPage(page);

        registrationPage.navigateToPage("https://parabank.parasoft.com/parabank/register.htm");
        
    }
    
    @AfterSuite
    public void teardown() {
       page.context().browser().close();
    }

}
