package mainjava;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testjava.BaseTest;

public class HomePage extends BaseTest {
	@FindBy(xpath="//h5[text()='Elements']")
	WebElement elements;
	
	@FindBy(xpath="//span[text()='Text Box']")
	WebElement textBox;
	
	@FindBy(xpath="//div[@class='category-cards']/child::div[3]")
	WebElement alertFramewindows;
	
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	
	public String verifyPageTitle(String titleExpected) {
		String titlefrombuild = driver.getTitle();
		Assert.assertEquals(titlefrombuild, titleExpected);
		return titlefrombuild;
	}
	
	public String verifyUrlOfpage(String urlExpected) {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl , urlExpected);
		return currentUrl;
	}
	
	public void clickonAlert_Frame() throws InterruptedException{
		
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",alertFramewindows);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();",alertFramewindows);
			
		
	}
	
	
	
	public void selectElementsOption() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",elements);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", elements);
		
		
		
	}
	public void clickTextBox() {
		textBox.click();
	}
}
