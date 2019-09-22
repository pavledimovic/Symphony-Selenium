package com.symphony.test;

import static org.testng.Assert.fail;

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
import utils.Utility;

public class SearchResultTest {

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
	public void searchTest() throws InterruptedException {

		// Get web page URl and manage browser window to required size
		driver.get(MainPage.URL3);
		driver.manage().window().maximize();
		Thread.sleep(2500);

		// Create object Action
		MainPage Action = new MainPage(driver);
		

		//NOTE I had big problems to isolate separate categories, tried with Xpath, tagName, Class name, CSS up and down the DOM 
		//and it didnt seem to work, due to lack of time I only did total int size for products
		//Examples:
		//int products3 = driver.findElements(By.cssSelector("#homefeatured")).size();
		//List<WebElement> listImages=driver.findElements(By.xpath("//div[@id='center_column']//ul[@id='homefeatured']"));
		//int products1 = driver.findElements(By.className("product_list grid row homefeatured")).size();
		//System.out.println("No. of Images: "+listImages.size());

		
		// Total number of products in Popular and best sellers
		int productsTotal = 14;
		int products = driver.findElements(By.className("ajax_block_product")).size();
		System.out.println("Total number of Popular and Bestsellers products is:"+products);
		
		if (products == (productsTotal)) {
			System.out.println("PASS Total number of products is 14");
		} else {
			System.out.println("FAIL Total number of products is wrong");
			fail();

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


