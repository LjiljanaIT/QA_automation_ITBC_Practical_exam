package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {

	/*
	 * Class Registration has a separate method for each user-data. I would
	 * reconsider this approach next time... Maybe one method can hold them all, but
	 * then, one can not test separate field for bugs... Method names are
	 * self-explanatory, no comments needed.
	 */
	public static void setMrMrs(WebDriver driver, String gender) {
		driver.findElement(By.id("id_gender" + gender)).click();
	}

	public static void setFirstName(WebDriver driver, String firstname) {
		waitFOR(2000);
		WebElement firstname_field = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		firstname_field.click();
		firstname_field.sendKeys(firstname);
	}

	public static void setLastName(WebDriver driver, String lastname) {
		waitFOR(2000);
		WebElement lastname_field = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		lastname_field.click();
		lastname_field.sendKeys(lastname);
	}

	public static void setPassword(WebDriver driver, String password) {
		waitFOR(2000);
		WebElement password_field = driver.findElement(By.xpath("//input[@id='passwd']"));
		password_field.click();
		password_field.sendKeys(password);
	}

	public static void setDateOfBirth(WebDriver driver, String dd, String mm, String yy) {
		waitFOR(2000);
		WebElement choose_date = driver.findElement(By.id("days"));
		choose_date.click();
		choose_date = driver.findElement(By.xpath("//select[@id='days']/option[@value='" + dd + "']"));
		choose_date.click();

		choose_date = driver.findElement(By.id("months"));
		choose_date.click();
		choose_date = driver.findElement(By.xpath("//select[@id='months']/option[@value='" + mm + "']"));
		choose_date.click();

		choose_date = driver.findElement(By.id("years"));
		choose_date.click();
		choose_date = driver.findElement(By.xpath("//select[@id='years']/option[@value='" + yy + "']"));
		choose_date.click();

		waitFOR(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,120)");
	}

	public static void setSubscription(WebDriver driver, String news, String sub) {
		waitFOR(2000);
		WebElement subscribe = driver.findElement(By.id("newsletter"));
		if (news.equals("true")) {
			subscribe.click();
		}

		subscribe = driver.findElement(By.id("optin"));
		if (sub.equals("true")) {
			subscribe.click();
		}

		waitFOR(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,120)");
	}

	public static void setAddress(WebDriver driver, String address) {
		waitFOR(2000);
		WebElement address_field = driver.findElement(By.xpath("//input[@id='address1']"));
		address_field.sendKeys(address);
	}

	public static void setCity(WebDriver driver, String city) {
		waitFOR(2000);
		WebElement city_field = driver.findElement(By.id("city"));
		city_field.sendKeys(city);
	}

	public static void setState(WebDriver driver, String rb) {
		waitFOR(2000);
		WebElement choose_state = driver.findElement(By.xpath("//select[@id='id_state']"));
		choose_state.click();
		choose_state = driver.findElement(By.xpath("//select[@id='id_state']/option[@value='" + rb + "']"));
		choose_state.click();
	}

	public static void setZIP(WebDriver driver, String zip) {
		waitFOR(2000);
		WebElement zip_field = driver.findElement(By.id("postcode"));
		zip_field.sendKeys(zip);
	}

	public static void setMobile(WebDriver driver, String mobile) {
		waitFOR(2000);
		WebElement mobile_field = driver.findElement(By.id("phone_mobile"));
		mobile_field.sendKeys(mobile);
	}

	public static void setAlias(WebDriver driver, String alias) {
		waitFOR(2000);
		WebElement alias_field = driver.findElement(By.id("alias"));
		alias_field.clear();
		alias_field.sendKeys(alias);
	}

	public static boolean registerBtn(WebDriver driver) {
		WebElement we = driver.findElement(By.id("submitAccount"));
		we.click();
		boolean proceeded = driver
				.findElement(By.xpath("//ul[@id='address_delivery']/li/h3[contains(text(),'Your delivery address')]"))
				.isDisplayed();
		return proceeded;

	}

	public static boolean registerBtnCart(WebDriver driver) {
		WebElement we = driver.findElement(By.id("submitAccount"));
		we.click();
		boolean proceeded = driver
				.findElement(By.xpath("//ul[@id='address_delivery']/li/h3[contains(text(),'Your delivery address')]"))
				.isDisplayed();
		return proceeded;

	}

	public static boolean registerBtnHome(WebDriver driver) {
		WebElement we = driver.findElement(By.id("submitAccount"));
		we.click();
		boolean proceeded = driver.findElement(By.xpath("//div[@class='header_user_info']//a[@title='Log me out']"))
				.isDisplayed();
		return proceeded;
	}

	public static void waitFOR(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
