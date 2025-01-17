package pageobjects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.common.io.Files;
import org.openqa.selenium.TakesScreenshot;


public class CommonPage {
	
	/* Page Object Model 
	 * 1) Capture all the WebElements of this page 
	 * 2) Define the actions that has to be performed on these WebElements - corresponding to this page
	 * 
	 *  To Use Page Factory in Selenium - initiElements()  element initialization 
	 *  Why?  For Lazy initialization of WebElements
	 * */
	String baseUrl = "https://demowebshop.tricentis.com/";
	WebDriver driver;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	String registeredEmailId;
	
	@FindBy(css=".ico-register") 
	WebElement registerLink;
	
	@FindBy(css=".ico-login") 
	WebElement loginLink;
	
	@FindBy(css=".ico-logout") 
	WebElement logoutLink;
	
	@FindBy(css=".header-links .account")
	WebElement registerUserEmail;
	
	//WebElement registerLink = driver.findElement(By.cssSelector(".ico-register"));
	//WebElement loginLink = driver.findElement(By.cssSelector(".ico-login"));
	//WebElement logoutLink = driver.findElement(By.cssSelector(".ico-logout"));
	
	public void launchApp() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//div[@class='fc-dialog-container']//button/p[text()='Consent']")).click();
	}
	
	//Actions should be Granular  
	
	public void clickOnRegisterLink() {
		registerLink.click();
	}
	
	public void clickOnLoginLink() {
		loginLink.click();
	}
	
	public void clickOnLogoutLink() {
		logoutLink.click();
	}
	
	public void getRegisteredEmailId() {
		registeredEmailId = registerUserEmail.getText();
	}
	
	
	public String takeSnap() throws IOException {
		String title = driver.getTitle();
		String filename = title+".jpg";
		String path = "/Users/sebastianselvarajaugustine/eclipse-workspace/demowebshop/src/main/java/test-snaps"+filename;
		//Cast the WebDriver object as TakesScreenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File fileLocationForSnap = new File(path);
		Files.copy(screenshot, fileLocationForSnap);
		return path;
		
	}
	

}
