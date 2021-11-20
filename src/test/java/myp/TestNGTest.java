package myp;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest {
	
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\M1073042\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver=new EdgeDriver();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.eazydiner.com/");
		
		
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest() {
		String title= driver.getTitle();
		System.out.println("the page title is: "+title);
//		Assert.assertEquals(title, expected);
	}
	
	@Test(priority=2)
	public void SearchScriptTest() throws InterruptedException {
		//Search bar script
		System.setProperty("webdriver.edge.driver", "C:\\Users\\M1073042\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver=new EdgeDriver(); 
			    driver.get("https://www.eazydiner.com/"); 
			    if(driver.findElement(By.id("webpush-onsite")).isDisplayed()) {
			    	driver.switchTo().frame(driver.findElement(By.id("webpush-onsite")));
			    	driver.findElement(By.id("allow")).click();
			    	driver.switchTo().defaultContent();
			    	}
			    driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);

			    driver.findElement(By.xpath("//a[@id='srchbar']")).click();
			    Thread.sleep(1000);
			   // driver.findElement(By.xpath("//input[@id='search_city']")).sendKeys("Mumbai");
			    driver.findElement(By.xpath("//a[@data-city='Mumbai']")).click();
			    
			    driver.findElement(By.xpath("//input[@id='home-search']")).sendKeys("pizza hut");
			    Thread.sleep(1000);
			    driver.findElement(By.id("apxor_search")).click();
	}
	
	@Test(priority=3)
	public void BookTableScriptTest() throws InterruptedException {
		// Book table Script

			    Thread.sleep(1000);
			  //to handle allow alert box
			    /*if(driver.findElement(By.id("webpush-onsite")).isDisplayed()) {
			    	driver.switchTo().frame(driver.findElement(By.id("webpush-onsite")));
			    	driver.findElement(By.id("allow")).click();
			    	driver.switchTo().defaultContent();
			    	}*/
			    
			    driver.findElement(By.xpath("//span[text()='Book a Table']")).click();
			    Thread.sleep(1000);
			    
			    driver.findElement(By.xpath("//*[@id='restaurants']/div[3]/div/div[3]/div[2]/div[2]/a")).click();
			    
			    driver.findElement(By.xpath("//button[contains(text(),'Continue to book a table')]")).click();
			    driver.findElement(By.xpath("//input[@id='guest_name']")).sendKeys("Rohini ");
			    driver.findElement(By.xpath("//*[@id='guest-form']/div/div[2]/div/div/input")).sendKeys("8312364876");
			    
			    driver.findElement(By.xpath("//input[@id='guest_email']")).sendKeys("Rohini@gmail.com");
			    Thread.sleep(1000);
			    driver.findElement(By.xpath("//*[@id='checkout-button']")).click();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
