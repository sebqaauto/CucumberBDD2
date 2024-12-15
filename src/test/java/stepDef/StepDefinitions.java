package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CommonPage;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;

public class StepDefinitions {
	
	WebDriver driver;
	
	CommonPage common;
	LoginPage login;
	RegistrationPage register;
	
	@Given("the browser is launched")
	public void the_browser_is_launched() {
	    driver = new ChromeDriver();
	    common = new CommonPage(driver);
	    login = new LoginPage(driver);
	    register = new RegistrationPage(driver);
	    common.launchApp();
	}
	
	/*
	 * Scenario 1: Steps for Login 
	 * */
	@Given("user clicks on the login link")
	public void user_login() {
		common.clickOnLoginLink();
	}
	@Given("enters the email address")
	public void enters_the_email_address() {
	    login.enterEmailAddr("sky123@bcci11.com");
	}
	@Given("enter the password")
	public void enter_the_password() {
	    login.enterPassword("YouKnowMe123");
	}
	@Given("clicks on submit button")
	public void clicks_on_submit_button() {
	   login.clickOnLoginButton();
	}
	@Then("login should be successful")
	public void login_should_be_successful() {
	   
	}
	
	/*
	 * Scenario 2: Steps for Registration 
	 * */
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
	    common.clickOnRegisterLink();
	}
	@When("I user enters the {string}")
	public void i_user_enters_the(String string) {
	  register.enterFirstName(string);
	}

	@When("the last name {string}")
	public void the_last_name(String string) {
	    register.enterLastName(string);
	}
	@When("the email {string}")
	public void the_email(String string) {
		register.enterEmailAddr(string);
	}
	@When("the password {string}")
	public void the_password(String string) {
	   register.enterPassword(string);
	}
	@When("the confirmPassword {string}")
	public void the_confirm_password(String string) {
	   register.enterConfirmPassword(string);
	}
	@When("clicks on the continue button")
	public void clicks_on_the_continue_button() {
	    register.clickOnRegisterButton();
	}
	@Then("user should be logged in")
	public void user_should_be_logged_in() {
	    
	}


}
