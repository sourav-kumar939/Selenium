package Calander;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDate {
	
	WebDriver driver;
	
	@Test
	public void handle_date() throws InterruptedException {
		
		String month="November 2022";
		String year="";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(6000);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Departure Date']/following-sibling::div/child::div[1]")));
		element.click();
		
		
		while(true) {
			
			String text=driver.findElement(By.xpath("//div[@data-testid='undefined-month-August-2022']/div/child::div[text()]")).getText();
//			String[] arr=text.split(" ");
//			String mnth=arr[0];
//			System.out.println(mnth);
//			String yr=arr[1];
			
			if(text.equalsIgnoreCase(month)) 
				break;
			
			else 
				driver.findElement(By.xpath("(//div[@id='react-root']//div[@data-testid='undefined-calendar-picker']/div)[1]")).click();
			
		}
		//driver.findElement(By.xpath("//div[@data-testid='undefined-month-November-2022']//child::div[@data-testid='undefined-calendar-day-9']")).click();
		
	}

}
