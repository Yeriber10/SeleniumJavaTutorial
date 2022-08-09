package pages;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;


import com.sun.tools.javac.util.List;

public class PageLogin {
	private WebDriver driver;
	private By userField;
	private By passwordField;
	private By loginButton;
	private By fields;
	public PageLogin(WebDriver driver){
		this.driver = driver;
		userField = By.name("userName");
		passwordField = By.name("password");
		loginButton = By.name("submit");
		fields = By.tagName("input");
	}
public void login(String user, String pass){
	driver.findElement(userField).sendKeys(user);
	driver.findElement(passwordField).sendKeys(pass);
	driver.findElement(loginButton).click();
	/*File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	try {
		FileUtils.copyFile(myScreenshot, new File ("LOGIN"+System.currentTimeMillis()+".png"));
		
	} catch (IOException e) {
		
		e.printStackTrace();
		
	}*/
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Helpers helper = new Helpers();
	//helper.sleepSeconds(4);
}

public void fields_login(String user,String pass){
	List<WebElement> loginFields = (List<WebElement>) driver.findElements(fields);
	loginFields.get(1).sendKeys(user);
	loginFields.get(2).sendKeys(pass);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

public void verifyFields() {
	List<WebElement> loginFields = (List<WebElement>) driver.findElements(fields);
	System.out.println(loginFields.size());
	Assert.assertTrue(loginFields.size()==5);
	
	
}

}
	

