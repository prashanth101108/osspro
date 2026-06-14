package sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class one {

	ChromeDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	public  void login() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.get("https://test.upexciseonline.co/");
		driver.manage().window().maximize();

		WebElement username  = driver.findElement(By.xpath("//*[@formcontrolname='mail']"));
		username.sendKeys("test1711");

		WebElement pass  = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
		pass.sendKeys("Test@123");

		String captcha = JOptionPane.showInputDialog("Enter Captcha");
		WebElement captchafield = driver.findElement(By.xpath("//input[@formcontrolname='captchatext']"));
		captchafield.sendKeys(captcha);

		WebElement loginbutt  = driver.findElement(By.xpath("//input[@formcontrolname='captchatext']"
				+ "/following::*[contains(text(),'Login')]"));
		loginbutt.click();




	}



	public void license_menu() throws InterruptedException {


		//Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement license_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'License Management ')]")));

		//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//			wait.until(ExpectedConditions.elementToBeClickable(license_menu));

		license_menu.click();

		WebElement Applynew_license_menu = driver.findElement(By.xpath("//*[contains(text(),'Apply New License ')]"));
		Applynew_license_menu.click();

	}
	public void pdfupload() throws AWTException, InterruptedException {

		String filename = "C:\\Users\\2035\\Documents\\Auto\\pdfsample.pdf";
		StringSelection filePath = new StringSelection(filename);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);


	}
	public void pngupload() throws AWTException, InterruptedException {

		String filename = "C:\\Users\\2035\\Documents\\Auto\\pngsample.png";
		StringSelection filePath = new StringSelection(filename);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);


	}

	public void ndld_license() throws InterruptedException, AWTException {

		WebElement NDLD1 = driver.findElement(By.xpath("//*[contains(text(),'NDLD License')]"));

		//			Actions actions = new Actions(driver);
		//			actions.scrollToElement(NDLD).build().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", NDLD1);
		//NDLD1.click();

		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement NDLD = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'NDLD License')]")));
		WebElement NDLD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'NDLD License')]")));

		NDLD.click();

		//WebElement ndld_newlicensemenu = driver.findElement(By.xpath("//*[text()=' New License ']"));

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ndld_newlicensemenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' New License ']")));
		ndld_newlicensemenu.click();

		WebElement financial_year = driver.findElement(By.xpath("//*[@formcontrolname='financialYearCode']"));


		Select select = new Select(financial_year);
		select.selectByVisibleText(" 2026-2027 ");

		WebElement License_Validity = driver.findElement(By.xpath("//*[@formcontrolname='numberOfYearslicenseValidity']"));


		Select select_License_Validity = new Select(License_Validity);
		select_License_Validity.selectByVisibleText(" 1");

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement proceed_to_payment_button = driver.findElement(By.xpath("//*[text()=' Proceed to Payment ']"));
		proceed_to_payment_button.click();

		WebElement Applidetails = driver.findElement(By.xpath("//*[text()='Applicant Details']"));

		//			Actions actions = new Actions(driver);
		//			actions.scrollToElement(Applidetails_upload_PAN);

		js.executeScript("arguments[0].scrollIntoView(true);", Applidetails);

		WebElement Applidetails_upload_PAN = driver.findElement(By.xpath("//*[text()='Applicant Details']"
				+ "/following::*[@formcontrolname='appli_pan_file_source']/parent::div"));

		Applidetails_upload_PAN.click();

		pdfupload();


		WebElement premises_address = driver.findElement(By.xpath("//*[text()='Premises Address']"));
		js.executeScript("arguments[0].scrollIntoView(true);", premises_address);

		WebElement premises_address_unitname = driver.findElement(By.xpath("//*[text()='Unit Name']/following::input[@placeholder='Unit Name']"));
		premises_address_unitname.sendKeys("sample unit...");


		WebElement premises_address_district = driver.findElement(By.xpath("//*[text()='Premises Address']/following::*[text()='District']"
				+ "/following::*[@formcontrolname='districtCode']"));
		Select select2 = new Select(premises_address_district);
		select2.selectByVisibleText(" AGRA ");

		WebElement premises_address_pincode = driver.findElement(By.xpath("//*[text()='Premises Address']/following::*[text()='District']"
				+ "/following::*[@formcontrolname='pinCode']"));
		Select select3 = new Select(premises_address_pincode);
		select3.selectByVisibleText("202124");

		WebElement premises_address_teshil = driver.findElement(By.xpath("//*[text()='Premises Address']/following::*[text()='District']"
				+ "/following::*[@formcontrolname='tahsilCode']"));
		Select select4 = new Select(premises_address_teshil);
		select4.selectByVisibleText(" Agra");

		WebElement premises_address_urbanrural = driver.findElement(By.xpath("//*[text()='Premises Address']/following::*[text()='District']"
				+ "/following::*[@formcontrolname='localityType']"));
		Select select5 = new Select(premises_address_urbanrural);

		String select_option = "Urban";

		for(WebElement option:select5.getOptions()) {

			if(option.getText().equals(select_option)) {

				System.out.println(option.getText());
				select5.selectByVisibleText("Rural");
				WebElement premises_address_block = driver.findElement(By.xpath("//*[text()='Premises Address']/following::*[text()='Block']"
						+ "/following::input[@formcontrolname='block']"));

				premises_address_block.sendKeys("block");

				WebElement premises_address_village = driver.findElement(By.xpath("//*[text()='Premises Address']/following::*[text()='Block']"
						+ "/following::input[@formcontrolname='village']"));
				premises_address_village.sendKeys("vill");


			}else {

			
				select5.selectByVisibleText(" Urban");

				WebElement premises_address_municipal = driver.findElement(By.xpath("//*[text()='Premises Address']/following::*[text()='Municipal Area']"
						+ "/following::input[@formcontrolname='municipalityName']"));
				premises_address_municipal.sendKeys("muni");

				WebElement premises_address_ward = driver.findElement(By.xpath("//*[text()='Premises Address']/following::*[text()='Municipal Area']"
						+ "/following::input[@formcontrolname='ward']"));
				premises_address_ward.sendKeys("ward");

				break;

			}}

			WebElement premises_address_locality = driver.findElement(By.xpath("//*[text()='Premises Address']/following::*[text()='Locality']"
					+ "/following::input[@formcontrolname='locality']"));
			premises_address_locality.sendKeys("loca");
			
			WebElement premises_address_policestation = driver.findElement(By.xpath("//*[text()='Premises Address']"
					+ "/following::input[@formcontrolname='policeStationName']"));
			premises_address_policestation.sendKeys("poli");
			
			WebElement premises_address_street = driver.findElement(By.xpath("//*[text()='Premises Address']"
					+ "/following::input[@formcontrolname='street']"));
			premises_address_street.sendKeys("stree");
			
			WebElement site_details_lat = driver.findElement(By.xpath("//*[text()='Latitude']/following::input[@formcontrolname='latitude']"));
			site_details_lat.sendKeys("22.22");

			WebElement site_details_long = driver.findElement(By.xpath("//*[text()='Longitude']/following::input[@formcontrolname='longitude']"));
			site_details_long.sendKeys("77.77");
			
			WebElement site_details_East = driver.findElement(By.xpath("//*[text()='East']/following::textarea[@formcontrolname='east']"));
			site_details_East.sendKeys("eas");
			
			WebElement site_details_west = driver.findElement(By.xpath("//*[text()='West']/following::textarea[@formcontrolname='west']"));
			site_details_west.sendKeys("wes");
			
			WebElement site_details_north = driver.findElement(By.xpath("//*[text()='North']/following::textarea[@formcontrolname='north']"));
			site_details_north.sendKeys("nort");
			
			WebElement site_details_south = driver.findElement(By.xpath("//*[text()='South']/following::textarea[@formcontrolname='south']"));
			site_details_south.sendKeys("sou");
			
			WebElement premises_photo_file = driver.findElement(By.xpath("//input[@formcontrolname='site_photo_file']/parent::div"));
			premises_photo_file.click();
			pngupload();
			
			WebElement premises_photo_descipt = driver.findElement(By.xpath("//input[@formcontrolname='site_photo_file']"
					+ "/following::input[@formcontrolname='description']"));
			premises_photo_descipt.sendKeys("descri");
			
			WebElement bank_details_accountnumber = driver.findElement(By.xpath("//input[@formcontrolname='accountNumber']"));
			bank_details_accountnumber.sendKeys("2342242522");

			WebElement bank_details_ifsc = driver.findElement(By.xpath("//input[@formcontrolname='accountNumber']"
					+ "/following::input[@formcontrolname='ifscCode']"));
			bank_details_ifsc.sendKeys("SBIN0011213");
			
			WebElement bank_details_bankname = driver.findElement(By.xpath("//input[@formcontrolname='bankName']"));
			bank_details_bankname.click();

			WebElement bank_details_cancelcheeque = driver.findElement(By.xpath("//input[@formcontrolname='cancel_cheque_file']/parent::div"));
			bank_details_cancelcheeque.click();
			pngupload();
			
			WebElement Applicantconsent = driver.findElement(By.xpath("//*[text()='Applicant Consent']/following::input[@type='checkbox']"));
			Applicantconsent.click();
			
			
	}

	public static void main(String[] args) throws InterruptedException, AWTException {

		one log = new one();
		log.login();	
		log.license_menu();	
		log.ndld_license();



	}

}
