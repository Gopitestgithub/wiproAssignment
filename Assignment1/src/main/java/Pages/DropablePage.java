package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropablePage {

	WebDriver driver;
	
	By draggableitem = By.xpath("//div[@id='draggable']");
	By droplocation = By.xpath("//div[@id='droppable']");
	By droplocationtext = By.xpath("//div[@id='droppable']/p");
	
	public DropablePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement draggableitem() {
		return driver.findElement(draggableitem);
	}
	
	public WebElement droplocation() {
		return driver.findElement(droplocation);
	}
	
	public WebElement droplocationtext() {
		return driver.findElement(droplocationtext);
	}	
	
}
