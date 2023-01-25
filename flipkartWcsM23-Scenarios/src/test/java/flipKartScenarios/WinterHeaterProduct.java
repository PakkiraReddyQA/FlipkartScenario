package flipKartScenarios;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WinterHeaterProduct {
	@Test
	public void addToCartTest() throws InterruptedException
	{
		//Launch the Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//Navigate to The Flipkart
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//Search for product 
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Winter Heater");
		element.submit();
		//click on first product
		driver.findElement(By.className("s1Q9rs")).click();
//		String itemName = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
//		System.out.println(itemName);
		String parentId=driver.getWindowHandle();
		Set<String>childId1=driver.getWindowHandles();
		for(String all:childId1)
		{
			if(!parentId.equals(all))
			{
				driver.switchTo().window(all);
			}
		}
		Thread.sleep(20);
		String itemName = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
        String itemName1 = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']")).getText();
        System.out.println(itemName1);
		if(itemName1.contains(itemName))
		{
			System.out.println("item added to cart");
		}
		else
		{
			System.out.println("item not added cart");
		}
//		driver.close();
		
		
		
		
	}

}
