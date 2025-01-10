package com.test;
import org.testng.annotations.Test;

import com.base.BaseTest;


public class RegistrationTest extends BaseTest {
	

    @Test
    public void testRegistration() throws InterruptedException {
    	
        registrationPage.registerUser(
            "Naga", "Bhushan", "63 Coconut Garden", "Bangalore", "IN", 
            "560072", "765-0098", "998-65-4470");
        Thread.sleep(5000);
        
     // Perform logout and verify
   	 registrationPage.clickLogout();
   	 registrationPage.verifyLogout();
   	 Thread.sleep(5000);
    	 //registrationPage.login(RegistrationPage.username1 ,registrationPage.password());
    	 Thread.sleep(5000);
    	 
         
    	 
     }

}
