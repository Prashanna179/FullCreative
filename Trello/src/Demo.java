import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Demo extends BaseTest{

	@Test
	public void verifyDragandDrop() throws InterruptedException
	{
		
		loginApplication();
		createBoard();
		addList();	
		createCard();
		
		//Drag and Drop action
		Actions a = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//*[text()='List A']/../..//a[contains(@class,'list-card')]"));
		WebElement des = driver.findElement(By.xpath("//*[text()='List B']/../..//*[contains(@class,'list-cards')]"));
		a.dragAndDrop(src, des).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='List B']/../..//a[contains(@class,'list-card')]")));
		
		//To get x and y coordinates
		int x = driver.findElement(By.xpath("//*[text()='List B']/../..//a[contains(@class,'list-card')]")).getRect().getX();
		int y = driver.findElement(By.xpath("//*[text()='List B']/../..//a[contains(@class,'list-card')]")).getRect().getY();
		
		System.out.println(x + "," + y);
		
					
	}
}
