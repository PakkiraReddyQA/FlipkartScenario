package flipKartScenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redmi4gbRAM {
	@Test
	public void redmi4gbRamTest()
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
				element.sendKeys("Redmi");
				element.submit();
				List<WebElement> RedmiMobiles = driver.findElements(By.xpath("//li[@class='rgWa7D'][1]"));
				
				for(WebElement ram:RedmiMobiles)
				{
					if(ram.getText().contains("4 GB RAM"))
					{
						System.out.println(ram.getText());
					}
				}
				
	}

}
