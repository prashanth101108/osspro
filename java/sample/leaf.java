package sample;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class leaf {


	ChromeDriver driver;

@BeforeMethod
	public void login() {

		driver = new ChromeDriver();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();

	}



@Test
	public void alert() throws InterruptedException {


		WebElement browser = driver.findElement(By.xpath("//*[text()='Browser']/parent::*"));
		browser.click();

		WebElement browser_alert = driver.findElement(By.xpath("//*[text()='Alert']/parent::*"));
		browser_alert.click();

		WebElement browser_alert_simpledialog = driver.findElement(By.xpath("//*[text()=' Alert (Confirm Dialog)']/preceding::*[text()='Show']"));
		browser_alert_simpledialog.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		WebElement browser_alert_confirmdialog = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
		browser_alert_confirmdialog.click();

		alert.dismiss();

		WebElement browser_alert_sweetalert = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']"));
		browser_alert_sweetalert.click();

		WebElement browser_alert_sweetalert_dismiss = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
		browser_alert_sweetalert_dismiss.click();

		WebElement browser_alert_sweetmodal = driver.findElement(By.id("j_idt88:j_idt100"));
		browser_alert_sweetmodal.click();

		Thread.sleep(500);
		WebElement browser_alert_sweetmodal_close = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']"
				+ "/following::span[@class='ui-icon ui-icon-closethick']"));
		browser_alert_sweetmodal_close.click();

		WebElement alert_prompt_dialog = driver.findElement(By.id("j_idt88:j_idt104"));
		alert_prompt_dialog.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());

		alert1.sendKeys("yes");
		alert1.accept();


	}

@Test
	public void frame() {

		WebElement browser = driver.findElement(By.xpath("//*[text()='Browser']/parent::*"));
		browser.click();

		WebElement browser_frame = driver.findElement(By.xpath("//*[@id='menuform:m_frame']"));
		browser_frame.click();

		driver.switchTo().frame(0);

		WebElement browser_frame1 = driver.findElement(By.xpath("//button[@id='Click']"));
		browser_frame1.click();

		driver.switchTo().defaultContent();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int a = frames.size();
		System.out.println(a);

		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");

		WebElement browser_frame3 = driver.findElement(By.xpath("//button[@id='Click']"));
		browser_frame3.click();


	}


	public void window() {

		//		WebElement browser = driver.findElement(By.xpath("//*[text()='Browser']/parent::*"));
		//		browser.click();
		//		
		//		WebElement browser_window = driver.findElement(By.xpath("//*[text()='Window']/parent::a"));
		//		browser_window.click();
		//		
		//		WebElement click_confirm = driver.findElement(By.xpath("//*[@id='j_idt88:new']"));
		//		click_confirm.click();
		//		
		//		String parent_window = driver.getWindowHandle();
		//		
		//		Set<String> new_window = driver.getWindowHandles();
		//		
		//		for(String current : new_window) {
		//			
		//			driver.switchTo().window(current);
		//			
		//			WebElement browser1 = driver.findElement(By.xpath("//*[text()='Browser']/parent::*"));
		//			browser1.click();
		//		
		//		}
		//		
		//		WebElement browser = driver.findElement(By.xpath("//*[text()='Browser']/parent::*"));
		//         browser.click();
		//		
		//         WebElement browser_window = driver.findElement(By.xpath("//*[text()='Window']/parent::a"));
		//      	browser_window.click();
		//         
		//		WebElement multi_window = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']"));
		//		multi_window.click();
		//		
		//		Set<String> window_list = driver.getWindowHandles();
		//		
		//		for(String newwindow :window_list) {
		//			
		//			driver.switchTo().window(newwindow);
		//			
		//			String newwindtitle = driver.getCurrentUrl();
		//			
		//			System.out.println(newwindtitle);
		//			
		//			if(newwindtitle.equals("https://www.leafground.com/table.xhtml")) {
		//				
		//				WebElement serach = driver.findElement(By.xpath("//*[@id='form:j_idt89:globalFilter']"));
		//				serach.sendKeys("test");
		//				//driver.close();                             
		//					
		//			}else if (newwindtitle.equals("https://www.leafground.com/dashboard.xhtml")) {
		//				
		//				WebElement serach1 = driver.findElement(By.xpath("//*[@type='text']"));
		//				serach1.sendKeys("test1");
		//				//driver.close();
		//				
		//			}
		//			
		//		}

		//		WebElement browser4 = driver.findElement(By.xpath("//*[text()='Browser']/parent::*"));
		//        browser4.click();
		//		
		//        WebElement browser_window4 = driver.findElement(By.xpath("//*[text()='Window']/parent::a"));
		//     	browser_window4.click();
		//		
		//     	String parentwind = driver.getWindowHandle();
		//     	
		//		WebElement closewind = driver.findElement(By.id("j_idt88:j_idt93"));
		//		closewind.click();
		//		
		//		Set<String> newwin = driver.getWindowHandles();
		//     	
		//		for(String curnt :newwin ) {
		//			
		//			driver.switchTo().window(curnt);
		//			
		//			if(!curnt.equals(parentwind)) {
		//				
		//				driver.close();
		//				
		//			}
		//			
		//			
		//		}

		WebElement browser5 = driver.findElement(By.xpath("//*[text()='Browser']/parent::*"));
		browser5.click();

		WebElement browser_window5 = driver.findElement(By.xpath("//*[text()='Window']/parent::a"));
		browser_window5.click();

		String parentwind = driver.getWindowHandle();

		WebElement browser_windwait = driver.findElement(By.id("j_idt88:j_idt95"));
		browser_windwait.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));

		Set<String> windlist = driver.getWindowHandles();

		for(String newwind : windlist ) {

			if (!parentwind.equals(newwind)) {

				driver.switchTo().window(newwind);
				driver.close();

			}

		}


	}


	public void table() {


		WebElement table = driver.findElement(By.xpath("(//*[text()='Table'])[1]/parent::a"));
		table.click();

		WebElement table1 = driver.findElement(By.xpath("(//*[text()='Table'])[3]/parent::a"));
		table1.click();


//		List<WebElement> names = driver.findElements(By.xpath("//th[@id='form:j_idt89:j_idt92']/following::td"));
//		int name_size = names.size();
//		String first_name = names.get(0).getText();
//
//		System.out.println(name_size+first_name);
//
//
//		List<WebElement> names_tr = driver.findElements(By.xpath("(//table[@role='grid'])[2]/child::tbody/child::tr"));
//		names_tr.size();
//		
//		for (WebElement value :names_tr ) {
//			
//		System.out.println(value.getText());	
//		}

		WebElement table_data = driver.findElement(By.xpath("//tbody[@id='form:j_idt89_data']/child::tr[@data-ri='0']/td[1]"));
		String td = table_data.getText();
		System.out.println(td);

	}





	public static void main(String[] args) throws InterruptedException {

		leaf l = new leaf();
		l.login();
		//l.alert();		
		//l.frame();
		//l.window();
		l.table();



	}

}
