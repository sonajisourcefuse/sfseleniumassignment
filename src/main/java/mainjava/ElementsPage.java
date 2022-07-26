package mainjava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import testjava.BaseTest;

public class ElementsPage extends BaseTest {

	@FindBy(xpath="//span[text()='Text Box']")
	WebElement textBoxOption;
	@FindBy(xpath="//input[@id='userName']")
	WebElement fullName;
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement emailF;
	@FindBy(xpath="//input[@id='currentAddress']")
	WebElement currentAddress;
	@FindBy(xpath="//textarea[@id='permanentAddress']")
	WebElement permanenAddress;
	@FindBy(xpath="//button[@id='submit']")
	WebElement submitBtn;

	@FindBy(xpath="//span[text()='Check Box']")
	WebElement checkBoxOption;
	@FindBy(xpath="//span[text()='Home']")
	WebElement homeCheckBox;
	@FindBy(xpath="//span[text()='Radio Button']")
	WebElement radioBtnOption;
	@FindBy(xpath="//label[text()='Yes']")
	WebElement yesRadioBtn;
	@FindBy(xpath="//img[@src='/images/Toolsqa.jpg']")
	WebElement toolsQALogo;
	@FindBy(xpath="//span[text()='Alerts']")
	WebElement alerts;
	@FindBy(xpath="//button[@id='alertButton']")
	WebElement clickMeBtn;

	public ElementsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void verifyTextBoxFields(String full_Name,String email,String current_Address,String permanent_Address) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		textBoxOption.click();
		Reporter.log("Entering Values in Text Fields",true);

		JavascriptExecutor js = (JavascriptExecutor)driver;
		fullName.sendKeys(full_Name);
		
		emailF.sendKeys(email);
		
		permanenAddress.sendKeys(permanent_Address);

		js.executeScript("arguments[0].scrollIntoView();",submitBtn);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", submitBtn);
		Reporter.log("Submit Button is Clicked Successfully",true);

	}

	public boolean verifyCheckBoxOption() throws InterruptedException {
		Thread.sleep(2000);
		checkBoxOption.click();
		Thread.sleep(1000);
		homeCheckBox.click();
		Reporter.log("Home Check Box is Clicked Successfully",true);
		return true;

	}

	public boolean verifyRadioBtnOption() throws InterruptedException {
		Thread.sleep(2000);
		radioBtnOption.click();
		Thread.sleep(1000);
		yesRadioBtn.click();
		boolean verifyRadiBtn = yesRadioBtn.isSelected();
		System.out.println("Radio Button  is Clicked Successfully : "+verifyRadiBtn);
		return true;
	}

	public String verifyGoBackToHomePage(String homePageTitle) {

		toolsQALogo.click();
		Reporter.log("ToolsQA Logo is Clicked Successfully",true);

		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, homePageTitle);
		return actualTitle;
		
	}

	public boolean VerifyAlert() throws InterruptedException {
		Reporter.log("clicking on Alerts from Alerts, Frame & Windows",true);
		alerts.click();
		Thread.sleep(2000);
		clickMeBtn.click();
		Reporter.log("click me button is Clicked Successfully",true);

		String alertTest = driver.switchTo().alert().getText();
		System.out.println(alertTest);
		driver.switchTo().alert().accept();
		
		return true;
	}

}
