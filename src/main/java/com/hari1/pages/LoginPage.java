package com.hari1.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	 WebDriverWait wait;

    private By emailField = By.id("email");
    private By passwordField = By.name("password");
    private By loginButton = By.id("login");
  
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
        public void login(String email, String password) throws InterruptedException {
        	
    	
    	driver.findElement(emailField).sendKeys(email);
    	Thread.sleep(3000);
    	driver.findElement(passwordField).sendKeys(password);
    	Thread.sleep(3000);
    	driver.findElement(loginButton).click();
    }
    public String getLoginMessage() throws InterruptedException {
    	 Thread.sleep(3000);
         String currentTitle=driver.getTitle();
         Thread.sleep(3000);
         return currentTitle;
    }
}
