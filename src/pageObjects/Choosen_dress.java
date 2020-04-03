package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Choosen_dress {
	

	public static void setQuantity(WebDriver driver, String qty) {
		WebElement we = driver.findElement(By.id("quantity_wanted"));
		we.clear();
		we.sendKeys(qty);
		
	}

	public static void setColour(WebDriver driver, String color) {
		WebElement we = driver.findElement(By.name(color));
		we.click();

	}

	public static void setSize(WebDriver driver, By by) {
		WebElement we = driver.findElement(By.id("group_1"));
		we.click();
		we = driver.findElement(by);
		we.click();

	}

	public static void addChartBtn(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		we.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		we = driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']"));
		we.click();
	}
	
	
	
	

}
