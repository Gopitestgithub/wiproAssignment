package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	WebDriver driver;
	WebDriverWait wait;
	
	By register = By.xpath("(//a[@class='event_profile_register'])[1]");
	By countryPopup = By.xpath("//div[@class='close country-close']");
	By signinlink = By.xpath("(//a[@class='event_profile_login'])[1]");
	By uname = By.xpath("//div/input[@name='phdesktopbody_0$phdesktopbody_0_username']");
	By pwd = By.xpath("//div/input[@name='phdesktopbody_0$phdesktopbody_0_password']");
	By signinButton = By.xpath("//div/input[@onclick='return formSubmit();']");
	By landingPage = By.xpath("//h1[contains(@id,'TitleText')]");
	By profileUname = By.xpath("//div[@class='pc_txtfld pc_Email']/span[2]");
	By signinerror = By.xpath("//span[@id='phdesktopbody_0_Message']");
	By forgotpwd = By.xpath("//div/a[contains(@id,'forgotpassword')]");
	By forgot_uname = By.xpath("//input[contains(@id,'username')]");
	By emailConfirmation = By.xpath("//div[contains(@id,'afterSubmit')]");
	By emailConfirmationError = By.xpath("//span[contains(@id,'ErrorMessage')]");
	By nextButton = By.xpath("//input[@onclick='return formSubmit();']");
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,50);
	}
	
	public WebElement registerlink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(register));
		return driver.findElement(register);
	}
	
	public List<WebElement> countryPopup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(countryPopup));
		return driver.findElements(countryPopup);
	}
	
	public WebElement signinlink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signinlink));
		return driver.findElement(signinlink);
	}
	
	public WebElement uname() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(uname));
		return driver.findElement(uname);
	}
	
	public WebElement pwd() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(pwd));
		return driver.findElement(pwd);
	}
	
	public WebElement signinButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signinButton));
		return driver.findElement(signinButton);
	}
	public WebElement landingPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(landingPage));
		return driver.findElement(landingPage);
	}
	
	public WebElement profileUname() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(profileUname));
		return driver.findElement(profileUname);
	}
	
	public WebElement signinerror() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signinerror));
		return driver.findElement(signinerror);
	}
	
	public WebElement forgotpwd() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotpwd));
		return driver.findElement(forgotpwd);
	}
	
	public WebElement forgot_uname() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgot_uname));
		return driver.findElement(forgot_uname);
	}
	
	public WebElement emailConfirmation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailConfirmation));
		return driver.findElement(emailConfirmation);
	}
	
	public WebElement emailConfirmationError() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailConfirmationError));
		return driver.findElement(emailConfirmationError);
	}
	
	public WebElement nextButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
		return driver.findElement(nextButton);
	}
}
