package testjava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava.BaseClassN;
import mainjava.ElementsPage;
import mainjava.HomePage;

public class BaseTest extends BaseClassN {
	
	@BeforeClass
	public void browserLaunching() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com");
		driver.manage().window().maximize();
		
	}
	@BeforeMethod
	public void pageObjects() { 
		
		homepage = new HomePage(driver);
		elementspage = new ElementsPage(driver);	
	}
	
	@AfterClass
	public void terminate() {
		driver.quit();	
	}	
}
