package com.symphony.test;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LogInPage;
import utils.Utility;


public class NegativeLogInTest {

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
	public void negativeLoginTest1() throws Exception {

		// Get web page URl and manage browser window to required size
		driver.get(LogInPage.URL);
		driver.manage().window().maximize();
		Thread.sleep(2500);

		LogInPage Action = new LogInPage(driver);

		// Click on Log In button
		LogInPage.txtbx_LogIn.click();

		// Wait element to become present
		WebElement email = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#SubmitCreate > span")));

		// Type wrong email into input field	
		
		//ReadExcelConfig excel = new ReadExcelConfig("C:/Users/PavleD/eclipse-workspace/Symphony/src/test/java/testData/TestData.xlsx");
		//System.out.println(excel.getData(0,1,1));

		Action.fill_Wrong_Details();


		// TEST that correct toast is displayed
		String errorMessage = LogInPage.txtbx_Invalid_Email.getText();
		System.out.println(errorMessage);
		WebElement toast = LogInPage.txtbx_Invalid_Email;

		if (toast.isDisplayed()) {
			System.out.println("PASS Invalid email adress is displayed");
		} else {
			System.out.println("FAIL Invalid email adress is NOT displayed");
			fail();

		}
		if (errorMessage.equals("Invalid email address.")) {
			System.out.println("PASS Correct text is displayed");
		} else {
			System.out.println("FAIL Password incorrect text doesnt match for selected element");
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
