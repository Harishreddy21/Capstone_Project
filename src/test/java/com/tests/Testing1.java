package com.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hari1.pages.OtherFunctionalityPage;
import com.hari1.pages.Homepage;
import com.hari1.pages.LoginPage;
import com.hari1.pages.Registration;
import com.hari1.pages.coursePage;
import com.hari2.classes.WebDriversInitiation;

public class Testing1 extends WebDriversInitiation {
	Homepage homePage;
    OtherFunctionalityPage Buttonpage;
    coursePage coursesPage;
    Registration registration;
    LoginPage login;
    String mainWindowHandle;
 
    @BeforeMethod
    public void setup() throws InterruptedException {
        getDriver("chrome");
        driver.get("https://www.letskodeit.com/practice");
        Thread.sleep(3000);
        homePage = new Homepage(driver);
        Buttonpage = new OtherFunctionalityPage(driver);
        coursesPage = new coursePage(driver);
        login=new LoginPage(driver);
        registration=new Registration(driver);
        mainWindowHandle = driver.getWindowHandle();
    }

    @Test(priority=1)
    public void verifyHomePage() throws InterruptedException {
    	 
       Thread.sleep(3000);
        Assert.assertEquals(homePage.getPageTitle(),"Practice Page","Page title does not match");
       Assert.assertTrue(homePage.isSectionDisplayed("Home"));
       Assert.assertTrue(homePage.isSectionDisplayed("All Courses"));
       Assert.assertTrue(homePage.isSectionDisplayed("Interview"));
       Assert.assertTrue(homePage.isSectionDisplayed("Support"));
       Assert.assertTrue(homePage.isSectionDisplayed("Blog"));
    }

    @Test(priority=2)
    public void verifyPracticePage() throws InterruptedException {
    	 Thread.sleep(3000);
    	 Buttonpage.clickRadioButton();
        Assert.assertTrue(Buttonpage.isRadioButtonSelected());
        Thread.sleep(3000);
        Buttonpage.clickCheckBox();
        Assert.assertTrue(Buttonpage.isCheckBoxSelected());
        
        Buttonpage.switchWindow();
        Buttonpage.switchToMainWindow(mainWindowHandle);
        
        Buttonpage.switchTab();
        Buttonpage.switchToMainWindow(mainWindowHandle);
        
        Buttonpage.selectClassExample();
        
        Buttonpage.multipleSelectExample();
        
        Buttonpage.autoSuggest("Harish");
        
        Buttonpage.enableField();
        Buttonpage.disableField();
        
        Buttonpage.showTextBox();
        Buttonpage.hideTextBox();
        
        
        Buttonpage.handleAlert("Harish");
        Buttonpage.hoverMouse();   
        
        Map<String, String> actualCourseDetails = Buttonpage.getCoursedDetails();
        Map<String, String> expectedCourseDetails = new HashMap<String, String>() {{
            put("Selenium WebDriver With Java", "35");
            put("Python Programming Language", "30");
            put("JavaScript Programming Language", "25");
        }};
        Assert.assertEquals(actualCourseDetails, expectedCourseDetails, "Course details do not match!");
    }
   

    @Test(priority=3)
    public void verifyCoursesSearch() throws InterruptedException {
    	 Thread.sleep(3000);
    	 driver.switchTo().frame("courses-iframe");
    	 coursesPage.selectCategory("Test Automation");
    	 Thread.sleep(3000);
    	 driver.switchTo().frame("courses-iframe");
        coursesPage.searchCourse("Selenium WebDriver Advanced");
       
    }

  
    // @Test(priority=4)
    // @Parameters({"Username","Password"})
    // public void LoginPage(@Optional("venky2003@gmail.com") String username, @Optional("venky@345") String password) throws InterruptedException {
    // 	Thread.sleep(3000);
    // 	driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
    // 	login.login(username, password);
    // }
    // @Test(priority=5)
    // public void RegistrationPage() throws InterruptedException {
    // 	Thread.sleep(3000);
    // 	driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
    // 	Thread.sleep(3000);
    // 	driver.findElement(By.xpath(("//*[@id=\"page\"]/div[2]/div/div/div/div/form/div[5]/div[3]/a"))).click();
    // 	Thread.sleep(3000);
    // 	registration.enterUsername("test@gmai.com","Hari","Reddy");
    // 	registration.enterPassword("test@123");
    // 	registration.confirmPassword("test@123");
    // 	registration.robot();
    // 	registration.clickSignUp();
    // }
   
}
