package SDETSelenium.Assignment3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BookingPage;
import pages.Homepage;
import resources.DriverFactory;
import resources.GetData;

public class MakeMyTrip_Test extends DriverFactory{

	
	public WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser() throws IOException {
		this.driver = invokeBrowser();
	}
	
	@Test
	public void flightBooking() throws InterruptedException, IOException, ParseException {
		
		Homepage hp = new Homepage(driver);
		GetData gd = new GetData();
		BookingPage bp = new BookingPage(driver);
		
		driver.get(prop.getProperty("url"));
		log.info("Launched url: "+prop.getProperty("url"));
		
		switch(prop.getProperty("Trip")){
			case "OneWay Trip":
				gd.getExcelData(prop.getProperty("TestData"), prop.getProperty("SheetName"), prop.getProperty("TestName"), prop.getProperty("TCName"));
				hp.oneWayTrip().click();
				log.info("Oneway Trip");
				break;
			case "Round Trip":
				gd.getExcelData(prop.getProperty("TestData"), prop.getProperty("SheetName"), prop.getProperty("TestName"), prop.getProperty("TCName1"));
				hp.roundTrip().click();
				log.info("Round Trip");
				break;
			case "MultiCity Trip":
				hp.multicityTrip().click();
				log.info("Multicity Trip");
				break;
		}
		
		hp.fromLocation().click();
		log.info("Clicked on From location");
		hp.EnterfromLocation().sendKeys(gd.a.get(2));
		log.info("Entered first 3 letters of the from city");
		Thread.sleep(4000);
		log.info("Searching for the required city name from the suggestion");
		for(int i=0;i<hp.LocationOption().size();i++) {
			if(hp.LocationOption().get(i).getText().contains(gd.a.get(3))) {
				hp.LocationOption().get(i).click();
				log.info("selected the required city from the suggestion");
				break;
			}
			
		}
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", hp.toLocation());
		Boolean isPresent = hp.fromToErrormsg().size() >0;
		if(isPresent) {
			hp.toLocation().click();
		}
		log.info("Clicked on To location");
		hp.EnterToLocation().sendKeys(gd.a.get(4));
		log.info("Entered first 3 letters of the To city");
		Thread.sleep(4000);
		log.info("Searching for the required city name from the suggestion");
		for(int i=0;i<hp.LocationOption().size();i++) {
			if(hp.LocationOption().get(i).getText().contains(gd.a.get(5))) {
				hp.LocationOption().get(i).click();
				log.info("selected the required city from the suggestion");
				break;
			}	
		}
		Date dt1=new SimpleDateFormat("MM/dd/yy").parse(gd.a.get(6));  
		SimpleDateFormat  formatter = new SimpleDateFormat ("MMMM yyyy-dd");
		SimpleDateFormat  formatter1 = new SimpleDateFormat ("E, dd MMM yy");
		String dt2 = formatter.format(dt1);
		String [] date = dt2.split("-");
		if(gd.a.get(1).equalsIgnoreCase("Round Trip")) {
			date[0] =date[0].replaceAll("\\s","");
		}
		dateSelection(date[0], date[1]);
		
		if(gd.a.get(1).equalsIgnoreCase("Round Trip")) {
			Date Return_dt1=new SimpleDateFormat("MM/dd/yy").parse(gd.a.get(7));  
			String Return_dt2 = formatter.format(Return_dt1);
			String [] Return_date = Return_dt2.split("-");
			Return_date[0]= Return_date[0].replaceAll("\\s","");
			dateSelection(Return_date[0], Return_date[1]);
		}
		hp.searchButton().click();
		log.info("clicked on search button");
		
		if(gd.a.get(1).equalsIgnoreCase("Round Trip")) {
			bp.Return_priceSort().get(0).isDisplayed();
			bp.Return_priceSort().get(1).isDisplayed();
			log.info("Cheapest fare displayed");
			bp.bookNow().click();
			bp.Return_continueBtn().click();
		}
		else {
			bp.label_sort().isDisplayed();
			log.info("Itinery page is displayed");
			bp.price_sort().isDisplayed();
			log.info("Cheapest fare displayed");
			bp.viewFare().click();
			log.info("clicked on the view fare");
			bp.bookNow().click();
		}
		
		String winHandleBefore = driver.getWindowHandle();
	
		log.info("clicked on the Book now");
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    log.info("switched to new window");
		}
		bp.reviewPage().isDisplayed();
		log.info("Review page is displayed");
		bp.deptCity().getText().equalsIgnoreCase(gd.a.get(3));
		log.info("Dept city verified");
		bp.arrivalCity().getText().equalsIgnoreCase(gd.a.get(5));
		log.info("Arrival city verified");
		String reviewDate = bp.deptDate().getText();
		String orgDate = formatter1.format(dt1);
		assertEquals(reviewDate, orgDate);
		log.info("Departure date verified");
	}

	public void dateSelection(String mon, String date) {
		
		Homepage hp = new Homepage(driver);

		while(!(hp.calendarMonth().get(0)).getText().equalsIgnoreCase(mon)) {
			hp.calendarNext().click();
		}
		int i=0;
		while(!hp.calendarDate().get(i).getText().equalsIgnoreCase(date)) {
			i++;
		}
		hp.calendarDate().get(i).click();
		log.info("selected the date");

	}
}
