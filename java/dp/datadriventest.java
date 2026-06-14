package dp;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datadriventest {

	ChromeDriver driver;
//	@DataProvider
//	public Object[][] dp() throws IOException {
//
//		datadriven dc =
//	        new datadriven("C:\\Users\\krgpo\\OneDrive\\Documents\\data2.xlsx");
//
//	    int totalrow = dc.rowcount(0);
//
//	    Object[][] data = new Object[totalrow][2];
//
//	    for(int i=0;i<totalrow;i++) {
//
//	        data[i][0] = dc.getdata(0, 1, 0);
//	        data[i][1] = dc.getdata(0, 1, 1);
//	    }
//
//	    return data;
//	}
//	



	@DataProvider
	public Object[][] dp() throws IOException {

		datadriven dc = new datadriven("C:\\Users\\2035\\Documents\\Auto\\data2.xlsx");

		int totalrow = dc.rowcount(0);
		// int totalcol = dc.columncount(0);

		Object[][] data = new Object[totalrow][4];

		for (int i = 0; i < totalrow; i++) {
			// for(int j=0;j<totalcol;j++){
			data[i][0] = dc.getdata(0, i, 0);
			data[i][1] = dc.getdata(0, i, 1);
			data[i][2] = dc.getdata(0, i, 2);
			data[i][3] = dc.getdata(0, i, 3);
		}
		return data;
	}
	// }

	@DataProvider
	public Object[][] dp1() throws IOException {

		datadriven dc = new datadriven("C:\\Users\\2035\\Documents\\Auto\\data2.xlsx");

		int totalrow = dc.rowcount(0);
		// int totalcol = dc.columncount(0);

		Object[][] data = new Object[totalrow][2];

		for (int i = 0; i < totalrow; i++) {
			// for(int j=0;j<totalcol;j++){

			data[i][0] = dc.getdata(0, i, 2);
			data[i][1] = dc.getdata(0, i, 3);
		}
		return data;
	}

	@BeforeMethod
	public void browser() {

		System.out.println("TEST EXECUTED");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

	}

	@Test(dataProvider = "dp")
	public void testcase(String a, String b, String c, String d) {

		driver.get("https://test.upexciseonline.co/");
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.xpath("//*[@formcontrolname='mail']"));
		username.sendKeys(a);

		WebElement pass = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
		pass.sendKeys(b);

		WebElement username1 = driver.findElement(By.xpath("//*[@formcontrolname='mail']"));
		username1.sendKeys(c);

		WebElement pass1 = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
		pass1.sendKeys(d);

	}

	@Test(dataProvider = "dp1")
	public void testcase1(String c, String d) {

		driver.get("https://test.upexciseonline.co/");
		driver.manage().window().maximize();

		WebElement username1 = driver.findElement(By.xpath("//*[@formcontrolname='mail']"));
		username1.sendKeys(c);

		WebElement pass1 = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
		pass1.sendKeys(d);

	}
}
