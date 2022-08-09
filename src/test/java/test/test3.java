package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class test3{
	private WebDriver driver;
    @BeforeMethod
	public void setUp(){
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.guru99.com/test/newtours/");
		Helpers helper = new Helpers();
		helper.sleepSeconds(5);
	}
	@Test
	public void pruebaUno () {
		PageLogin pageLogin = new PageLogin(driver);
		PageLogon pageLogon = new PageLogon(driver);
		pageLogin.login("user","user");
		pageLogon.assertLogonPage();
	}
	@Test
	public void pruebaDos () {
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("mercury","mercury");
		pageReservation.assertPage();
		
	}
	public void taerDown(){
		driver.close();
	}
}