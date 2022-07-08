import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
  @Test
  public void f() 
  {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.umrahme.com/home/en-sa");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.manage().window().maximize(); //window maximize

		driver.findElement(By.xpath("//span[@aria-labelledby='select2-RouteCode-container']/parent::span/parent::span")).click();
		WebElement destination = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		
		//.sendKeys("Makkah Only Package", Keys.ENTER);
		driver.findElement(By.xpath("//input[@class='floating-input']/parent::div")).click();
		driver.findElement(By.id("StartDate")).clear();
		driver.findElement(By.xpath("//input[@class='floating-input']")).sendKeys("10-7-2022", Keys.ENTER);
		driver.findElement(By.xpath("//span[@aria-labelledby='select2-meccaCityNight-container']/parent::span")).click();
		driver.findElement(By.xpath("//input[@aria-controls=\'select2-meccaCityNight-results\']")).sendKeys("5",Keys.ENTER);
		driver.findElement(By.xpath("//div[@class=\'all-traveller show-occupancy\']")).click();

		WebElement adult = driver.findElement(By.xpath("//select[@class='floating-select select-adult']"));
		Select object1 = new Select(adult);
		object1.selectByIndex(1);


		driver.findElement(By.xpath("//span[@aria-labelledby='select2-CountryOfResidence-container']/parent::span/parent::span")).click();

		driver.findElement(By.xpath("//input[@aria-controls=\'select2-CountryOfResidence-results\']")).sendKeys("Algeria", Keys.ENTER);

		driver.findElement(By.xpath("//span[@aria-labelledby='select2-Nationality-container']/parent::span")).click();

		driver.findElement(By.xpath("//input[@aria-controls=\'select2-Nationality-results\']")).sendKeys("Algeria",Keys.ENTER);
try {
		driver.findElement(By.className("searchBtn")).click();
}
catch(Exception e) {
	System.out.println("exception occurre beacuase of version missmatch ");
	
}
driver.close();
	}

	
}

  

