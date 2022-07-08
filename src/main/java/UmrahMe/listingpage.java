package UmrahMe;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class listingpage {
	// public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SwaraliThorat\\Downloads\\chromedriver_win32 (2)");
	@Test

	public void UmrahTest() throws InterruptedException {

		WebDriver driver = getDriver("https://www.umrahme.com/home/en-sa");
		// driver.manage().window().maximize(); //window maximize

		// driver.findElement(By.xpath("//span[@aria-labelledby='select2-RouteCode-container']/parent::span/parent::span")).click();

// select detination

//	WebElement dest = driver.findElement(By.xpath(".//input[@class='select2-search__field']"));
		System.out.println("Total no of element:"
				+ driver.findElement(By.xpath("//span[text()='Select your Destination']")).isDisplayed());
		driver.findElement(By.xpath("//span[text()='Select your Destination']")).click();

		List<WebElement> de = driver
				.findElements(By.xpath(".//span[contains(@class,'select2-search--dropdown')]/.././/li"));

		List<WebElement> Alldest = de;
		System.out.println("Total no of element:" + Alldest.size());
		for (WebElement i : Alldest) {
			System.out.println(i.getText());
			String expected = "Makkah Only Package";
			String actual = i.getText();
			System.out.println("condition" + actual.equals(expected));
			if (actual.equals(expected)) {

				System.out.println(i.getText() + "in if");
				i.click();
				break;
			}
		}

//List<WebElement>alloptions=.getOptions();
//(WebElement a : alloptions)
		// System.out.println(a.getText());

//Assert.assertTrue(dest.isDisplayed());
//dest.sendKeys("Makkah Only Package", Keys.ENTER);

		driver.findElement(By.className("floating-input")).click();
		driver.findElement(By.id("StartDate")).clear();
		WebElement date = driver.findElement(By.xpath("//input[@class='floating-input']"));
		Assert.assertTrue(date.isDisplayed());
		date.sendKeys("10-7-2022", Keys.ENTER);

		driver.findElement(By.xpath("//span[@aria-labelledby='select2-meccaCityNight-container']/parent::span"))
				.click();

		WebElement city = driver.findElement(By.xpath("//input[@aria-controls=\'select2-meccaCityNight-results\']"));
		assertEquals(0, 0);
		assertTrue(city.isDisplayed());
//		Assert.assertTrue();

		city.sendKeys("5", Keys.ENTER);
// Adult

		driver.findElement(By.xpath("//div[@class=\'all-traveller show-occupancy\']")).click();

		WebElement adult = driver.findElement(By.xpath("//select[@class='floating-select select-adult']"));

		Select object1 = new Select(adult);

		object1.selectByIndex(0);
		System.out.println(object1.isMultiple());
		List<WebElement> alloptions = object1.getOptions();
		for (WebElement a : alloptions)
			System.out.println(a.getText());
// Child

		WebElement child = driver.findElement(By.xpath("//select[@class='floating-select select-child']"));
		Select object2 = new Select(child);
		object2.selectByIndex(1);
		System.out.println(object1.isMultiple());
		List<WebElement> childoption = object1.getOptions();
		for (WebElement a : childoption)
			System.out.println(a.getText());

		/*
		 * // Age WebElement Age =
		 * driver.findElement(By.xpath("//select[@class=\'floating-select age\']"));
		 * Select object3 = new Select(Age); object3.selectByIndex(1);
		 * 
		 * 
		 * driver.findElement(By.id("select2-CountryOfResidence-container")).click();
		 * driver.findElement(By.xpath(
		 * "//input[@aria-controls=\'select2-CountryOfResidence-results\']")).sendKeys(
		 * "Algeria", Keys.ENTER); //Assert.assertTrue(country.isDisplayed());
		 * 
		 * 
		 * driver.findElement(By.xpath(
		 * "//span[@aria-labelledby='select2-Nationality-container']/parent::span")).
		 * click(); driver.findElement(By.xpath(
		 * "//input[@aria-controls=\'select2-Nationality-results\']")).sendKeys(
		 * "Algeria",Keys.ENTER);
		 * 
		 * driver.findElement(By.className("searchBtn")).click();
		 * 
		 * System.out.println("current Title is:" + driver.getTitle());
		 * System.out.println("Current url is:" +driver.getCurrentUrl());
		 */

	}

	public WebDriver getDriver(String URL) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}
}
