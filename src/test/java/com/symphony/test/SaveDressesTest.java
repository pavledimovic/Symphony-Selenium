package com.symphony.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.SearchPage;
import utils.Utility;

public class SaveDressesTest {

	static WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("Chrome") String browser) throws Exception {
		// Check if parameter passed from TestNG is 'Chrome'
		if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "C:/Selenium/Chrome/ChromeDriver.exe");
			// create chrome instance
			driver = new ChromeDriver();
		}
		// Check if parameter passed as 'firefox'
		else if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver", "C:/Selenium/Mozilla/GeckoDriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void saveDressesTest() throws InterruptedException {

		// Get web page URl and manage browser window to required size
		driver.get(MainPage.URL3);
		driver.manage().window().maximize();
		Thread.sleep(2500);

		// Create object Action
		MainPage Action = new MainPage(driver);
		SearchPage Action2 =new SearchPage(driver);
		String info = "Collected Informations";
		File file = new File("Printed dresses" + ".txt");

		// Enter search input
		Action.Clear();
		Action.enter_Search();
		Action.Click_Search();
		//Action.

		// Get text from product 1
		String product1 = SearchPage.txtbx_product1.getText();

		// Write result in .txt file
		try {
			FileWriter fw = new FileWriter(file, true);
			String lineSeparator = System.getProperty("line.separator");
			  String[] ouput = info.split("\n");

			  for (int i = 0; i <= ouput.length-1; i++) {
			    fw.write(ouput[i]);
			    fw.write(lineSeparator);
			  }
			fw.write(product1);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get text from product 2
		String product2 = SearchPage.txtbx_product2.getText();

		// Write result in .txt file
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(product2);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get text from product 3
		String product3 = SearchPage.txtbx_product3.getText();

		
		// Write result in .txt file
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(product3);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get text from product 4
		String product4 = SearchPage.txtbx_product4.getText();

		
		// Write result in .txt file
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(product4);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get text from product 5
		String product5 = SearchPage.txtbx_product5.getText();

		
		// Write result in .txt file
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(product5);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException {
		if (ITestResult.FAILURE == result.getStatus()) {
			Utility.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
