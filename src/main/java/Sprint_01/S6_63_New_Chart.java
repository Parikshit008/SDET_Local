package Sprint_01;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
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
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement pie = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='eclairChartWrapper pie']")));

		// Scroll the pie chart element into view
		driver.executeScript("arguments[0].scrollIntoView(true);", pie);

		// Move to the top-left corner of the element first
		ac.moveToElement(pie, 0, 0).perform(); // Move to the top-left corner

		// Optional: Wait to visualize
		Thread.sleep(3000); // Adjust as needed

		// Move to the specific coordinates (1258, 478)
		ac.moveToElement(pie,1258, 478).perform(); // Adjust for any offsets if needed
		ac.moveToLocation(1258, 478).perform();

		// Optional: Wait to visualize
		Thread.sleep(500); // Adjust as needed

		// Click the element (if needed)
		ac.click().perform(); // Click the element
		
		
		/* APPROACH 1
		Thread.sleep(3000);
		WebElement pie = driver.findElement(By.xpath("//div[@class='eclairChartWrapper pie']"));
		
		Point location = pie.getLocation();
		System.out.println("Element Position: " + location);
		Thread.sleep(3000);
		ac.moveToElement(pie, 0, 0).perform();
		Thread.sleep(3000);
		ac.moveToElement(pie).click().perform();
		ac.moveByOffset(0,-15).perform();
		*/
		//===APPROACH 2=====//
	/*
		// Wait for the pie element to be present
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement pie1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='eclairChartWrapper pie']")));

		ac.moveToElement(pie1, 0, 0).perform();
		
		driver.executeScript("arguments[0].scrollIntoView(true);", pie1);
		// Get the element's location and size
		Point location1 = pie1.getLocation();
		Dimension size = pie1.getSize();

		// Calculate the center coordinates
		int centerX = location1.getX() + (size.getWidth() / 2);
		int centerY = location1.getY() + (size.getHeight() / 2);

		// Move to the center of the element
		
		ac.moveToElement(pie1, centerX, centerY).perform(); // Move to the center

		// Optional: Wait a moment to visualize the movement
		Thread.sleep(500); // Adjust as needed

		// Move slightly to the right (e.g., 10 pixels)
		ac.moveByOffset(10, 0).perform(); // Move right by 10 pixels

		// Click the element (if needed, can click after moving)
		ac.click().perform(); // Click the element
		
		*/
		

	}
}
