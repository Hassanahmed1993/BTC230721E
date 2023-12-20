package com;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.When;


public class LoginStepDefinition {
	WebDriver driver;
	
	
	//Cucumber Hooks to run all scenarios
	@Before
	public void beforeScenario() {
		System.out.println("It will run before the scenario starts");
	}
	@After
	public void afterScenario() {
		System.out.println("It will run after the scenario finishes");
	}
	
	// 
	
	//Customized Hooks to run specific scenario
	@Before({"@Smoke"})
	public void beforeTagScenrio() {
		System.out.println("It will run before the scenario starts");
	}
	@After({"@Smoke"})
	public void afterTagScenario() {
		System.out.println("It will run after the scenario finishes");
	}
	//
	
	@Given("^open browser$")
	public void openBrowser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //driver = new ChromeDriver();
	    
	}
	
	@Given("^go to facebook\\.com$")
	public void go_to_facebook_com() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.get("http://www.facebook.com");
	    
	}

	@When("^user type valid userID in userID textbox$")
	public void user_type_valid_userID_in_userID_textbox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.findElement(By.id("email")).sendKeys("myUserID");
	   
	}

	@When("^user type valid password in password box$")
	public void user_type_valid_password_in_password_box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.findElement(By.id("pass")).sendKeys("myPassword");
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.findElement(By.id("login button")).click();
	    
	}

	@Then("^user should see profile page$")
	public void user_should_see_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		boolean result = driver.findElement(By.xpath("")).getText().equals("AlAmin"); // Verify whats visible on the page
//		if(result) {
//			System.out.println("I am in profile page");
//		}
//		else {
//			System.out.println("Not in profile page");
//		}
	}
		
		@When("^user type \"([^\"]*)\" in userID textbox$")
		public void user_type_in_userID_textbox(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			ChromeDriver.findElement(By.id("email")).sendKeys(arg1);
		}

		@When("^user type \"([^\"]*)\" in password box$")
		public void user_type_in_password_box(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			driver.findElement(By.id("password")).sendKeys(arg1);
		}

		@Then("^user should not see profile page$")
		public void user_should_not_see_profile_page() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			boolean result = driver.findElement(By.xpath("")).getText().equals("AlAmin"); // Verify whats visible on the page
			if(!result) {
				System.out.println("I am in profile page");
			}
			else {
				System.out.println("Not in profile page");
			}
		}
		

	}
//Describe your BDD Cucumber work.
//as we know the framework is a collection of guidelines, which helps us to design our project
//the framework i had which was built using Maven project where i have added all the dependencies in pom.xml files
//so in BDD cucumber framework there are 3 main components
//1- feature file: this file helps to design our scenario against a feature or module which is based on jerkins syntax(given,when,then,and,but..etc)
//2- step definition file: in order to implement the feature file we need to create the step definition class based on cucumber framework. 
//the way we design our step definition class was instead of writing code directly to that class we followed Page Object Pattern,
//that means we have created java classes against each page where we store object using @findby annotations
//3- runner class: to run our project based on cucumber options and junit we need a runner class.
//on top of these 3 components we had some extra features in our framework like, there was a helper class where we had all the utility methods
//so there was a solution for performing data driven testing like scenario outline, data table, and excel sheet
//so there was also a reporting concept like html report, json report and extend reports
//so to make the log report for our project we used log 4j concept
//there was also a class where we configured our browser in order to perform browser and cross browser/cross platform testing

