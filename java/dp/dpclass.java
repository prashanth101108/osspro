package dp;

import org.testng.annotations.DataProvider;

public class dpclass {

	
	@DataProvider(name="provider")
	public Object[][] getdata() {
	        Object[][]data = {
	                {"admin", "admin123"},
	                {"user1", "pass1"},
	                {"user2", "pass2"}
	        };
	 return data;
	        
	}  
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
