package Pom_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class clsspom {
	
	@FindBy (xpath= "//*[@formcontrolname='mail']")
	public static WebElement username;
	
	@FindBy (xpath="//*[@formcontrolname='password']")
	public static WebElement pass;
	@FindBy (xpath = "//input[@formcontrolname='captchatext']")
	public static WebElement captchafield;
	
	@FindBy(xpath="//input[@formcontrolname='captchatext']/following::*[contains(text(),'Login')]")
	public static WebElement loginbutton;
	
	
//	WebElement username = driver.findElement(By.xpath("//*[@formcontrolname='mail']"));
//	username.sendKeys("test1711");
//
//	WebElement pass = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
//	pass.sendKeys("Test@123");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
