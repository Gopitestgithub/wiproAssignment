package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	WebDriver driver;
	WebDriverWait wait;
	
	By oneWayTrip = By.xpath("//div/ul/li[@data-cy='oneWayTrip']");
	By roundTrip = By.xpath("//div/ul/li[@data-cy='roundTrip']");
	By multicityTrip = By.xpath("//div/ul/li[@data-cy='mulitiCityTrip']");
	By fromLocation = By.xpath("//label/input[@id='fromCity']");
	By EnterfromLocation = By.xpath("//div/input[@placeholder='From']");
	By LocationOption = By.xpath("//ul/li[@role='option']//div/p[1]");
	By toLocation = By.xpath("//div/label/input[@id='toCity'][@data-cy='toCity']");
	By fromToErrormsg = By.xpath("//div[@id='errorMessage']");
	By EnterToLocation = By.xpath("//div/input[@placeholder='To']");
	By calendarMonth = By.xpath("//div[@class='DayPicker-Month']/div[1]/div");
	By calendarDate = By.xpath("//div[contains(@class,'DayPicker-Day')] /div[1]/p");
	By calendarNext = By.xpath("//div/span[@aria-label='Next Month']");
	By searchButton = By.xpath("//p/a[contains(text(),'Search')]");
	
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	
	public WebElement fromLocation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(fromLocation));
		return driver.findElement(fromLocation);
	}
	
	public WebElement EnterfromLocation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EnterfromLocation));
		return driver.findElement(EnterfromLocation);
	}
	
	public List<WebElement> LocationOption() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(LocationOption));
		return driver.findElements(LocationOption);
	}
	
	public WebElement toLocation() {
		wait.until(ExpectedConditions.elementToBeClickable(toLocation));
		return driver.findElement(toLocation);
	}
	
	public WebElement EnterToLocation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EnterToLocation));
		return driver.findElement(EnterToLocation);
	}
	
	public WebElement oneWayTrip() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(oneWayTrip));
		return driver.findElement(oneWayTrip);
	}
	
	public WebElement roundTrip() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(roundTrip));
		return driver.findElement(roundTrip);
	}
	
	public WebElement multicityTrip() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(multicityTrip));
		return driver.findElement(multicityTrip);
	}
	
	public List<WebElement> calendarMonth() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(calendarMonth));
		return driver.findElements(calendarMonth);
	}
	
	public List<WebElement> calendarDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(calendarDate));
		return driver.findElements(calendarDate);
	}
	
	public WebElement calendarNext() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(calendarNext));
		return driver.findElement(calendarNext);
	}
	
	public WebElement searchButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
		return driver.findElement(searchButton);
	}
	
	public List<WebElement> fromToErrormsg() {
//		wait.until(ExpectedConditions.(fromToErrormsg));
		return driver.findElements(fromToErrormsg);
	}
}
