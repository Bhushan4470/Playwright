package com.pages;
import java.util.List;
import com.microsoft.playwright.Page;
public class HomepagemenuPage {
	  private Page page;

    
    // Selectors
    private final String accountServicesMenu = "#leftPanel ul li a";
    private final String menuHeader = "h2";

    // Constructor
    public HomepagemenuPage(Page page) {
        this.page = page;
    }

    // Methods
    public List<String> getAccountServicesMenuItems() {
        return page.locator(accountServicesMenu).allInnerTexts();
    }

    public boolean isMenuItemPresent(String menuItem) {
        return getAccountServicesMenuItems().contains(menuItem);
    }

    public void clickMenuItem(String menuItem) {
        page.locator(accountServicesMenu + ":has-text('" + menuItem + "')").click();
    }

    public String getPageHeader() {
        return page.locator(menuHeader).textContent().trim();
    }
}
