//package StepDefinitions;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//
//import org.testng.Assert;
//
//import com.hari1.pages.LoginPage;
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
//public class Login extends WebDriversInitiation{
//	
//    LoginPage loginPage;
//    
//    
//	@Given("I navigate to the login page")
//	public void i_navigate_to_the_login_page() throws InterruptedException {
//		getDriver("chrome");
//        driver.get("https://www.letskodeit.com/practice");
//        loginPage = new LoginPage(driver);
//        Thread.sleep(3000);
//    	driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
//	}
//	
//	@When("I enter username and password")
//	public void i_enter_username_and_password() throws InterruptedException, IOException {
//		File f = new File("D:\\Documents\\24374 - A Harish Redy\\Capstone_User_Book1.xlsx");
//        FileInputStream fis = new FileInputStream(f);
//        XSSFWorkbook w = new XSSFWorkbook(fis);
//        XSSFSheet s = w.getSheetAt(0);
//        XSSFRow r=s.getRow(1);
//            String username = r.getCell(0).getStringCellValue();
//            String password = r.getCell(1).getStringCellValue();
//            Thread.sleep(3000);
//            loginPage.login(username, password);
//         
//            //   throw new io.cucumber.java.PendingException();
//            
//            w.close();
//        }
//       
//  
//	
//	@Then("I should see message")
//	public void i_should_see() throws InterruptedException, IOException {
//		File f = new File("D:\\Documents\\24374 - A Harish Redy\\Capstone_User_Book1.xlsx");
//        FileInputStream fis = new FileInputStream(f);
//        XSSFWorkbook w = new XSSFWorkbook(fis);
//        XSSFSheet s = w.getSheetAt(0);
//        XSSFRow r=s.getRow(1);
//        String message = r.getCell(2).getStringCellValue();
//        String expectedOutput = "My Courses";
//        Thread.sleep(3000);
//        String actualMessage = loginPage.getLoginMessage();
//        Thread.sleep(3000);
//        Assert.assertEquals(actualMessage, expectedOutput);
//        
//       System.out.println(message);
//        
//        w.close();
//        fis.close();
//     
//	//   throw new io.cucumber.java.PendingException();
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
//	
//}
