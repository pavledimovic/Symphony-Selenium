package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

	WebDriver driver;

	public CreateAccountPage(WebDriver driver1) {
		PageFactory.initElements(driver1, this);
	}
	
	public static String URL2 = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	

	// Button ID's
	@FindBy(how = How.CSS, using = "#email_create")
	public static WebElement txtbx_EmailAdress;
	
	@FindBy(how = How.CSS, using = "#SubmitCreate > span")
	public static WebElement btn_Create_Account;

	@FindBy(how = How.CSS, using = "#customer_firstname")
	public static WebElement txtbx_First_Name;

	@FindBy(how = How.CSS, using = "#customer_lastname")
	public static WebElement txtbx_Last_Name;

	@FindBy(how = How.CSS, using = "#passwd")
	public static WebElement txtbx_Password;

	@FindBy(how = How.CSS, using = "#email")
	public static WebElement txtbx_Email;

	@FindBy(how = How.CSS, using = "#company")
	public static WebElement txtbx_Company;

	@FindBy(how = How.CSS, using = "#address1")
	public static WebElement txtbx_Adress;
	
	@FindBy(how = How.CSS, using = "#city")
	public static WebElement txtbx_City;

	@FindBy(how = How.CSS, using = "#id_state")
	public static WebElement txtbx_State;

	@FindBy(how = How.CSS, using = "#id_state") // klik 2 puta za default zemlju
	public static WebElement btn_State;

	@FindBy(how = How.CSS, using = "#postcode")
	public static WebElement txtbx_Zip;

	@FindBy(how = How.CSS, using = "#id_country") // klik 2 puta za default zemlju
	public static WebElement txtbx_Country;

	@FindBy(how = How.CSS, using = "#phone_mobile")
	public static WebElement txtbx_Mobile_Phone;
	
	@FindBy(how = How.CSS, using = "#submitAccount > span")
	public static WebElement txtbx_Submit;
	
	@FindBy(how = How.CSS, using = ".logout")
	public static WebElement txtbx_Logout;

	
	// Log In elements actions
		public void enter_FirstName() {
			txtbx_First_Name.sendKeys("aaa");
		}
		
		public void enter_LastName() {
			txtbx_Last_Name.sendKeys("aaa");
		}

		public void enter_Password() {
			txtbx_Password.sendKeys("beta8b");
		}
				
		public void enter_Company() {
			txtbx_Company.sendKeys("aaa");
		}
		
		public void enter_Adress() {
			txtbx_Adress.sendKeys("aaa");
		}
		
		public void enter_City() {
			txtbx_City.sendKeys("aaa");
		}
		
		public void Chose_State() {
			txtbx_State.click();
		}
		
		public void Chose_State1() {
			txtbx_State.sendKeys("a");
		}
		
		public void enter_Zip() {
			txtbx_Zip.sendKeys("90210");
		}
		
		public void choose_Country() {
			txtbx_Country.click();
		}
		
		public void choose_Country1() {
			txtbx_Country.sendKeys("d");
		}
		
		public void enter_Mobili_Phone() {
			txtbx_Mobile_Phone.sendKeys("123456789");
		}
		
		public void click_Submit() {
			txtbx_Submit.click();
		}
		
		
		// Auto fill log in credentials
		public void fill_Details() throws InterruptedException {
			
			enter_FirstName();
			enter_LastName();
			enter_Password();
			enter_Company();
			enter_Adress();
			enter_City();
			Chose_State();
			Chose_State1();
			Chose_State();
			enter_Zip();
			choose_Country();
			choose_Country1();
			choose_Country();
			enter_Mobili_Phone();
			click_Submit();
			
		}	
		// Actions
		public void click_submit() {
			btn_Create_Account.click();
		}
		public void enter_Email(String enter_Email) {
			txtbx_EmailAdress.sendKeys(enter_Email);
		}
		
		public void enter_Email() throws InterruptedException {
			// Change email for every new test run or delete existing user
			enter_Email("pavledimovic8@gmail.com");
			Thread.sleep(1500);
			click_submit();
			Thread.sleep(4000);
	}
		

}


