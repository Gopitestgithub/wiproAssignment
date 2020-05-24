package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HTMLContactForm {

	WebDriver driver;
	
	By firstname = By.xpath("//form/input[@class='firstname']");
	By lastname = By.xpath("//form/input[@id='lname']");
	By country = By.xpath("//form/input[@name='country']");
	By subject = By.xpath("//form/textarea[@id='subject']");
	By submit = By.cssSelector("input[type='submit']");
	By googlelink = By.partialLinkText("Google Link");
	By googlelinkishere = By.partialLinkText("Google Link is here");
	
	public HTMLContactForm(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement firstName() {
		return driver.findElement(firstname);
	}
	
	public WebElement lastName() {
		return driver.findElement(lastname);
	}
	
	public WebElement country() {
		return driver.findElement(country);
	}
	
	public WebElement subject() {
		return driver.findElement(subject);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	public WebElement googleLink() {
		return driver.findElement(googlelink);
	}
	
	public WebElement googleLinkishere() {
		return driver.findElement(googlelinkishere);
	}
	
}
