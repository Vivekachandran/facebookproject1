package org.stepdefinition;

import org.helper.classes.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition extends BaseClass   {
	
	@Given("To Open Chrome Browser")
	public void to_Open_Chrome_Browser() {
		BrowserLaunch();
		MaximizeWindow();
		Url("https://www.facebook.com/");
		implicitWait(1000);
	    
	}

	@When("To Pass valid username and password")
	public void to_Pass_valid_username_and_password() {
		
		driver.findElement(By.id("email")).sendKeys("kavi");
	    driver.findElement(By.id("pass")).sendKeys("12344");
	    driver.findElement(By.name("login")).click();
	   
	}

	@Then("To Close Chrome Browser")
	public void to_Close_Chrome_Browser() {
		
		driver.close();
		
	    
	}

	@When("To click create new account")
	public void to_click_create_new_account() {
		
		
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		driver.findElement(By.name("firstname")).sendKeys("veka");
		driver.findElement(By.name("lastname")).sendKeys("chandran");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("345677654");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Kavi@12");
	    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	}


}
