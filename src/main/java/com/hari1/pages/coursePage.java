package com.hari1.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class coursePage {
	WebDriver driver;

    private By categoryDropdown = By.xpath("//*[@id='zen_all_courses_dynamic']//select");
    private By searchField = By.name("course");
    private By searchButton = By.xpath("//*[@id=\"search\"]/div/button/i");

    public coursePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCategory(String category) throws InterruptedException {
    	 Thread.sleep(3000);
    	    Select dropdown = new Select(driver.findElement(categoryDropdown)); 
    	    dropdown.selectByVisibleText(category);
    	    driver.switchTo().defaultContent();
    }

    public void searchCourse(String courseName) throws InterruptedException {
    	 Thread.sleep(3000);
        driver.findElement(searchField).sendKeys(courseName);
        Thread.sleep(3000);
        driver.findElement(searchButton).click();
        driver.switchTo().defaultContent();
    }
}
