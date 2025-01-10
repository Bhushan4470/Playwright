package com.test;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.RegistrationPage;

public class AccountsOverviewTest extends BaseTest {
		

	    @Test
	    public void testAccountOverview() throws InterruptedException {
	    	homepagemenu=registrationPage.login(RegistrationPage.username1 ,registrationPage.password());
	    	Thread.sleep(5000);
	                // Validate balance details
	                if (accountsOverviewPage.areBalanceDetailsPresent()) {
	                    System.out.println("Balance details are present.");
	                    Thread.sleep(2000);
	                    
	                    // Retrieve specific balance details
	                    String balance = accountsOverviewPage.getBalanceForAccount(0); // First account
	                    System.out.println("First Account Balance: " + balance);
	                    Thread.sleep(3000);
	                    // Validate the total balance
	                    String totalBalance = accountsOverviewPage.getTotalBalance();
	                    System.out.println("Total Balance: " + totalBalance);
	                } else {
	                    System.out.println("Balance details are not present on the page.");
	                }
	            }
	        }
	    

