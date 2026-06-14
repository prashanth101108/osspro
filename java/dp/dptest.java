package dp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dptest {
	
	ChromeDriver driver;
	
	
//@DataProvider(name="provider")
//	public Object[][] getdata() {
//	        Object[][]data = {
//	                {"admin", "admin123"},
//	                {"user1", "pass1"},
//	                {"user2", "pass2"}
//	        };
//	 return data;
//	        
//	}   
	
@Test(dataProvider = "provider",dataProviderClass = dpclass.class)
	public void testcase(String a,String b) {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get("https://test.upexciseonline.co/");
		driver.manage().window().maximize();

		WebElement username  = driver.findElement(By.xpath("//*[@formcontrolname='mail']"));
		username.sendKeys(a);

		WebElement pass  = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
		pass.sendKeys(b);

		
		
		
		
	}
	

}
