package Sprint_01;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class S6_63_New_Chart {

	public void newChart() throws InterruptedException, MalformedURLException {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Step 1: Login to Login | Salesforce
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();

		// Click on toggle menu button from the left corner
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		// Click view All and click Sales from App Launcher--view all-sales
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		
		Thread.sleep(3000);
		Actions ac= new Actions(driver);
		WebElement todaysTask = driver.findElement(By.xpath("//span[@title='Today’s Tasks']//following::span[text()='View All'][1]"));
		ac.moveToElement(todaysTask).click().perform();
		
		WebElement openTaskDropDwn = driver.findElement(By.xpath("//button[@title='Select a List View: Tasks']"));
		ac.moveToElement(openTaskDropDwn).click().perform();
		
		Thread.sleep(3000);
		WebElement openTask = driver.findElement(By.xpath("//span[text()='Open Tasks']"));
		ac.moveToElement(openTask).click().perform();
		
		
		Thread.sleep(3000);
		WebElement opentaskButtn = driver.findElement(By.xpath("//button[@title='Select list display']"));
		driver.executeScript("arguments[0].click();", opentaskButtn);
		
		Thread.sleep(5000);
		WebElement tableView = driver.findElement(By.xpath("//li[@title='Display as table']"));
		ac.moveToElement(tableView).click().perform();
		
		WebElement chartIcon = driver.findElement(By.xpath("//button[@title='Charts']"));
		ac.moveToElement(chartIcon).click().perform();
		
		WebElement settingsicon = driver.findElement(By.xpath("//lightning-icon[@icon-name='utility:settings']"));
		ac.moveToElement(settingsicon).click().perform();
		
		WebElement NewChart = driver.findElement(By.xpath("//a[@title='New Chart']"));
		ac.moveToElement(NewChart).click().perform();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Chart Name']//following::input")).sendKeys("Opened task-Parikshit");
		
		driver.findElement(By.xpath("//button[@data-value='Horizontal Bar Chart']")).click();
		WebElement donutChart = driver.findElement(By.xpath("//span[@title='Donut Chart']"));
		driver.executeScript("arguments[0].click();", donutChart);
		

		driver.findElement(By.xpath("//label[text()='Aggregate Field']//following::button[@data-value='Account'][1]")).click();
		WebElement priority = driver.findElement(By.xpath("(//span[@title='Priority'])[2]"));
		driver.executeScript("arguments[0].scrollIntoView(true);", priority);
		driver.executeScript("arguments[0].click();", priority);

		
		driver.findElement(By.xpath("//label[text()='Grouping Field']//following::button[@data-value='Account'][1]")).click();
		WebElement stat = driver.findElement(By.xpath("//button[@aria-label='Grouping Field']//following::span[@title='Status']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", stat);
		driver.executeScript("arguments[0].click();", stat);
		
		WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
		driver.executeScript("arguments[0].click();", save);
		
		
		
		
		WebElement inPrg = driver.findElement(By.xpath("//div[text()='In Progress']//following::button[@title='Edit Status: Item In Progress']"));
		driver.executeScript("arguments[0].click();", inPrg);
		
		WebElement ipBttn = driver.findElement(By.xpath("//a[text()='In Progress']"));
		driver.executeScript("arguments[0].click();", ipBttn);
		
		WebElement cmpl = driver.findElement(By.xpath("//a[text()='Completed']"));
		ac.moveToElement(cmpl).click().perform();
		
		Thread.sleep(2000);

		WebElement canvasEle = driver.findElement(By.xpath("//h2[text()='Charts']"));
		Actions action = new Actions(driver);
		action.moveToLocation(1300, 400).pause(2000).click().perform();
		

		String status = driver.findElement(By.xpath("//label[text()='Status']//following-sibling::label")).getText();
		String priorityconut = driver.findElement(By.xpath("//tbody//tr//td[@class='valueCell ']")).getText();
		
        System.out.println("Status:"+status);
        System.out.println("Priority Count:"+priorityconut);
        
		WebElement sav = driver.findElement(By.xpath("//span[text()='Save']"));
		ac.moveToElement(sav).click().perform();

		WebElement refresh = driver.findElement(By.xpath("//button[@name='refreshButton']"));
		ac.moveToElement(refresh).click().perform();
        
          
//     
//        WebElement inprg = driver.findElement(By.xpath("//div[text()='In Progress']//following::button[@title='Edit Status: Item In Progress']"));
//		ac.moveToElement(inprg).click().perform();
//		
//		

//		Thread.sleep(2000);
//		
//		WebElement prgval = driver.findElement(By.xpath("//a[text()='In Progress']"));
//		ac.moveToElement(prgval).click().perform();
//		WebElement CmplVal = driver.findElement(By.xpath("//a[text()='Completed']"));
//		ac.moveToElement(CmplVal).click().perform();
		

		
	}
}
