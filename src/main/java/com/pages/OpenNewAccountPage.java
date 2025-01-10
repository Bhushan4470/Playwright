package com.pages;
import com.microsoft.playwright.Page;

public class OpenNewAccountPage {
    private Page page;

    // Selectors
    private final String accountTypeDropdown = "#type";
    private final String fromAccountDropdown = "#fromAccountId";
    private final String openAccountButtonlink= "a[href*='openaccount.htm']";
    private final String openAccountButton = "input.button";
    private final String newAccountResult = "#openAccountResult";
    private final String newAccountIdLink = "#newAccountId";

    // Constructor
    public OpenNewAccountPage(Page page) {
        this.page = page;
    }

    // Methods
    public void selectAccountType(String accountType) {
        page.selectOption(accountTypeDropdown, accountType.equalsIgnoreCase("SAVINGS") ? "1" : "0");
    }

    public void selectFromAccount(String accountId) {
        page.selectOption(fromAccountDropdown, accountId);
    }

    public void clickOpenAccountButton() {
        page.click(openAccountButton);
    }

    public void clickOpenAccountButtonlink() {
        page.click(openAccountButtonlink);
    }
    public String getNewAccountNumber() {
        page.waitForSelector(newAccountResult);
        return page.textContent(newAccountIdLink).trim();
    }
}
