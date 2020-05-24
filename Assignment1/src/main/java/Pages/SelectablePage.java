package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectablePage {

	WebDriver driver;
	
	public SelectablePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement itemName(int i) {

		By itemNames = By.xpath("//ol[@id='selectable']/li["+i+"]");
		return driver.findElement(itemNames);
	}
}
