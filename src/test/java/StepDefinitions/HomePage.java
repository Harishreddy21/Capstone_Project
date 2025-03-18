package StepDefinitions;



import org.testng.Assert;

import com.hari1.pages.Homepage;
import com.hari2.classes.ScreenShot;
import com.hari2.classes.WebDriversInitiation;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class HomePage extends WebDriversInitiation {

	 Homepage homepage;

	@Given("User on the WebPage")
	public void user_on_the_web_page() {
		
		    getDriver("chrome"); 
	        driver.get("https://www.letskodeit.com/practice");
	        homepage = new Homepage(driver);
	 // throw new io.cucumber.java.PendingException();
	}
	
	
	@When("Verify the Title")
	public void verify_the_title() {
		
		    String actualTitle = homepage.getPageTitle();
	        System.out.println("Page Title: " + actualTitle);
	        Assert.assertEquals(actualTitle, "Practice Page");	
	 //  throw new io.cucumber.java.PendingException();
	}
	
	
	@When("Verify the  Major sections")
	public void verify_the_major_sections() {
		
		    Assert.assertTrue(homepage.isSectionDisplayed("Home"), "Home section is missing!");
	        Assert.assertTrue(homepage.isSectionDisplayed("All Courses"), "All Courses section is missing!");
	        Assert.assertTrue(homepage.isSectionDisplayed("Interview"), "Interview section is missing!");
	        Assert.assertTrue(homepage.isSectionDisplayed("Support"), "Support section is missing!");
	        Assert.assertTrue(homepage.isSectionDisplayed("Blog"), "Blog section is missing!");
	// throw new io.cucumber.java.PendingException();
	}
	@Then("Verify The title")
	public void verify_the_title_() {
		verify_the_title();
	}
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        ScreenShot.takeScreenshot(driver, scenario.getName());
	    }
	    closeDriver();
	}

}
