package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver1) {
		PageFactory.initElements(driver1, this);
	}
	
	public static String URL3 = "http://automationpractice.com";
	
	// Button ID's
	@FindBy(how = How.CSS, using = ".ajax_block_product:nth-child(1)")
	public static WebElement txtbx_product1;

	@FindBy(how = How.CSS, using = ".ajax_block_product:nth-child(2)")
	public static WebElement txtbx_product2;

	@FindBy(how = How.CSS, using = ".last-in-line")
	public static WebElement txtbx_product3;

	@FindBy(how = How.CSS, using = ".ajax_block_product:nth-child(4)")
	public static WebElement txtbx_product4;

	@FindBy(how = How.CSS, using = ".ajax_block_product:nth-child(5)")
	public static WebElement txtbx_product5;
	
	@FindBy(how = How.CSS, using = ".blockbestsellers:nth-child(1)")
	public static WebElement btn_BestSellers;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li")
	public static int txtbx_popular;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[2]/li")
	public static int txtbx_bestselers;
	
	public void get_SizeOfProduct1() {
		txtbx_product1.getText();
	}
	
	public void click_bestSelers() {
		btn_BestSellers.click();
	}
	
	


}

