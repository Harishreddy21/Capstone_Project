//package StepDefinitions;
//
//
//import org.openqa.selenium.By;
//
//import org.testng.Assert;
//
//import com.hari1.pages.Registration;
//import com.hari2.classes.ScreenShot;
//import com.hari2.classes.WebDriversInitiation;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//
//public class RegistrationForUser extends WebDriversInitiation {
//
//
//    Registration registrationPage;
//    
//    
//	@Given("I navigate to the registration page")
//	public void i_navigate_to_the_registration_page() throws InterruptedException {
//		
//		getDriver("chrome");
//        driver.get("https://www.letskodeit.com/practice");
//        Thread.sleep(3000);
//        registrationPage = new Registration(driver);
//        driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
//    	Thread.sleep(3000);
//    	driver.findElement(By.xpath(("//*[@id=\"page\"]/div[2]/div/div/div/div/form/div[5]/div[3]/a"))).click();
//	
//	 //  throw new io.cucumber.jasva.PendingException();
//	}
//	
//	
//	@When("I enter FirstName {string} and {string} and username {string}")
//	public void i_enter_a_new_username(String FirstName, String LastName, String UserName) throws InterruptedException {
//		
//		  registrationPage.enterUsername(FirstName,LastName, UserName);
//	 // throw new io.cucumber.java.PendingException();
//	}
//	
//	@When("I enter a new password {string}")
//	public void i_enter_a_new_password(String string) throws InterruptedException {
//		Thread.sleep(3000);
//		registrationPage.enterPassword(string);
//	//  throw new io.cucumber.java.PendingException();
//	}
//	
//	@When("I confirm the password {string}")
//	public void i_confirm_the_password(String string) throws InterruptedException {
//		
//		registrationPage.confirmPassword(string);
//	//   throw new io.cucumber.java.PendingException();
//	}
//	
//	
//	@When("I click the register button")
//	public void i_click_the_register_button() throws InterruptedException {
//		
//		Thread.sleep(3000);
//		registrationPage.robot();
//		Thread.sleep(3000);
//		registrationPage.clickSignUp();
//	//  throw new io.cucumber.java.PendingException();
//	}
//	
//	@Then("I should see a message {string}")
//	public void i_should_see_a_message(String string) throws InterruptedException {
//		
//		String expectedOutput="My Courses";
//		String actualMessage = registrationPage.getRegistrationMessage();
//        actualMessage.equalsIgnoreCase(expectedOutput);
//        Assert.assertEquals(actualMessage, expectedOutput);
//        System.out.println(string);
//        
//	// throw new io.cucumber.java.PendingException();
//	}
//	@After
//	public void tearDown(Scenario scenario) {
//	    if (scenario.isFailed()) {
//	        ScreenShot.takeScreenshot(driver, scenario.getName());
//	    }
//	    closeDriver();
//	}
//
//	
//
//}