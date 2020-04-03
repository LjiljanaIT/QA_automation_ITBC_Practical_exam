package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basket {

	// Gets color and size of item in cart
	public static String getColorSize(WebDriver driver) {
		WebElement we = driver
				.findElement(By.xpath("//tr[@id='product_5_24_0_0']/td[@class='cart_description']/small[2]/a"));
		return we.getText();

	}

	// Gets quantity item in cart
	public static String getQty(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath("//tr[@id='product_5_24_0_0']/td[5]/input[2]"));
		return we.getAttribute("value");

	}

	// Gets title item in cart
	public static String getTitle(WebDriver driver) {
		WebElement we = driver.findElement(
				By.xpath("//tr[@id='product_5_24_0_0']/td[@class='cart_description']/p[@class='product-name']/a"));
		return we.getText();

	}

	// Locate "proceed" button by scrolling window and click
	// Return "true" if successfully proceeded
	public static boolean proceeded(WebDriver driver) {
		waitFOR(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		waitFOR(3000);
		WebElement we = driver
				.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
		we.click();
		boolean proceeded = driver
				.findElement(By.xpath("//div[@id='center_column']/h1[contains(text(),'Authentication')]"))
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
