package sample;

import java.time.Duration;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import Pom_class.clsspom;

public class clss {
	
	public static Logger log = Logger.getLogger(clss.class);
	
	
	ChromeDriver driver;
	
@Test
	public  void login() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		PropertyConfigurator.configure("log4j.properties");
		log.info("browser");
		
		driver.get("https://test.upexciseonline.co/");
		driver.manage().window().maximize();
		
		log.info("url ");
		
		PageFactory.initElements(driver, clsspom.class);
		
		clsspom.username.sendKeys("test1711");
		clsspom.pass.sendKeys("Test@123");
		String captcha = JOptionPane.showInputDialog("Enter Captcha");
		clsspom.captchafield.sendKeys(captcha);
		clsspom.loginbutton.click();
		
		
		
//		WebElement username  = driver.findElement(By.xpath("//*[@formcontrolname='mail']"));
//		username.sendKeys("test1711");
//
//		WebElement pass  = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
//		pass.sendKeys("Test@123");
//
//		String captcha = JOptionPane.showInputDialog("Enter Captcha");
//		WebElement captchafield = driver.findElement(By.xpath("//input[@formcontrolname='captchatext']"));
//		captchafield.sendKeys(captcha);
//
//		WebElement loginbutt  = driver.findElement(By.xpath("//input[@formcontrolname='captchatext']"
//				+ "/following::*[contains(text(),'Login')]"));
//		loginbutt.click();


	}

	public void license_menu() throws InterruptedException {


		//Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement license_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'License Management ')]")));

		license_menu.click();

		WebElement Applynew_license_menu = driver.findElement(By.xpath("//*[contains(text(),'Apply New License ')]"));
		Applynew_license_menu.click();

	}

	public void eventbr() {

		WebElement eventbar = driver.findElement(By.xpath("//*[text()='Eventbar']"));

		Actions actions = new Actions(driver);
		actions.scrollToElement(eventbar).build().perform();


		JavascriptExecutor js = (JavascriptExecutor) driver;
		//
		//		js.executeScript("arguments[0].scrollIntoView(true);", eventbar);
		eventbar.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement individual_newlicense = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Individual Event At Residence (Category 1)']"
				+ "/following::button[text()=' New License '][1]")));

		//		= driver.findElement(By.xpath("//*[text()='Individual Event At Residence (Category 1)']"
		//				+ "/following::button[text()=' New License '][1]"));
		individual_newlicense.click();

		WebElement eventbar_calendar = driver.findElement(By.xpath("//*[text()='Event Details']"));

		js.executeScript("arguments[0].scrollIntoView(true);", eventbar_calendar);
		
		WebElement eventbar_fromdate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@formcontrolname='eventFromDate']")));
		
		//WebElement eventbar_fromdate = driver.findElement(By.xpath("//*[@formcontrolname='eventFromDate']"));
		eventbar_fromdate.click();
		
          WebElement fromdate = driver.findElement(By.xpath("//button[@aria-label='Choose month and year']"));
          fromdate.click();
          
          WebElement fromdate_year = driver.findElement(By.xpath("//td/following::*[text()='2027']"));
          fromdate_year.click();
          
          WebElement fromdate_month = driver.findElement(By.xpath("//td/following::*[text()='Feb']"));
          fromdate_month.click();
          
          WebElement fromdate_date = driver.findElement(By.xpath("//td/following::*[text()='3'][1]"));
          fromdate_date.click();
          
          
       
	}




	public static void main(String[] args) throws InterruptedException {

		clss one = new clss ();
		one.login();
		one.license_menu();
		one.eventbr();

	}

	
	
	
}
