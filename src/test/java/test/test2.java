package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageLogin;



public class test2{
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
			pageLogin.login("user","user");
			Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).getText().contains("Welcome back to"));
		}
		@Test
		public void pruebaDos () {
			PageLogin pageLogin = new PageLogin(driver);
			pageLogin.login("mercury","mercury");
			Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table")).getText().contains("Flight Finder to search"));
		}
		public void taerDown(){
			driver.close();
		}
	}
