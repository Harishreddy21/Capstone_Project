package com.hari1.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class OtherFunctionalityPage {
	 WebDriver driver;
     String alertPop;
     WebDriverWait wait;
	    private By radioButton = By.id("bmwradio");
	    private By checkBox = By.id("bmwcheck");
	    private By switchWindowBtn = By.id("openwindow");
	    private By switchTabBtn = By.id("opentab");
	    private By SelectClass=By.id("carselect");
	    private  By IsSelectClassSelected=By.xpath("//*[@id=\"carselect\"]/option[2]");
	    private By SelectMultiClass=By.id("multiple-select-example");
	    private By isMultiClassSelected=By.xpath("//*[@id=\"multiple-select-example\"]/option[3]");
	    private By suggest=By.id("autosuggest");
	    private By enableButton = By.id("enabled-button");
	    private By disableButton = By.id("disabled-button");
	    private By hideButton = By.id("hide-textbox");
	    private By showButton = By.id("show-textbox");
	    private By alertBtn = By.id("alertbtn");
	    private By mouseHover = By.id("mousehover");
	    private By tableRows = By.xpath("//table[@id='product']//tbody/tr");

	   
	    public OtherFunctionalityPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    private void switchToNewWindow() throws InterruptedException {
	    	Thread.sleep(3000);
	        for (String handle : driver.getWindowHandles()) {
	        	Thread.sleep(3000);
	            driver.switchTo().window(handle);
	        }
	    }

	    public void switchToMainWindow(String mainWindowHandle) throws InterruptedException {
	    	Thread.sleep(6000);
	        driver.switchTo().window(mainWindowHandle);
	    }

	    
	    //RadioButton
	    public void clickRadioButton() throws InterruptedException {
	    	Thread.sleep(3000);
	        driver.findElement(radioButton).click();
	    }
	    public boolean isRadioButtonSelected() throws InterruptedException {
	    	Thread.sleep(3000);
	        return driver.findElement(radioButton).isSelected();
	    }

	    
	    //CheckBox
	    public void clickCheckBox() throws InterruptedException {
	    	Thread.sleep(6000);
	        driver.findElement(checkBox).click();
	    }

	    public boolean isCheckBoxSelected() throws InterruptedException {
	    	Thread.sleep(3000);
	        return driver.findElement(checkBox).isSelected();
	    }
	    
	 
	    //Window
	    public void switchWindow() throws InterruptedException {
	    	Thread.sleep(3000);
	        driver.findElement(switchWindowBtn).click();
	        Thread.sleep(3000);
	        switchToNewWindow();
	    }

	   
	    //Tab
	    public void switchTab() throws InterruptedException {
	    	Thread.sleep(3000);
	    	 driver.findElement(switchTabBtn).click();
	    	 Thread.sleep(3000);
	        switchToNewWindow();
	    }

	    //Multiselect
	    public void multipleSelectExample() throws InterruptedException {
	    	
	    	Select s1=new Select(driver.findElement(SelectMultiClass));
	    	Thread.sleep(3000);
	    	s1.selectByIndex(1);
	    	Thread.sleep(3000);
	    	s1.selectByIndex(2);
	    	
	    }
	    public boolean multipleSelectExampleisSelected() {
	    	
	    	return driver.findElement(isMultiClassSelected).isSelected();
	    }
	    
	    
	    //SelectClass
        public void selectClassExample() throws InterruptedException {
	    	
	    	Select s1=new Select(driver.findElement(SelectClass));
	    	Thread.sleep(3000);
	    	s1.selectByIndex(1);	
	    	
	    }
        public boolean selectClassExampleisSelected() {
        	
        	return driver.findElement(IsSelectClassSelected).isSelected();
        	
        }
        
        //Suggest
         public void autoSuggest(String str) throws InterruptedException {
	    	 Thread.sleep(3000);
	    	driver.findElement(suggest).sendKeys(str);	
	    	Thread.sleep(3000);
	    	
	    }
         public boolean autoSuggestisDisplayes() {
        	 return driver.findElement(suggest).isDisplayed();
         }
        
        
         //Ennable/Diasable
	    public void enableField() throws InterruptedException {
	    	Thread.sleep(3000);
	    	driver.findElement(By.id("enabled-example-input")).sendKeys("Show Benz");
	    	Thread.sleep(3000);
	        driver.findElement(enableButton).click();
	    }
	    
	    public boolean isEnablefied() {
	    	 return driver.findElement(enableButton).isEnabled();
	    }

	    public void disableField() throws InterruptedException {
	    	Thread.sleep(3000);
	    	 driver.findElement(disableButton).click();
	    }
	    public boolean isdisablefied() {
	    	 return driver.findElement(disableButton).isEnabled();
	    }

	    //Show&Hide
	    public void showTextBox() throws InterruptedException {
	    	Thread.sleep(3000);
	    	driver.findElement(By.id("displayed-text")).sendKeys("Harish");
	       driver.findElement(showButton).click();
	        
	    }
	    public void hideTextBox() throws InterruptedException {
	    	Thread.sleep(3000);
	    	 driver.findElement(hideButton).click();
	    }
	    public boolean isTextDisplayed() {
	    	return driver.findElement(By.id("displayed-text")).isDisplayed();
	    }

	   
	    //Alert
	    public void handleAlert(String str) throws InterruptedException {
	    	
	    	driver.findElement(By.name("enter-name")).sendKeys(str);
	    	Thread.sleep(3000);
	    	driver.findElement(alertBtn).click();
		    Thread.sleep(3000);
		    Alert a=driver.switchTo().alert();
		   Thread.sleep(3000);
		   alertPop=a.getText();
		   a.accept();
		   driver.switchTo().defaultContent();
	    }
	    
	    public String AlertPopMsg() {
	    	 return alertPop;
	    }

	   

	   //MouseFunctionality
	    
	    public void hoverMouse() throws InterruptedException {
	       driver.findElement(mouseHover).click();
	       Thread.sleep(3000);
	       driver.findElement(By.xpath("//*[@id=\"mouse-hover-example-div\"]/div[1]/fieldset/div/div/a[2]")).click();	   
	       }
	    public boolean isAdditionalOptionDisplayed() throws InterruptedException {
	    	 try {
		        	
	    		 return driver.findElement (By.xpath("//*[@id=\"mouse-hover-example-div\"]/div[1]/fieldset/div/div/a[2]")).isEnabled();
		            
		        } catch (TimeoutException e) {
		            return false;
		        }
	    }
	    
	    //Table
	    
	    public Map<String, String> getCoursedDetails() {
	        Map<String, String> courseDetails = new HashMap<>();
	        List<WebElement> rows = driver.findElements(tableRows);

	        for (WebElement row : rows) {
	            List<WebElement> columns = row.findElements(By.tagName("td"));
	            if (columns.size() == 3) {
	                String courseName = columns.get(1).getText().trim();
	                String coursePrice = columns.get(2).getText().trim();
	                courseDetails.put(courseName, coursePrice);
	            }
	        }
	        return courseDetails;
	    }
	    
	    
	    
}
