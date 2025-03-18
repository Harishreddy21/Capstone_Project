package com.hari1.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
	WebDriver driver;
	 WebDriverWait wait;

    public Registration(WebDriver driver) {
       this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By Firstname=By.id("name");
    By lastName=By.id("last_name");
    By usernameField = By.id("email");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("password_confirmation");
    By registerButton = By.xpath("//*[@id=\"page\"]/div[2]/div[2]/div/div/div/form/div[8]/div[1]/input");
   // By successMessage = By.xpath("//div[contains(@class, 'message')]");
    By captchaIframe = By.xpath("//iframe[contains(@title,'reCAPTCHA')]");
    By clickRobot=By.className("recaptcha-checkbox-checkmark");

    public void enterUsername(String username,String name,String Lastname) throws InterruptedException {
    	Thread.sleep(3000);
    	driver.findElement(Firstname).sendKeys(username);
    	Thread.sleep(3000);
    	driver.findElement(lastName).sendKeys(name);
    	Thread.sleep(3000);
        driver.findElement(usernameField).sendKeys(Lastname);
    }

    public void enterPassword(String password) throws InterruptedException {
    	Thread.sleep(3000);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void confirmPassword(String password) throws InterruptedException {
    	Thread.sleep(3000);
        driver.findElement(confirmPasswordField).sendKeys(password);
    }
    
    public void clickSignUp() throws InterruptedException {
    	Thread.sleep(3000);
        driver.findElement(registerButton).click();
    }
    public void robot() throws InterruptedException {
    	Thread.sleep(3000);
    	 WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(captchaIframe));
         driver.switchTo().frame(iframe);
         WebElement captchaCheckbox = wait.until(ExpectedConditions.elementToBeClickable(clickRobot));
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", captchaCheckbox);
         Thread.sleep(3000);
         
         try {
        	 captchaCheckbox.click();
         } catch (ElementClickInterceptedException e) {
        	 Thread.sleep(3000);
             ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickRobot);
         }
    	driver.switchTo().defaultContent();
    }
    public String getRegistrationMessage() throws InterruptedException {	
    	 Thread.sleep(3000);
      String currentTitle=driver.getTitle();
      return currentTitle;
    }
}

