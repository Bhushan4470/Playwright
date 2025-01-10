package com.pages;

import com.microsoft.playwright.Page;

public class BillPayPage {
    private final Page page;

    // Selectors
    private final String billPayLink = "a[href='/parabank/billpay.htm']";
    private final String payeeNameInput = "input[name='payee.name']";
    private final String addressInput = "input[name='payee.address.street']";
    private final String cityInput = "input[name='payee.address.city']";
    private final String stateInput = "input[name='payee.address.state']";
    private final String zipCodeInput = "input[name='payee.address.zipCode']";
    private final String phoneInput = "input[name='payee.phoneNumber']";
    private final String accountNumberInput = "input[name='payee.accountNumber']";
    private final String verifyAccountInput = "input[name='verifyAccount']";
    private final String amountInput = "input[name='amount']";
    private final String fromAccountDropdown = "select[name='fromAccountId']";
    private final String sendPaymentButton = "input[value='Send Payment']";
    private final String successMessage = "#billpayResult";

    public BillPayPage(Page page) {
        this.page = page;
    }

    public void navigateToBillPay() {
        page.click(billPayLink);
    }

    public void fillBillPayForm(String payeeName, String address, String city, String state, 
                                String zipCode, String phone, String accountNumber, 
                                String verifyAccount, String amount, String fromAccount) {
       page.fill(payeeNameInput,payeeName);
        page.fill(addressInput,address);
        page.fill(cityInput,city);
        page.fill(stateInput,state);
        page.fill(zipCodeInput,zipCode);
        page.fill(phoneInput,phone);
        page.fill(accountNumberInput,accountNumber);
        page.fill(verifyAccountInput,verifyAccount);
        page.fill(amountInput,amount);
        page.selectOption(fromAccountDropdown,fromAccount);
    }

    public void clickSendPayment() {
        page.click(sendPaymentButton);
    }

    public boolean isPaymentSuccessful() {
        return page.isVisible(successMessage);
    }
}
