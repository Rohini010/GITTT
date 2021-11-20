

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

 

public class Comprehensive5 {

 

    public static void main(String[] args) {
        // TODO Auto-generated method stub

 

    	System.setProperty("webdriver.edge.driver", "C:\\Users\\M1073042\\Downloads\\edgedriver_win64\\msedgedriver.exe");
          
          WebDriver driver=new EdgeDriver();
          
          driver.get("https://www.eazydiner.com/");
         
          driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
         try {
           if(driver.findElement(By.id("webpush-onsite")).isDisplayed()) {
               driver.switchTo().frame(driver.findElement(By.id("webpush-onsite")));
               driver.findElement(By.id("allow")).click();
               driver.switchTo().defaultContent(); 
           }
        }
           catch (Exception e){
               
           } 

        driver.findElement(By.xpath("//div[@class='swiper-slide meal_boxes-2 inline-block padding-r-10 swiper-slide-next'  ] ")).click();
        Select obj=new Select(driver.findElement(By.id("res_sort")));
        obj.selectByValue("cost-asc");        
        driver.findElement(By.xpath("//div[@class='filter_toogle']")).click();
        driver.findElement(By.xpath("//*[@id=\"restaurants\"]/div[1]/div/div[3]/div[2]/div[1]/a")).click();        
        driver.findElement(By.id("amount")).sendKeys("100");
        
        driver.findElement(By.xpath("//*[@id=\"checkoutForm\"]/div[2]/button")).click();
        
        driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
          
               
        driver.findElement(By.id("fname")).sendKeys("Atharva");
        driver.findElement(By.id("lname")).sendKeys("Tekade");
        
        driver.findElement(By.xpath("//div[@class='close pointer']")).click();
        driver.findElement(By.xpath("//div[@data-tab='menus']")).click();
        driver.findElement(By.xpath("//*[@id=\"slotForm\"]/div/div/button")).click();
        driver.findElement(By.id("//*[@id=\"checkout-button\"]")).click();
    }
    
    
}
