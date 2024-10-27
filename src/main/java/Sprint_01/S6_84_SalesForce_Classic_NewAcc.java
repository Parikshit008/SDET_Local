package Sprint_01;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

	
	@Test
	public class S6_84_SalesForce_Classic_NewAcc {
		
	public void createPay() throws InterruptedException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		

		//Step 1: Login to Login | Salesforce 
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		
		
		driver.findElement(By.xpath("//select[@title='View:']//following::input[@title='Go!']")).click();
		driver.findElement(By.xpath("//input[@value='New Account']")).click();
		String accountName="BootCamp Puppeteer_Parikshit";
		driver.findElement(By.xpath("//input[@tabindex='1']")).sendKeys(accountName);
		String street="Main Street";
		String city="ChennaiOne";
		String zip="6000178";
		String state="TamilNaduState";
		String country="IndiaTn";
		
		driver.findElement(By.xpath("//textarea[@name='acc17street']")).sendKeys(street);
		driver.findElement(By.xpath("//input[@name='acc17city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='acc17zip']")).sendKeys(zip);
		driver.findElement(By.xpath("//input[@name='acc17state']")).sendKeys(state);		
		driver.findElement(By.xpath("//input[@name='acc17country']")).sendKeys(country);
		
		
		driver.findElement(By.xpath("//a[text()='Copy Billing Address to Shipping Address']")).click();
		
		Thread.sleep(5000);
		
		WebElement ShipStreet1 = driver.findElement(By.xpath("//textarea[@name='acc18street']"));
		String ShipStreet = driver.executeScript("return arguments[0].innerText;", ShipStreet1).toString();
		WebElement ShipCity1 = driver.findElement(By.xpath("//input[@name='acc18city']"));
		String ShipCity = driver.executeScript("return arguments[0].innerText;", ShipCity1).toString();
		WebElement ShipZip1 = driver.findElement(By.xpath("//input[@name='acc18zip']"));
		String ShipZip = driver.executeScript("return arguments[0].innerText;", ShipZip1).toString();
		WebElement ShipState1 = driver.findElement(By.xpath("//input[@name='acc18state']"));
		String ShipState = driver.executeScript("return arguments[0].innerText;", ShipState1).toString();
		WebElement ShipCountry1 = driver.findElement(By.xpath("//input[@name='acc18country']"));
		String ShipCountry = driver.executeScript("return arguments[0].innerText;", ShipCountry1).toString();
		
		Thread.sleep(3000);
		if(ShipStreet.equals(street) && ShipCity.equals(city) && ShipZip.equals(zip) && ShipState.equals(state)&& ShipCountry.equals(ShipCountry))
		
		{
			
			System.out.println("Shipping Address Verfied Successfully");
		}

		
		String fetchedDate = driver.findElement(By.xpath("//span[@class='dateFormat']")).getText();
		
        
        // Step 1: Parse the date using DateTimeFormatter
		 fetchedDate = fetchedDate.replaceAll("[\\[\\] ]", ""); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(fetchedDate, formatter);
        
        // Step 2: Add 20 days to the parsed date
        LocalDate targetDate = parsedDate.plusDays(20);
        
        // Step 3: Format the target date as dd/MM/yyyy
        String formattedDate = targetDate.format(formatter);
        
        // Output the result
        System.out.println("The date 20 days after " + fetchedDate + " is: " + formattedDate);
    
     
        driver.findElement(By.xpath("//input[contains(@onfocus,'Date')]")).sendKeys(formattedDate);
        
       
        		 driver.findElement(By.xpath("(//input[@title='Save'])[2]")).click();
        		 
        		 Thread.sleep(7000);
        		
        				 String recentAddedName = driver.findElement(By.xpath("(//a[@class='accountMru'])[1]")).getText();
        				 
        				 if(recentAddedName.contains("Parik")) {
        					 
        					 System.out.println("Account Creation Successfull");
        				 }	
        				 String formHeader = driver.findElement(By.xpath("//h2[@class='topName']")).getText();
 if(formHeader.equals(accountName)) {
        					 
        					 System.out.println("New Form Created!!!");
        				 }	
 
 driver.findElement(By.xpath("//a[@title='Accounts Tab - Selected']")).click();
 
 
		 
		 String recentAccountList = driver.findElement(By.xpath("(//tbody)[4]//tr[2]//th")).getText();
		 
		 if(recentAccountList.equals(accountName)) {
			 
			 System.out.println("Newly Created Account Verified");
		 }
        				
	}

}
