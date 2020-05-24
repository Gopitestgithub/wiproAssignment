package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage {

	WebDriver driver;
	WebDriverWait wait;
	
	By label_sort = By.xpath("//span[contains(text(),'Sorted By:')]");
	By price_sort = By.xpath("//span/span[contains(text(),'Price')]/following-sibling::span[contains(@class,'down')]");
	By Return_priceSort = By.xpath("//button/span/span[contains(text(),'Price')]");
	By viewFare = By.xpath("(//button[contains(@class,'ViewFareBtn')])[1]");
	By bookNow = By.xpath("(//button[contains(text(),'Book Now')])[1]");
	By Return_continueBtn = By.xpath("//button[contains(text(),'Continue')]");
	By reviewPage = By.xpath("//h4[contains(text(),'Review your booking')]");
	By deptCity = By.xpath("//p[@class='dept-city']/span");
	By arrivalCity = By.xpath("//p[@class='arrival-city']/span");
	By deptDate = By.xpath("(//div/div[@class='fli-time-section pull-left']/p)[1]");
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	
	public WebElement label_sort() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(label_sort));
		return driver.findElement(label_sort);
	}
	
	public WebElement price_sort() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(price_sort));
		return driver.findElement(price_sort);
	}
	
	public List<WebElement> Return_priceSort() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Return_priceSort));
		return driver.findElements(Return_priceSort);
	}
	
	public WebElement viewFare() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewFare));
		return driver.findElement(viewFare);
	}
	
	public WebElement bookNow() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(bookNow));
		return driver.findElement(bookNow);
	}
	
	public WebElement reviewPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(reviewPage));
		return driver.findElement(reviewPage);
	}
	
	public WebElement deptCity() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(deptCity));
		return driver.findElement(deptCity);
	}
	
	public WebElement arrivalCity() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(arrivalCity));
		return driver.findElement(arrivalCity);
	}
	
	public WebElement deptDate() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(deptDate));
		return driver.findElement(deptDate);
	}
	
	public WebElement Return_continueBtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Return_continueBtn));
		return driver.findElement(Return_continueBtn);
	}
}
