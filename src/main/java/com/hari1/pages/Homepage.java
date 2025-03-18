package com.hari1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Homepage {
	 WebDriver driver;
	 
	    private By homeLink = By.linkText("Home");
	    private By allCoursesLink = By.linkText("ALL COURSES");
	    private By interviewLink = By.linkText("INTERVIEW");
	    private By supportLink = By.linkText("Support");
	    private By blogLink = By.linkText("BLOG");

	  
	    public Homepage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public String getPageTitle() {
	        return driver.getTitle();
	    }

	    public boolean isSectionDisplayed(String section) {
	        switch (section) {
	            case "Home":
	            	return driver.findElement(homeLink).isDisplayed();
	            case "All Courses": 
	            	return driver.findElement(allCoursesLink).isDisplayed();
	            case "Interview": 
	            	return driver.findElement(interviewLink).isDisplayed();
	            case "Support": 
	            	return driver.findElement(supportLink).isDisplayed();
	            case "Blog": 
	            	return driver.findElement(blogLink).isDisplayed();
	            default: 
	            	return false;
	        }
	    }
}
