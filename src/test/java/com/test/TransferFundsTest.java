package com.test;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.RegistrationPage;

public class TransferFundsTest extends BaseTest {
	
	@Test
    public void testtransferFund() throws InterruptedException {
		
    	homepagemenu=registrationPage.login(RegistrationPage.username1 ,registrationPage.password());
    	Thread.sleep(3000);

    	// Click on Transfer Funds link
		transferFundsPage.clickOnTransferFunds();

        // Validate navigation by checking the page title
        String title = transferFundsPage.getCurrentPageTitle();
        if (title.equals("ParaBank | Transfer Funds")) {
            System.out.println("Successfully navigated to Transfer Funds page.");
        } else {
            System.out.println("Navigation to Transfer Funds page failed.");
        }
            Thread.sleep(2000);
            // Enter an amount less than 100
            transferFundsPage.enterAmount("50");

            // Dynamically select the second account in "To Account" dropdown
            transferFundsPage.selectToAccount(1);
            Thread.sleep(2000);
            // Click Transfer
            transferFundsPage.clickTransfer();

            // Assertions
            String successMessage = transferFundsPage.getSuccessMessage();
            System.out.println("Success Message: " + successMessage);
            assert successMessage.equals("Transfer Complete!");

            String transferredAmount = transferFundsPage.getAmountTransferred();
            System.out.println("Amount Transferred: " + transferredAmount);
            Thread.sleep(2000);
            assert transferredAmount.contains("$50.00");
            Thread.sleep(3000);

            String fromAccount = transferFundsPage.getFromAccount();
            String toAccount = transferFundsPage.getToAccount();
            System.out.println("From Account: " + fromAccount);
            System.out.println("To Account: " + toAccount);
            assert !fromAccount.equals(toAccount);
        }
    }

