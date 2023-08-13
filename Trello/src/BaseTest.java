import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;
	@BeforeMethod
	public WebDriver launchApplication() 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://trello.com/login");
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public void loginApplication()
	{
		driver.findElement(By.id("user")).sendKeys("prashannarg@gmail.com");
		driver.findElement(By.cssSelector("input[id=login]")).click();
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));*/
		
		try
		{
			driver.findElement(By.cssSelector("input[id=password]")).sendKeys("Dhivyan@179");
		}
		catch(StaleElementReferenceException e)
		{
			driver.findElement(By.cssSelector("input[id=password]")).sendKeys("Dhivyan@179");
		}
		driver.findElement(By.cssSelector("button[id=login-submit]")).click();
	}
	
	public void createBoard()
	{
		driver.findElement(By.xpath("//span[text()='Create new board']")).click();
		driver.findElement(By.xpath("//*[text()='Board title']/..//input")).sendKeys("Full Creative");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[text()='Create']"))));
		driver.findElement(By.xpath("//button[text()='Create']")).click();
	}
	
	public void addList()
	{
		driver.findElement(By.xpath("//span[text()='Add another list']")).click();
		driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys("List A");
		driver.findElement(By.xpath("//input[@value='Add list']")).click();
		driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys("List B");
		driver.findElement(By.xpath("//input[@value='Add list']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'js-cancel-edit')]")).click();
	}
	
	public void createCard()
	{
		driver.findElement(By.xpath("//*[text()='List A']/../..//span[text()='Add a card']")).click();
		driver.findElement(By.xpath("//*[text()='List A']/../..//textarea[contains(@class,'js-card-title')]")).sendKeys("Test1");
		driver.findElement(By.xpath("//*[text()='List A']/../..//input[@value='Add card']")).click();
	}
	
	
	@AfterMethod()
	public void closeApplicaton()
	{
		driver.close();
	}
}
