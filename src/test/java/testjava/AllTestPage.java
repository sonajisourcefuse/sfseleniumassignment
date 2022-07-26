package testjava;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AllTestPage extends BaseTest {
	
	@Test
	public void allTest() throws InterruptedException {
		Reporter.log("Verifying Title Of Page-: ToolsQA" ,true);
		homepage.verifyPageTitle("ToolsQA");
		Reporter.log("Verifying Current URl Of Page :- https://demoqa.com/",true);
		homepage.verifyUrlOfpage("https://demoqa.com/");
		Reporter.log("Selecting Elements Option on Home Page",true);
		homepage.selectElementsOption();
		Reporter.log("Verifyiing Text Fields On Elements Page",true);
		elementspage.verifyTextBoxFields("john", "abc@gamil.com","pune", "mumbai");
		Reporter.log("Verifyiing Check Box Option on Elements Page",true);
		elementspage.verifyCheckBoxOption();
		Reporter.log("Verifyiing Radio Button Option on Elements Page",true);
		elementspage.verifyRadioBtnOption();
		Reporter.log("Go Back To Home Page By Clicking On ToolsQA logo",true);
		elementspage.verifyGoBackToHomePage("ToolsQA");
		Reporter.log("Select Alert Option From Home Page",true);
		homepage.clickonAlert_Frame();
		Reporter.log("Verifying Alert By Clicking click me Button",true);
		elementspage.VerifyAlert();
		
		
		
	}


}
