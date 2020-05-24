package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectMenuPage {

	WebDriver driver;
	
	By speed = By.xpath("//span[@id='speed-button']/span[2]");
	By speed1 = By.xpath("//*[@id='speed-menu']");
	
	By file = By.xpath("//span[@id='files-button']/span[2]");
	By file1 = By.xpath("//*[@id='files-menu']");

	By number = By.xpath("//span[@id='number-button']/span[2]");
	By number1 = By.xpath("//*[@id='number-menu']");
	
	By title = By.xpath("//span[@id='salutation-button']/span[2]");
	By title1 = By.xpath("//*[@id='salutation-menu']");	
	
	public SelectMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getspeed() {
		return driver.findElement(speed);
	}
	
	public WebElement getfile() {
		return driver.findElement(file);
	}
	
	public WebElement getnumber() {
		return driver.findElement(number);
	}
	
	public WebElement gettitle() {
		return driver.findElement(title);
	}
	
	public WebElement getspeed1() {
		return driver.findElement(speed1);
	}
	
	public WebElement getfile1() {
		return driver.findElement(file1);
	}
	
	public WebElement getnumber1() {
		return driver.findElement(number1);
	}
	
	public WebElement gettitle1() {
		return driver.findElement(title1);
	}
}
