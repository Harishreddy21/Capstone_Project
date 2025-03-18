package com.hari2.classes;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
	
	 public static void takeScreenshot(WebDriver driver, String testName) {
	        try {
	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String filePath = "D:\\Documents\\24374 - A Harish Redy\\Zoom\\Capstone_Project_Harish\\Screeshots" + testName + "_" + timestamp + ".png";
	            File destFile = new File(filePath);
	            FileUtils.copyFile(srcFile, destFile);
	            System.out.println("Screenshot captured: " + filePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Failed to capture screenshot");
	        }
	    }
}
