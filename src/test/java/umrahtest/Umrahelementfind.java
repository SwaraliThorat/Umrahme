package umrahtest;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Umrahelementfind 
{
	
	@FindBy(xpath="//span[text()='Select your Destination']")
	private WebElement destination;
	
  @FindBy(xpath=".//span[contains(@class,'select2-search--dropdown')]/.././/li")
    private WebElement dropdown;

  @FindBy(id="StartDate")
  private WebElement date;
  
  @FindBy(xpath="//span[@aria-labelledby='select2-meccaCityNight-container']/parent::span")
  private WebElement meccacitysearch;
  
  @FindBy(xpath="//input[@aria-controls=\'select2-meccaCityNight-results\']")
  private WebElement meccacitystay;
  
  @FindBy(xpath="//div[@class=\'all-traveller show-occupancy\']")
  private WebElement occupancysearch;
   
  @FindBy(xpath="//select[@class='floating-select select-adult']")
  private WebElement adult;
  
  @FindBy(xpath="//select[@class='floating-select select-child']")
  private WebElement child;
  
  @FindBy(xpath="//select[@class=\'floating-select age\']")
  private WebElement Age;
  
  @FindBy(id="select2-CountryOfResidence-container")
  private WebElement country;
  
  @FindBy(xpath="//input[@aria-controls=\'select2-CountryOfResidence-results\']")
  private WebElement searchcountry;
  
  @FindBy(xpath="//span[@aria-labelledby='select2-Nationality-container']/parent::span")
  private WebElement Nationality;
  
  @FindBy(xpath= "//input[@aria-controls=\'select2-Nationality-results\']")
  private WebElement searchnationality;
  
  @FindBy(className="searchBtn")
  private WebElement searchbutton;
	
  
/******************************************************************************************************************/
  public WebDriver driver;
  public void destination()
  {
	  assertTrue(destination.isDisplayed(), "IS DISPLAYED");
	  destination.click();
	  dropdown.sendKeys("Makkah Only Package", Keys.ENTER);
	  
  }
  public void date()
  {
	  date.click();
	  date.sendKeys("10-07-2022", Keys.ENTER);
  }
  
  public void meccacitysearch()
  {
	  meccacitysearch.click();
	  meccacitystay.sendKeys("5 Nights", Keys.ENTER);
  }
  public void occupancysearch()
  {
	  occupancysearch.click();
	 
  }
  public void adult()
  {
	  adult.click();
	  Select object1 = new Select(adult);

		object1.selectByIndex(0);
  }
  public void child()
  {
	  child.click();
	  Select object2 = new Select(child);
		object2.selectByIndex(1);
  }
  public void Age()
  {
	  Age.click();
	  Select object3 = new Select(Age);
	  object3.selectByIndex(1);
		 
  }
  public void country()
  {
	  country.click();
	  searchcountry.sendKeys("Algeria", Keys.ENTER);
  }
  public void nationality()
  {
	  Nationality.click();
	  searchnationality.sendKeys("Algeria",Keys.ENTER);
  }
  public void searchbutton()
  {
	  searchbutton.click();
  }
  
	
	 public Umrahelementfind(WebDriver driver)
	 {
	        this.driver = driver;
	       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        PageFactory.initElements(driver, this);

	    }

}
