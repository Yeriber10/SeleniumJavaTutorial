package test;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class test12 {
	private WebDriver driver;
    @BeforeMethod
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(200,200));
		//for (int i=0; i<=800;i++)
			//driver.manage().window().setPosition(new Point(i, i));
		driver.navigate().to("https://demo.guru99.com/test/newtours/");
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		String googleWindow = "window.open('http://window.google.com')";
		javaScriptExecutor.executeScript(googleWindow);
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
		pageLogin.login("mercury","imercury");
		pageReservation.assertPage();
		
	}
	@Test
	public void pruebaTres () {
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("mercury","imercury");
		pageReservation.selectPassengers(2);
		pageReservation.selectFromPort(3);
		pageReservation.selectToPort("London");
	}
	@Test
	
	public void pruebaCantidadDeCampos() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyFields();
		
	}
	@AfterMethod
	public void taerDown(ITestResult result){
		if (!result.isSuccess()) {
			File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(myScreenshot, new File ("Error" +System.currentTimeMillis()+".png"));
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
		driver.close();
	}

}



