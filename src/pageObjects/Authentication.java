package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authentication {

	// Proceeding to registration after email entered
	public static boolean createAccount(WebDriver driver, String email) {
		WebElement email_field = driver.findElement(By.id("email_create"));
		email_field.sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
		boolean register = driver.findElement(By.xpath("//h3[contains(text(),'Your personal information')]"))
				.isDisplayed();
		return register;
	}

   //Enters login data
	public static void logInData(WebDriver driver, String email, String password) {
		WebElement input = driver.findElement(By.id("email"));
		input.sendKeys(email);
		input = driver.findElement(By.id("passwd"));
		input.sendKeys(password);

	}

	// Proceeding to users dashboard after logging in
	// returs TRUE if login successful
	public static boolean clickSignIn(WebDriver driver) {
		WebElement we = driver.findElement(By.id("SubmitLogin"));
		we.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver.findElement(By.xpath("//div[@class='header_user_info']//a[@title='Log me out']")).isDisplayed();

	}

}
