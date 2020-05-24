package SDETSelenium.Assignment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.SignUpPage;
import Resources.DriverFactory;
import Resources.GetData;

public class Olay_Test extends DriverFactory {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser() throws IOException {
		this.driver = invokeBrowser();
	}
	
	@Test(dataProvider = "getUrl", dataProviderClass = GetData.class)
	public void valid_user_Registration(String url, String uname, String pwd, String country, String fname, String lname, String address, String city, String pin, String dob, String land, String user) throws IOException, InterruptedException {
		
		Homepage hp = new Homepage(driver);
		SignUpPage sp = new SignUpPage(driver);
		
		if(country.equalsIgnoreCase("Germany")) {
			log.info("Fetching the details from excel file");
		}
		if(country.equalsIgnoreCase("Spain")) {
			log.info("Fetching the details from json file");
		}
		driver.get(url);
		log.info("url launched: "+url);
		
		hp.registerlink().click();
//		if( hp.countryPopup().size() >0) {
//			log.info("country popup displayed");
//			hp.countryPopup().get(1).click();
//			hp.registerlink().click();
//		}
		
		log.info("clicked on registration link");
		if(country.equalsIgnoreCase("Germany")||country.equalsIgnoreCase("Spain")) {
			sp.gender().click();
			log.info("selected gender");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		sp.emailIDfield().sendKeys(uname);
		log.info("email entered");
		sp.password().sendKeys(pwd);
		sp.confirm_password().sendKeys(pwd);
		log.info("password entered");
		js.executeScript("window.scrollBy(0,1000)");
		sp.registerprofile().click();
		log.info("Verifying whether user is able to register without entering the DOB to validate mandatory field check");
		js.executeScript("window.scrollBy(0,-100)");
		String[] str = dob.split("/");
		Select day = new Select(sp.birthday());
		day.selectByValue(str[0]);
		Select month = new Select(sp.birthmonth());
		month.selectByValue(str[1]);
		Select year = new Select(sp.birthyear());
		year.selectByValue(str[2]);
		log.info("User is not able to register without entering mandatory field");
		log.info("DOB entered");
		if(country.equalsIgnoreCase("Germany")) {
			sp.land().click();
			Select la = new Select(sp.land());
			la.selectByVisibleText(land);
		}
		js.executeScript("window.scrollBy(0,700)");
		sp.registerprofile().click();
		
		if(country.equalsIgnoreCase("UK")) {
			
			if(user.equalsIgnoreCase("Existing")) {
				sp.error_Alreadyreg().isDisplayed();
				log.info("User already registered message is displayed in the page");
			}
			else if(user.equalsIgnoreCase("New")) {
				log.info("clicked on Register profile and navigating to second page for UK");
			}
		}
		if(user.equalsIgnoreCase("New")) {
			sp.firstName().sendKeys(fname);
			sp.lastName().sendKeys(lname);
			log.info("entered firstname and lastname");
			
			if(country.equalsIgnoreCase("UK")||country.equalsIgnoreCase("Germany")) {
				sp.address().sendKeys(address);
				sp.city().sendKeys(city);
				sp.postcode().sendKeys(pin);
				log.info("entered address, city and pincode");
			}
		}

		js.executeScript("window.scrollBy(0,750)");
		sp.addToProfile().click();
		log.info("clicked submit button of registration page");
		if(user.equalsIgnoreCase("New")) {
			sp.registrationcomplete().isDisplayed();
			log.info("Sucessfully registered message is displayed in the page");
		}
		else if(user.equalsIgnoreCase("Existing")) {
			js.executeScript("window.scrollBy(0,-750)");
			sp.error_Alreadyreg().isDisplayed();
			log.info("User already registered message is displayed in the page");
		}
		
		Thread.sleep(10000);	
	}
	
	@Test(dataProvider = "getsignindetails", dataProviderClass = GetData.class)
	public void signin(String url, String uname, String pwd, String country) {
		
		Homepage hp = new Homepage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get(url);
		log.info("url launched: "+url);
		hp.signinlink().click();
		log.info("clicked on signin link");
		hp.uname().sendKeys(uname);
		log.info("entered username");
		hp.pwd().sendKeys(pwd);
		log.info("entered password");
		hp.signinButton().click();
		log.info("clicked on signin button");
		hp.landingPage().isDisplayed();
		log.info("Landed on profile page");
		js.executeScript("window.scrollBy(0,150)");
		String uname1 = hp.profileUname().getText();
		uname1.equals(uname);
		log.info("User lands on the correct account");
		
	}
	
	@Test
	public void invalid_signin() throws IOException {
		
		Homepage hp = new Homepage(driver);
		for(int i=1;i<3;i++) {
			driver.get(prop.getProperty("url"+i));
			hp.signinlink().click();
			log.info("clicked on signin link");
			GetData gd = new GetData();
			for(int j=1;j<5;j++) {
				gd.getExcelData(System.getProperty("user.dir")+"\\Resources\\TestData.xlsx", "Assignment2_SignIn", "Test Scenario", "Invalid_"+j+"");
				hp.uname().sendKeys(gd.a.get(1));
				log.info("entered username");
				hp.pwd().sendKeys(gd.a.get(2));
				log.info("entered password");
				hp.signinButton().click();
				log.info("clicked on signin button");
				hp.signinerror().isDisplayed();
				log.info("Error message displayed");
				hp.uname().clear();
				hp.pwd().clear();
			}	
		}
	}
	
	@Test
	public void forgot_pwd() throws IOException {
		
		Homepage hp = new Homepage(driver);
		for(int i=1;i<3;i++) {
			driver.get(prop.getProperty("url"+i));
			hp.signinlink().click();
			log.info("clicked on signin link");
			hp.forgotpwd().click();
			log.info("Need help in remembering password link clicked");
			GetData gd = new GetData();
			for(int j=1;j<3;j++) {
				gd.getExcelData(System.getProperty("user.dir")+"\\Resources\\TestData.xlsx", "Assignment2_FogotPassword", "Test Scenario", "uname_"+j);
				hp.forgot_uname().clear();
				hp.forgot_uname().sendKeys(gd.a.get(1));
				log.info("entered username");
				hp.nextButton().click();
				log.info("Clicked on next button");
				if(gd.a.get(2).equalsIgnoreCase("valid")) {
					hp.emailConfirmation().isDisplayed();
					log.info("Confirmation message displayed -> Password sent to mail id");
				}
				else {
					hp.emailConfirmationError().isDisplayed();
					log.info("Error message -> Email not registered");
				}
			}	
		}
	}
	
}
