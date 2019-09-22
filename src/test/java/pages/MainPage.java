package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;

	public MainPage(WebDriver driver1) {
		PageFactory.initElements(driver1, this);
	}
	
	public static String URL3 = "http://automationpractice.com";
	
	// Button ID's
	@FindBy(how = How.CSS, using = "#search_query_top")
	public static WebElement txtbx_Search;

	
	@FindBy(how = How.CSS, using = ".button-search")
	public static WebElement btn_Button_Search;

	public void enter_Search() {
		txtbx_Search.sendKeys("printed dresses");
	}
	public void Clear() {
		txtbx_Search.clear();
	}
	public void Click_Search() {
		btn_Button_Search.click();
	}
}
