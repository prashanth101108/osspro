package sample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Samplepac {

	@Test
	public void a() {

		System.out.println("aaa");

	}
	
	
	@AfterClass
	public void bbbbb() {

		System.out.println("bbbb");

	}

	
	@AfterTest
	public void cccc() {

		System.out.println("cccccc");

	}

	@Test
	public void dddd() {

		System.out.println("dddddd");

	}

}
