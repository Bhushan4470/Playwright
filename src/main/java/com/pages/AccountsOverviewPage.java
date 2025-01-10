package com.pages;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;


public class AccountsOverviewPage {
	  private final Page page;

	    
	    // Selectors
	    private final Locator accountTable;
	    private final Locator accountBalance;

    // Constructor
    public AccountsOverviewPage(Page page) {
        this.page = page;
        this.accountTable = page.locator("#accountTable");
        this.accountBalance = page.locator("#accountTable tbody tr td:nth-child(2)");
    }

    // Validate if balance details are present
    public boolean areBalanceDetailsPresent() {
        return accountBalance.count() > 0;
    }

    // Get balance for a specific account row (row index starts from 0)
    public String getBalanceForAccount(int rowIndex) {
        return accountBalance.nth(rowIndex).textContent().trim();
    }

    // Verify the total balance displayed
    public String getTotalBalance() {
        Locator totalRow = accountTable.locator("tbody tr").last();
        return totalRow.locator("td:nth-child(2)").textContent().trim();
    }
}
   