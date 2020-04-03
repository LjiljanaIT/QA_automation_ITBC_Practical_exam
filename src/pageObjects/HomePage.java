package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	public static String HOME_URL = "http://automationpractice.com/";
	public static String NAV_WOMEN = "//*[@id='block_top_menu']/ul/li[1]/a";
	public static String NAV_WOMEN_SUB_SUMMER_DRESSES = "//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[3]/a";

	public static String NAV_DRESSES = "//*[@id='block_top_menu']/ul/li[2]/a";
	public static String NAV_DRESSES_SUB_SUMMER_DRESSES = "//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a";

	// Hovers over "WOMAN" option, and choose from "Summer Dresses from submenu
	public static String ClickWomenSummer(WebDriver driver) {
		waitFOR(3000);
		Actions action = new Actions(driver);

		By main_menu = By.ByXPath.xpath(NAV_WOMEN);
		By sub_menu = By.ByXPath.xpath(NAV_WOMEN_SUB_SUMMER_DRESSES);
		action.moveToElement(driver.findElement(main_menu)).moveToElement(driver.findElement(sub_menu)).click().build()
				.perform();
		return driver.getCurrentUrl();
	}

	// Hovers over "DRESSES" option, and choose from "Summer Dresses from submenu
	public static String ClickDressSummer(WebDriver driver) {
		waitFOR(3000);
		Actions action = new Actions(driver);

		By main_menu = By.ByXPath.xpath(NAV_DRESSES);
		By sub_menu = By.ByXPath.xpath(NAV_DRESSES_SUB_SUMMER_DRESSES);
		action.moveToElement(driver.findElement(main_menu)).moveToElement(driver.findElement(sub_menu)).click().build()
				.perform();
		return driver.getCurrentUrl();
	}

	// goes to "Sing In" option from Home page
	public static void signInFromHome(WebDriver driver) {
		driver.navigate().to(HomePage.HOME_URL);
		WebElement singInBtn = driver.findElement(By.xpath("//a[@class='login']"));
		singInBtn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void waitFOR(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
