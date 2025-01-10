package com.test;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.RegistrationPage;


public class OpenAccountTest extends BaseTest{
	
	 @Test
	    public void testopenAccount() throws InterruptedException {
		 homepagemenu=registrationPage.login(RegistrationPage.username1 ,registrationPage.password());
		 Thread.sleep(3000);
		 openNewAccountPage.clickOpenAccountButtonlink();

        // Perform actions
        openNewAccountPage.selectAccountType("SAVINGS");
        Thread.sleep(3000);
        openNewAccountPage.clickOpenAccountButton();

        // Capture and print the new account number
        String newAccountNumber = openNewAccountPage.getNewAccountNumber();
        System.out.println("New Account Number: " + newAccountNumber);

    }
}
