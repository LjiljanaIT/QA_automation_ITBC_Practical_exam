package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Summer_Dresses {
	
	public static String SD_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";
	
	public static void ClickFirst(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']//img[@class='replace-2x img-responsive']"));
		we.click();
	}
}
