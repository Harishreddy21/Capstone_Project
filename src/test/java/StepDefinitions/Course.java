package StepDefinitions;




import com.hari1.pages.coursePage;
import com.hari2.classes.ScreenShot;
import com.hari2.classes.WebDriversInitiation;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Course extends WebDriversInitiation {
	
	    coursePage coursesPage;
	    
	
	@Given("I navigate to the All Courses page")
	public void i_navigate_to_the_all_courses_page1() {
		
		getDriver("chrome");
        driver.get("https://www.letskodeit.com/practice");
        coursesPage = new coursePage(driver);
	  // throw new io.cucumber.java.PendingException();
	}
	
	@When("I select {string} from the category filter")
	public void i_select_from_the_category_filter(String string) throws InterruptedException {
		
		 driver.switchTo().frame("courses-iframe");
		Thread.sleep(3000);
		coursesPage.selectCategory(string);
		
	//  throw new io.cucumber.java.PendingException();
	}
	
	@Then("I should see only courses related to {string}")
	public void i_should_see_only_courses_related_to(String string) throws InterruptedException {
		
		 driver.switchTo().frame("courses-iframe");
		Thread.sleep(3000);
		System.out.println("Filtered courses should be related to: " + string);
	  //  throw new io.cucumber.java.PendingException();
	}
	
	
	@When("I enter {string} in the search box")
	public void i_enter_in_the_search_box(String string) throws InterruptedException {
		 driver.switchTo().frame("courses-iframe");
		Thread.sleep(3000);
		coursesPage.searchCourse(string);
	 //  throw new io.cucumber.java.PendingException();
	}

	@Then("I should see search results related to {string}")
	public void i_should_see_search_results_related_to(String string) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Search results should display courses related to: " + string);
	 //  throw new io.cucumber.java.PendingException();
	}
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        ScreenShot.takeScreenshot(driver, scenario.getName());
	    }
	    closeDriver();
	}

}