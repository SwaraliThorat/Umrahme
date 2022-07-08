package umrahtest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestcasesUmrah 
{
	public Umrahelementfind Method;
	public WebDriver driver;
	
	@BeforeSuite
	
	public void OpenUrl()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.umrahme.com/home/en-sa");
		Method =new Umrahelementfind(driver);
		
	}
	@Test
	public void listingpage()
	{
		Method.destination();
		Method.date();
		Method.meccacitysearch();
		Method.occupancysearch();
		Method.adult();
		Method.child();
		Method.Age();
		Method.country();
		Method.nationality();
		Method.searchbutton();
	}
	
	@Test
	public void quit()
	{
		driver.quit();
	}
	
	
	
	

}
