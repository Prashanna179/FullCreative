import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Demo extends BaseTest{

	@Test
	public void verifyDragandDrop() throws InterruptedException
	{
		
		WebElement card;
		int x,y;
		
		loginApplication();
		createBoard();
		addList();	
		createCard();
		
		//Drag and Drop action
		Actions a = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//*[text()='List A']/../..//a[contains(@class,'list-card')]"));
		WebElement des = driver.findElement(By.xpath("//*[text()='List B']/../..//*[contains(@class,'list-cards')]"));
		a.dragAndDrop(src, des).build().perform();
		
		
		//To get x and y coordinates
		
		try
		{
		   card = driver.findElement(By.xpath("//*[text()='List B']/../..//a[contains(@class,'list-card')]"));
		   x = card.getRect().getX();
		   y = card.getRect().getY();
		}
		catch(StaleElementReferenceException e)
		{
			card = driver.findElement(By.xpath("//*[text()='List B']/../..//a[contains(@class,'list-card')]"));
			x = card.getRect().getX();
			y = card.getRect().getY();
		}
		
		System.out.println(x + "," + y);
		
					
	}
}
