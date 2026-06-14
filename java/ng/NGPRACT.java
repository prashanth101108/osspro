package ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonpack.commonclss;



public class NGPRACT extends commonclss{

//	@Test(priority=-1)
//	@Parameters({"para","para2"})
//	public void method_a(String para, String para2) {
//
//		boolean name = false;
//		
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertFalse(name, para2);
//		
//		System.out.println("aa" + " " + para +" "+ para2);
//		
//		softAssert.assertAll();
//	}

	
	
	@BeforeMethod
	public void method_ee() {

		System.out.println("eeeeeee");
	}

	@AfterTest
	public void method_f() {

		System.out.println("fffff");
	}

	@Test
	public void method_d() {

		
		
		WebElement username  = driver.findElement(By.xpath("//*[@formcontrolname='mail']"));
		username.sendKeys("test1711");

		WebElement pass  = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
		pass.sendKeys("Test@123");

		WebElement loginbutt  = driver.findElement(By.xpath("/input[@formcontrolname='captchatext']"
				+ "/following::*[contains(text(),'Login')]"));
		loginbutt.click();
	
		System.out.println("dddd");
		
	}
    
	@Test
	public void method_d2() {

		System.out.println("dddd2222222");
	}
	
	
	
	@AfterClass
	public void method_dd() {

		System.out.println("ddddddddddddddd");
	}
	
	
    @BeforeClass
	public void zzzz() {

    	
    	ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://test.upexciseonline.co/");
		driver.manage().window().maximize();
    	
		System.out.println("zzzzzz");
	}

}
