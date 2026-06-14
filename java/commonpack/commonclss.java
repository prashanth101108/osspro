package commonpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class commonclss {
	
	Properties pro;
	public static WebDriver driver;
	
	public  Properties propt() throws IOException {
		
		File fi = new File("config.properties");
		FileInputStream f = new FileInputStream(fi);
		pro = new Properties();
		pro.load(f);
		return pro;	
	}
	
	
	public void launch() throws IOException {
		
		propt();
		
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url");		
		
		System.out.println(browser + url);
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();	
			
			System.out.println(browser);
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		}
		driver.get(url);
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		commonclss c = new commonclss();
		c.launch();
	}
	
	
	
	
	
	
	
	

}
