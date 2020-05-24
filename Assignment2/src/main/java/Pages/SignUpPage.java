package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	WebDriver driver;
	WebDriverWait wait;
	
	By popup = By.xpath("//div/span[@class='close-icon event_button_click']");
	By cookieAccept = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	By emailIDfield = By.xpath("//div[@class='pc_txtfld pc_Email']/input");
	By password = By.xpath("//div[@class='pc_txtfld password']/input");
	By confirm_password = By.xpath("//div[@class='pc_txtfld pc_loginConfirmpasswrd']/input");
	By birthday = By.xpath("//select[@data-key='birthdate[dateselect_day]']");
	By birthmonth = By.xpath("//select[contains(@id,'[birthdate][month]')]");
	By birthyear = By.xpath("//select[contains(@id,'[birthdate][year]')]");
	By registerprofile = By.xpath("//div/input[@class='button-link button']");
	
	By gender = By.xpath("//li[@class='female']/a");
	By firstName = By.xpath("//input[@data-key='firstName']");
	By lastName = By.xpath("//input[@data-key='lastName']");
	By address = By.xpath("//input[@data-key='addressStreet1']");
	By city = By.xpath("//input[@data-key='addressCity']");
	By postcode = By.xpath("//input[@data-key='addressPostalCode']");
	By addToProfile = By.xpath("//input[@onclick='return ValidateClientClick();']");
	By land = By.xpath("//select[@data-key='addressCountry']");
	By registrationcomplete = By.xpath("//h1[@id='phdesktopbody_0_Header']");
	By error_Alreadyreg = By.xpath("//span[@id='phdesktopbody_0_ErrorMessage']");
	
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,50);
	}
	
	
	public WebElement popup() {		
		wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
		return driver.findElement(popup);
	}
	
	public WebElement cookieAccept() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAccept));
		return driver.findElement(cookieAccept);
	}
	
	public WebElement emailIDfield() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailIDfield));
		return driver.findElement(emailIDfield);
	}
	
	public WebElement password() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		return driver.findElement(password);
	}
	
	public WebElement confirm_password() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirm_password));
		return driver.findElement(confirm_password);
	}	
	
	public WebElement birthday() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(birthday));
		return driver.findElement(birthday);
	}
	
	public WebElement birthmonth() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(birthmonth));
		return driver.findElement(birthmonth);
	}
	
	public WebElement birthyear() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(birthyear));
		return driver.findElement(birthyear);
	}	
	
	public WebElement registerprofile() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(registerprofile));
		return driver.findElement(registerprofile);
	}
	
	public WebElement gender() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(gender));
		return driver.findElement(gender);
	}
	
	public WebElement firstName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		return driver.findElement(firstName);
	}
	
	public WebElement lastName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
		return driver.findElement(lastName);
	}
	
	public WebElement address() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(address));
		return driver.findElement(address);
	}	
	
	public WebElement city() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(city));
		return driver.findElement(city);
	}
	
	public WebElement postcode() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(postcode));
		return driver.findElement(postcode);
	}
	
	public WebElement addToProfile() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToProfile));
		return driver.findElement(addToProfile);
	}
	
	public WebElement land() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(land));
		return driver.findElement(land);
	}
	
	public WebElement registrationcomplete() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(registrationcomplete));
		return driver.findElement(registrationcomplete);
	}
	
	public WebElement error_Alreadyreg() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(error_Alreadyreg));
		return driver.findElement(error_Alreadyreg);
	}
	
}
