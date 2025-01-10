package com.test;



import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.RegistrationPage;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;

public class HomepagemenuTest extends BaseTest {
	
    @Test
    public void validateAccountServicesMenu() throws InterruptedException {
    	homepagemenu=registrationPage.login(RegistrationPage.username1 ,registrationPage.password());
        // Expected menu items
        List<String> expectedMenuItems = Arrays.asList(
                "Open New Account",
                "Accounts Overview",
                "Transfer Funds",
                "Bill Pay",
                "Find Transactions",
                "Update Contact Info",
                "Request Loan",
                "Log Out"
        );

        // Validate all menu items are present
        Thread.sleep(5000);
        List<String> actualMenuItems = homepagemenu.getAccountServicesMenuItems();
        Assert.assertEquals(expectedMenuItems, actualMenuItems, "Account Services menu items mismatch!");

        // Validate clicking each menu item
        for (String menuItem : expectedMenuItems) {
        	homepagemenu.clickMenuItem(menuItem);
        	Thread.sleep(3000);

			/*
			 * // Optionally validate navigation or page header String pageHeader =
			 * homepagemenu.getPageHeader(); Assert.assertTrue(pageHeader.contains(menuItem)
			 * || pageHeader.isEmpty(), "Navigation to " + menuItem + " is incorrect!");
			 */
            
            Thread.sleep(6000);
            
            // Navigate back for subsequent checks
            page.goBack();
        }

    }
}
