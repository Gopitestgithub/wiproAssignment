package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


public class DriverFactory {

	public static Logger log = LogManager.getLogger(DriverFactory.class.getName());
	public WebDriver driver;
	public static Properties prop;
	WebDriverWait Wait;

	public WebDriver invokeBrowser() throws IOException{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\BasicData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
			driver = new ChromeDriver(options);
			log.info("Driver is initialized");
			log.info("Launching Chrome browser");
		}
		
		else if(browserName.equalsIgnoreCase("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Driver is initialized");
			log.info("Launching Firefox browser");
		}
		else {
			log.info("Browser name entered is invalid. Enter a valid browser name");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public String Takescreenshot(String tcname, WebDriver drive) throws IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));
		TakesScreenshot ts = (TakesScreenshot) drive;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"\\reports\\"+tcname+"_"+dtf.format(now)+".png";
		FileUtils.copyFile(src, new File(dest)); 
		log.info("Screenshot available in 'reports' folder");
		
		return dest;
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		log.info("Closing browser");
	}
	
}
