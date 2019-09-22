package com.symphony.test;

import static org.testng.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void searchTest() throws InterruptedException {

		// Get web page URl and manage browser window to required size
		driver.get(MainPage.URL3);
		driver.manage().window().maximize();
		Thread.sleep(2500);

		// Create object Action
		MainPage Action2 = new MainPage(driver);
		SearchPage Action = new SearchPage(driver);
		
		
		//NOTE I had big problems to isolate separate categories, tried with Xpath, tagName, Class name, CSS up and down the DOM 
		//and it didnt seem to work, due to lack of time I did it with solution that is not recommended: using absolute xpath
		//Examples that I tried:
		//int products3 = driver.findElements(By.cssSelector("#homefeatured")).size();
		//List<WebElement> listImages=driver.findElements(By.xpath("//div[@id='center_column']//ul[@id='homefeatured']"));
		//int products1 = driver.findElements(By.className("product_list grid row homefeatured")).size();
		//System.out.println("No. of Images: "+listImages.size());
		//int products = driver.findElements(By.className("ajax_block_product")).size();
		//System.out.println("Count of Featured Courses page is:"+products);

		int listImages =driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li")).size();
		//int listImages = SearchPage.txtbx_popular;
		System.out.println(listImages);
		
		// Total number of products in Popular 
		int productsTotal = 7;
		
		if (listImages == (productsTotal)) {
			System.out.println("PASS Total number of popular products is 7");
		} else {
			System.out.println("FAIL Total number of popular products is wrong");
			fail();
		}	   
		
		Action.click_bestSelers();
		int listImages2 =driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li")).size();
		System.out.println(listImages2);
		
		// Total number of products in bestsellers
		int productsTotal2 = 7;
		
		if (listImages2 == (productsTotal2)) {
			System.out.println("PASS Total number of bestsellers products is 7");
		} else {
			System.out.println("FAIL Total number of bestsellers products is wrong");
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


