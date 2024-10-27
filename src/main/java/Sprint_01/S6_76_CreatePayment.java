package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class S6_76_CreatePayment {
	
public void createPay() throws InterruptedException {
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		

		//Step 1: Login to Login | Salesforce 
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();

		//Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		//Click view All and click Sales from App Launcher--view all-sales
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement payAdjust = driver.findElement(By.xpath("//p[text()='Payment Authorization Adjustments']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", payAdjust);
		driver.executeScript("arguments[0].click();", payAdjust);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		
		Thread.sleep(2000);
      WebElement searchbtn = driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']"));
      driver.executeScript("arguments[0].click();", searchbtn);
      WebElement option1 = driver.findElement(By.xpath("(//li//lightning-base-combobox-item)[1]"));
      driver.executeScript("arguments[0].click();", option1);
      
   
    
      Thread.sleep(2000);		
    driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75000");
    
    
    WebElement stat = driver.findElement(By.xpath("//label[text()='Status']//following::button[@data-value='--None--'][1]"));
    driver.executeScript("arguments[0].click();", stat);
    Thread.sleep(2000);	
    WebElement daft = driver.findElement(By.xpath("//span[text()='Draft']"));
    driver.executeScript("arguments[0].click();", daft);
    
    WebElement process = driver.findElement(By.xpath("//label[text()='Processing Mode']//following::button[@data-value='--None--'][1]"));
    driver.executeScript("arguments[0].click();", process);
    Thread.sleep(2000);	
    WebElement extr = driver.findElement(By.xpath("//span[text()='External']"));
    driver.executeScript("arguments[0].click();", extr);
    

    WebElement Authorizations = driver.findElement(By.xpath("//input[@placeholder='Search Payment Authorizations...']"));
    driver.executeScript("arguments[0].click();", Authorizations);
    Thread.sleep(2000);	
    WebElement opt1 = driver.findElement(By.xpath("//span[text()='PA-000000003']"));
    driver.executeScript("arguments[0].click();", opt1);
    
  
    WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
    driver.executeScript("arguments[0].click();", save);
    
  
    String PayValidate = driver.findElement(By.xpath("//slot[@name='primaryField']//lightning-formatted-text")).getText();
    
    if(PayValidate.contains("PAA")) {
    System.out.println("Payement Authorization Sucessfull");
    System.out.println("Payment Id:"+PayValidate);
    }
    }
    
    
    
    
    	     
		
		
		
		
		
		

		

}
