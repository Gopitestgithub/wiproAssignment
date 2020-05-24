package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentalCarPage {


	WebDriver driver;
	
	By cartype = By.xpath("//span[@id='car-type-button']/span[2]");
	By cartype1 = By.xpath("//*[@id='car-type-menu']");
	By Mode_Standard = By.xpath("//label[@for='transmission-standard']/span[1]");
	By Mode_Automatic = By.xpath("//label[@for='transmission-automatic']/span[1]");
	By insurance = By.xpath("//label[@for='insurance']/span[1]");
	By number = By.xpath("//input[@id='horizontal-spinner']");
	By booknow = By.xpath("(//button[contains(text(),'Book Now!')])[1]");
	
	By car1type = By.xpath("//span[@id='ui-id-8-button']/span[2]");
	By car1type1 = By.xpath("//*[@id='ui-id-8-menu']");
	By Mode1_Standard = By.xpath("//label[@for='transmission-standard-v']/span[1]");
	By Mode1_Automatic = By.xpath("//label[@for='transmission-automatic-v']/span[1]");
	By insurance1 = By.xpath("//label[@for='insurance-v']/span[1]");
	By number1 = By.xpath("//input[@id='vertical-spinner']");
	By booknow1 = By.xpath("(//button[contains(text(),'Book Now!')])[2]");
	
	public RentalCarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement cartype() {
		return driver.findElement(cartype);
	}
	
	public WebElement cartype1() {
		return driver.findElement(cartype1);
	}
	
	public WebElement Mode_Standard() {
		return driver.findElement(Mode_Standard);
	}
	
	public WebElement Mode_Automatic() {
		return driver.findElement(Mode_Automatic);
	}
	
	public WebElement insurance() {
		return driver.findElement(insurance);
	}
	
	public WebElement number() {
		return driver.findElement(number);
	}
	
	public WebElement booknow() {
		return driver.findElement(booknow);
	}
	
	public WebElement car1type() {
		return driver.findElement(car1type);
	}
	
	public WebElement car1type1() {
		return driver.findElement(car1type1);
	}
	
	public WebElement Mode1_Standard() {
		return driver.findElement(Mode1_Standard);
	}
	
	public WebElement Mode1_Automatic() {
		return driver.findElement(Mode1_Automatic);
	}
	
	public WebElement insurance1() {
		return driver.findElement(insurance1);
	}
	
	public WebElement number1() {
		return driver.findElement(number1);
	}
	
	public WebElement booknow1() {
		return driver.findElement(booknow1);
	}
	
}
