package com.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.base.BaseTest;

public class BillPayTest extends BaseTest  {
    

    @Test
    public void testBillPay() {
        

        // Navigate to Bill Pay page
        billPayPage.navigateToBillPay();

        // Fill out the form and send payment
        billPayPage.fillBillPayForm(
                "Nagabhushan R",
                "63 Bangalore",
                "Vijayanagar",
                "India",
                "560072",
                "998665447",
                "14343",
                "14343",
                "100.00",
                "14343"
        );
        billPayPage.clickSendPayment();

        // Validate the success message
        assertTrue(billPayPage.isPaymentSuccessful(), "Payment should be successful.");
    }

   
    }

