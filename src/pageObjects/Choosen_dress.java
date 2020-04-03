package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Choosen_dress {

	// Sets quantity of the items to be added to the cart
	public static void setQuantity(WebDriver driver, String qty) {
		WebElement we = driver.findElement(By.id("quantity_wanted"));
		we.clear();
		we.sendKeys(qty);

	}

	// Sets color of the item to be added to the cart
	public static void setColour(WebDriver driver, String color) {
		WebElement we = driver.findElement(By.name(color));
		we.click();

	}

	// Sets size of the item to be added to the cart
	public static void setSize(WebDriver driver, By by) {
		WebElement we = driver.findElement(By.id("group_1"));
		we.click();
		we = driver.findElement(by);
		we.click();

	}

	// Clicks "Add to Chart" button and "Proceed" button on pop-up window
	public static void addChartBtn(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		we.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		we = driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']"));
		we.click();
	}
}
