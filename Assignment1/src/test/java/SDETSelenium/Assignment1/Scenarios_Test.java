package SDETSelenium.Assignment1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.DatepickerPage;
import Pages.DropablePage;
import Pages.HTMLContactForm;
import Pages.RentalCarPage;
import Pages.SelectMenuPage;
import Pages.SelectablePage;
import Resources.DriverFactory;
import Resources.GetData;

public class Scenarios_Test extends DriverFactory {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser() throws IOException {
		this.driver = invokeBrowser();
	}
	
	@Test
	public void selectablePageNavigation() throws IOException {
		
		
		driver.get(prop.getProperty("url1"));
		SelectablePage sp = new SelectablePage(driver);
		
		for(int i=1;i<8;i++) {
			sp.itemName(i).click();
			log.info(sp.itemName(i).getText());
		}
	}
	
	@Test
	public void htmlContactFormNavigation() throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("url2"));
		HTMLContactForm hp = new HTMLContactForm(driver);
		GetData gd = new GetData();
		gd.getExcelData(System.getProperty("user.dir")+prop.getProperty("Test_data_Excel1"), "Assignment1_TC2", "Test Scenario", "html contact form");
		log.info("Extracting the details from the excel and entering in the required field");
		hp.firstName().sendKeys(gd.a.get(1));
		hp.lastName().sendKeys(gd.a.get(2));
		hp.country().sendKeys(gd.a.get(3));
		hp.subject().sendKeys(gd.a.get(4));
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		log.info("Entered the values from the excel");
		hp.googleLink().sendKeys(selectLinkOpeninNewTab);
		log.info("Opened google link in the new tab");
		hp.googleLinkishere().sendKeys(selectLinkOpeninNewTab);
		log.info("Opened google link is here in the new tab");
		hp.submit().click();
		log.info("Clicked on submit button");
		gd.a.clear();

	}
	
	@Test
	public void dropable() throws IOException {
		
		driver.get(prop.getProperty("url3"));
		DropablePage dp = new DropablePage(driver);
		Actions a = new Actions(driver);
		a.dragAndDrop(dp.draggableitem(), dp.droplocation()).build().perform();
		log.info("Drag and Dropped the item");
		dp.droplocationtext().equals("Dropped!");
		log.info("Verified the text");
	}
	
	@Test
	public void datepick() throws IOException {
		
		driver.get(prop.getProperty("url4"));
		DatepickerPage dtp = new DatepickerPage(driver);
		dtp.selectdate().click();
		dtp.selectcurrentdate().click();
		dtp.selectdate().clear();
		dtp.selectdate().sendKeys(prop.getProperty("DOB"));
		log.info("Entered Date Of Birth");
		dtp.selectdate().sendKeys(Keys.TAB);

	}
	
	@Test
	public void selectMenu() throws IOException {

		driver.get(prop.getProperty("url5"));
		SelectMenuPage sm = new SelectMenuPage(driver);
		GetData gd = new GetData();
		gd.getExcelData(System.getProperty("user.dir")+prop.getProperty("Test_data_Excel1"), "Assignment1_TC5", "Test Scenario", "Select Menu");
		log.info("Extracting the details from the excel and entering in the required field");
		sm.getspeed().click();
		sm.getspeed1().sendKeys(gd.a.get(1)+Keys.ENTER);
		sm.getfile().click();
		sm.getfile1().sendKeys(gd.a.get(2)+Keys.ENTER);
		sm.getnumber().click();
		sm.getnumber1().sendKeys(gd.a.get(3)+Keys.ENTER);
		sm.gettitle().click();
		sm.gettitle1().sendKeys(gd.a.get(4)+Keys.ENTER);
		log.info("Entered the details from the excel");
		gd.a.clear();
		
	}
	
	@Test
	public void RentalCar() throws IOException, InterruptedException {

		driver.get(prop.getProperty("url6"));
		RentalCarPage rc = new RentalCarPage(driver);
		GetData gd = new GetData();
		gd.getExcelData(System.getProperty("user.dir")+prop.getProperty("Test_data_Excel1"), "Assignment1_TC6", "Test Scenario", "Rental Car");
		log.info("Extracting the details from the excel and entering in the required field");
		rc.cartype().click();
		rc.cartype1().sendKeys(gd.a.get(1)+Keys.ENTER);
		if(gd.a.get(2).equalsIgnoreCase("Standard")) {
			rc.Mode_Standard().click();
		}
		else if(gd.a.get(2).equalsIgnoreCase("Automatic")) {
			rc.Mode_Automatic().click();
		}
		if(gd.a.get(3).equals("Yes")) {
			rc.insurance().click();
		}
		rc.number().sendKeys(gd.a.get(4));
		
		rc.car1type().click();
		rc.car1type1().sendKeys(gd.a.get(1)+Keys.ENTER);
		if(gd.a.get(2).equalsIgnoreCase("Standard")) {
			rc.Mode1_Standard().click();
		}
		else if(gd.a.get(2).equalsIgnoreCase("Automatic")) {
			rc.Mode1_Automatic().click();
		}
		if(gd.a.get(3).equals("Yes")) {
			rc.insurance1().click();
		}
		rc.number1().sendKeys(gd.a.get(4));		
		log.info("Entered the details from the excel");
		Thread.sleep(5000);
		gd.a.clear();
		
	}	
}
