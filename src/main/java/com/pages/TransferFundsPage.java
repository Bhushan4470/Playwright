package com.pages;
import com.microsoft.playwright.Page;

public class TransferFundsPage {
    private final Page page;

    // Selectors as Strings
    private final String amountField = "#amount";
    private final String fromAccountDropdown = "#fromAccountId";
    private final String toAccountDropdown = "#toAccountId";
    private final String transferButton = "input[type='submit'][value='Transfer']";
    private final String successMessage = "#showResult h1.title";
    private final String amountResult = "#amountResult";
    private final String fromAccountResult = "#fromAccountIdResult";
    private final String toAccountResult = "#toAccountIdResult";
    private final String transferFundsLink  = "a[href*='transfer.htm']";
    
    
    public TransferFundsPage(Page page) {
        this.page = page;
    }
 // Method to click on Transfer Funds
    public void clickOnTransferFunds() {
        page.click(transferFundsLink);
    }

    // Additional helper to verify the current page
    public String getCurrentPageTitle() {
        return page.title();
    }
 

    // Enter the transfer amount
    public void enterAmount(String amount) {
        page.fill(amountField, amount);
    }

    // Select the "To Account" dynamically
    public void selectToAccount(int index) {
        String optionSelector = toAccountDropdown + " option";
        String toAccountValue = page.locator(optionSelector).nth(index).getAttribute("value");
        page.selectOption(toAccountDropdown, toAccountValue);
    }

    // Click the Transfer button
    public void clickTransfer() {
        page.click(transferButton);
    }

    // Get the success message
    public String getSuccessMessage() {
        return page.locator(successMessage).textContent().trim();
    }

    // Get the amount transferred
    public String getAmountTransferred() {
        return page.locator(amountResult).textContent().trim();
    }

    // Get the "From Account" in the result
    public String getFromAccount() {
        return page.locator(fromAccountResult).textContent().trim();
    }

    // Get the "To Account" in the result
    public String getToAccount() {
        return page.locator(toAccountResult).textContent().trim();
    }
}