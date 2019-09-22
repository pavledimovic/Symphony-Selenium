package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.ReadExcelConfig;

public class LogInPage {

	WebDriver driver;

	public LogInPage(WebDriver driver1) {
		PageFactory.initElements(driver1, this);
	}

	// URL
	public static String URL = "http://automationpractice.com ";

	// Button ID's
	@FindBy(how = How.CSS, using = ".login")
	public static WebElement txtbx_LogIn;

	@FindBy(how = How.CSS, using = "#email_create")
	public static WebElement txtbx_EmailAdress;

	@FindBy(how = How.CSS, using = "#SubmitCreate > span")
	public static WebElement btn_Create_Account;

	@FindBy(how = How.CSS, using = "ol > li")
	public static WebElement txtbx_Invalid_Email;

	@FindBy(how = How.CSS, using = "//input[@placeholder='Email Address']")
	public static WebElement txtbx_UserName;

	@FindBy(how = How.CSS, using = "//input[@placeholder='Password']")
	public static WebElement txtbx_Password;

	
	// Actions
	public void click_submit() {
		btn_Create_Account.click();
	}
	
	// Log In elements actions
	public void enter_UserName(String UserName) {
		txtbx_EmailAdress.sendKeys(UserName);
	}

	
	public void enter_Wrong_Email(String sUserName) {
		txtbx_EmailAdress.sendKeys(sUserName);
	}
	
	public void fill_Wrong_Details() throws Exception {
		
		
		ReadExcelConfig excel = new ReadExcelConfig(Constant.Path_TestData);
		String sUserName = excel.getData(0,1,1);
		enter_Wrong_Email(sUserName);
		click_submit();
}

}
