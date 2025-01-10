package com.pages;
import com.microsoft.playwright.Page;

import static org.testng.Assert.assertTrue;



public class RegistrationPage {
    private Page page;

    // Locators
    private final String registerLink = "a[href*='register']";
    private final String firstNameInput = "input[name='customer.firstName']";
    private final String lastNameInput = "input[name='customer.lastName']";
    private final String addressInput = "input[name='customer.address.street']";
    private final String cityInput = "input[name='customer.address.city']";
    private final String stateInput = "input[name='customer.address.state']";
    private final String zipCodeInput = "input[name='customer.address.zipCode']";
    private final String phoneNumberInput = "input[name='customer.phoneNumber']";
    private final String ssnInput = "input[name='customer.ssn']";
    private final String usernameInput = "input[name='customer.username']";
    private final String passwordInput = "input[name='customer.password']";
    private final String confirmPasswordInput = "input[name='repeatedPassword']";
    private final String registerButton = "input[type='submit'][value='Register']";
    private final String loginUsernameInput = "input[name='username']";
    private final String loginPasswordInput = "input[name='password']";
    private final String loginButton = "input[type='submit'][value='Log In']";
    private final String logoutLink = "a[href*='logout.htm']";
    private final String loginPageHeader = "h2:has-text('Customer Login')";

    public RegistrationPage(Page page) {
        this.page = page;
    }
    
  

    /**
     * Navigate to the registration page.
     */
    public void navigateToPage(String url) {
        page.navigate(url);
    }
    
    
        
  
    
    public String password() {
    	String password="Password@123";
    	return password;
    }
    
    public static String username1= "Bhushan7065";    

    /**
     * Perform user registration with random username.
     * @throws InterruptedException 
     */
    public void registerUser(String firstName, String lastName, String address, String city, String state,
                               String zipCode, String phoneNumber, String ssn) throws InterruptedException {
    	
        page.fill(firstNameInput, firstName);
        page.fill(lastNameInput, lastName);
        page.fill(addressInput, address);
        page.fill(cityInput, city);
        page.fill(stateInput, state);
        page.fill(zipCodeInput, zipCode);
        page.fill(phoneNumberInput, phoneNumber);
        page.fill(ssnInput, ssn);
        page.fill(usernameInput, username1);
        page.fill(passwordInput, password());
        Thread.sleep(3000);
        page.fill(confirmPasswordInput, password());
        Thread.sleep(3000);
        page.click(registerButton);
        
        ;

    }
    
    
    
  

    /**
     * Perform user login.
     */
    public HomepagemenuPage login(String username, String password) {
        page.fill(loginUsernameInput, username);
        page.fill(loginPasswordInput, password);
        page.click(loginButton);
        return new HomepagemenuPage(page);
    }
    
    public void clickLogout() {
        page.click(logoutLink);
    }

    public void verifyLogout() throws InterruptedException {
    	Thread.sleep(5000);
        boolean isLoginPageVisible = page.isVisible(loginPageHeader);
        assertTrue(isLoginPageVisible, "Logout failed! Customer Login page is not visible.");
    }
}
