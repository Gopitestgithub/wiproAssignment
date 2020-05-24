package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatepickerPage {

	WebDriver driver;
	
	By date = By.xpath("//input[@id='datepicker']");
	By currentdate = By.xpath("//tr/td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']");
	
	public DatepickerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement selectdate() {
		return driver.findElement(date);
	}
	
	public WebElement selectcurrentdate() {
		return driver.findElement(currentdate);
	}
}
