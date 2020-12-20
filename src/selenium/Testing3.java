package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test (priority = 1) // for e.g creating a new user
	public void homeTest() {
		System.out.println("I am in home test");
		System.out.println("Before assertion");
		Assert.assertTrue(2>3, "Verifying Element");  // fail different test by changing values and see skip and failures
		System.out.println("After assertion");
		Assert.assertEquals("abc", "abc");
	}
	
	@Test (priority = 2, dependsOnMethods="homeTest", groups = {"smoke", "sanity"}) // editing a created user  // depends on will skip the next 2/1 test if 1st one failed 
	public void mainTest() {                            // instead of failing
		System.out.println("I am in main test");
		System.out.println("Before assertion");
		softAssert.assertTrue(2>3, "Verifying Element");   // bcz this line is what is gonna fail the test as 2 is not greater than 3
		System.out.println("After assertion");
		softAssert.assertAll();  // similar to error collector in Junit (dont forget to write else it wont report failure)
	}
	
	@Test (priority = 3, dependsOnMethods="mainTest", groups = {"krunal"})  // deleting a user
	public void endTest() {
		System.out.println("I am in end test");
		System.out.println("Before assertion");
		softAssert.assertTrue(2>3, "Verifying Element");
		System.out.println("After assertion");
		softAssert.assertEquals("abc", "abc1");
		System.out.println("After second assertion");
		softAssert.assertAll();  
	}
	

}
