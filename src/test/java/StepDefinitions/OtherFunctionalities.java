package StepDefinitions;


import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.hari1.pages.OtherFunctionalityPage;
import com.hari2.classes.ScreenShot;
import com.hari2.classes.WebDriversInitiation;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OtherFunctionalities extends WebDriversInitiation {

 
    OtherFunctionalityPage practicePage;
    String mainWindowHandle;
    
   
    Map<String, String> actualCourseDetails;
    
    // Expected course data
    Map<String, String> expectedCourseDetails = new HashMap<String, String>() {{
        put("Selenium WebDriver With Java", "35");
        put("Python Programming Language", "30");
        put("JavaScript Programming Language", "25");
    }};
    
    
    
    @Given("I open the Let’s Kode It Practice page")
    public void i_open_the_let_s_kode_it_practice_page1() {
    	getDriver("chrome");
        driver.get("https://www.letskodeit.com/practice");
        practicePage = new OtherFunctionalityPage(driver);
        mainWindowHandle = driver.getWindowHandle(); // Store main window handle
    }

    // Radio Button Steps
    @When("I select the radio button")
    public void i_select_the_radio_button() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.clickRadioButton();
    }

    @Then("the radio button should be selected")
    public void the_radio_button_should_be_selected() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(practicePage.isRadioButtonSelected(), "Radio button is not selected");
    }

    // Checkbox Steps
    @When("I select the checkbox")
    public void i_select_the_checkbox() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.clickCheckBox();
    }

    @Then("both checkboxes should be selected")
    public void both_checkboxes_should_be_selected() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(practicePage.isCheckBoxSelected(), "Checkbox is not selected");
    }

    // Window Handling Steps
    @When("I click on button")
    public void i_click_on_button() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.switchWindow();
    }

    @Then("I switch back to the main window")
    public void i_switch_back_to_the_main_window() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.switchToMainWindow(mainWindowHandle);
        String url = driver.getCurrentUrl();
        System.out.println("Window URL: " + url);
    }

    // Switch Tab Steps
    @When("I click on button for tab")
    public void i_click_on_button_for_tab() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.switchTab();
    }

    @Then("I switch back to the main tab")
    public void i_switch_back_to_the_main_tab() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.switchToMainWindow(mainWindowHandle);
        String url = driver.getCurrentUrl();
        System.out.println("Tab URL: " + url);
    }

    // Select Dropdown Steps
    @When("I select from the dropdown")
    public void i_select_from_the_dropdown() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.selectClassExample();
    }

    @Then("should be selected")
    public void should_be_selected() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(practicePage.selectClassExampleisSelected());
    }

    // Multiple Select Steps
    @When("I select multiple options from the dropdown")
    public void i_select_multiple_options_from_the_dropdown() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.multipleSelectExample();
    }

    @Then("Options should be selected")
    public void and_should_be_selected() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(practicePage.multipleSelectExampleisSelected());
    }

    // Auto Suggest Steps
    @When("I type {string} in the AutoSuggest box")
    public void i_type_in_the_auto_suggest_box(String string) throws InterruptedException {
        Thread.sleep(3000);
        practicePage.autoSuggest(string);
    }

    @Then("{string} should be displayed in the AutoSuggest box")
    public void should_be_displayed_in_the_auto_suggest_box(String string) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(practicePage.autoSuggestisDisplayes());
    }

    // Enable/Disable Steps
    @When("I enable the input field")
    public void i_enable_the_input_field() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.enableField();
    }

    @Then("the field should be enabled")
    public void the_field_should_be_enabled() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(practicePage.isEnablefied());
    }

    @When("I disable the input field")
    public void i_disable_the_input_field() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.disableField();
    }

    @Then("the field should be disabled")
    public void the_field_should_be_disabled() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(practicePage.isdisablefied());
    }

    // Show/Hide Steps
    @When("I click on Show button")
    public void i_click_on_button_3() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.showTextBox();
    }

    @When("the textbox should be hidden")
    public void the_textbox_should_be_hidden() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.hideTextBox();
    }

    @Then("the textbox should be displayed")
    public void the_textbox_should_be_displayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertFalse(practicePage.isTextDisplayed());
    }

    // Alert Steps
    @When("I click on {string} button")
    public void i_click_on_button1(String string) throws InterruptedException {
        Thread.sleep(3000);
        practicePage.handleAlert(string);
    }

    @Then("a confirmation popup should appear and I accept it")
    public void a_confirmation_popup_should_appear_and_i_accept_it() throws InterruptedException {
        Thread.sleep(3000);
        String str2 = practicePage.AlertPopMsg();
        System.out.println("Alert message: " + str2);
    }

    // Mouse Hover Steps
    @When("I hover over the Mouse Hover button")
    public void i_hover_over_the_mouse_hover_button() throws InterruptedException {
        Thread.sleep(3000);
        practicePage.hoverMouse();
    }

    @Then("I should see additional options")
    public void i_should_see_additional_options() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(practicePage.isAdditionalOptionDisplayed());
    }
    
    //Table
    
    @When("I fetch the course details from the table")
    public void i_fetch_the_course_details_from_the_table() {
        actualCourseDetails = practicePage.getCoursedDetails();
    }
  
    @Then("I should see the correct course prices")
    public void i_should_see_the_correct_course_prices() {
    	
        Assert.assertEquals(actualCourseDetails, expectedCourseDetails, "Course details do not match!");
        System.out.println("Course details are verified successfully.");
    }
    
    @After
    public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        ScreenShot.takeScreenshot(driver, scenario.getName());
	    }
	    closeDriver();
	}

   
}