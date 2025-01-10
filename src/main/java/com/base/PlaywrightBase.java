package com.base;


import com.microsoft.playwright.*;

public class PlaywrightBase {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    public Page setup() {
        playwright = Playwright.create();
        //replace with chromium/firefox
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        
        return page;
    }

  
}
