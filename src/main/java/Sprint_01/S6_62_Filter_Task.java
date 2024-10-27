package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

@Test
public class S6_62_Filter_Task {
	public void filterTask() throws InterruptedException {

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
		Actions ac = new Actions(driver);
		WebElement todaysTask = driver
				.findElement(By.xpath("//span[@title='Today’s Tasks']//following::span[text()='View All'][1]"));
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

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Filters']")).click();

		WebElement fileticon = driver.findElement(By.xpath("//div[@class='forceFilterPanelScope']"));
		ac.moveToElement(fileticon).click().perform();

		WebElement allTask = driver
				.findElement(By.xpath("//span[@class='slds-radio_faux']//following::span[text()='All tasks']"));
		ac.moveToElement(allTask).click().perform();

		WebElement done = driver.findElement(By.xpath("//span[text()='Done']"));
		ac.moveToElement(done).click().perform();

		Thread.sleep(3000);
		WebElement addFilter = driver.findElement(By.xpath("//a[text()='Add Filter']"));
		ac.moveToElement(addFilter).click().perform();

		Thread.sleep(3000);
		WebElement assignAlias = driver.findElement(By.xpath("//button[@data-value='Assigned Alias']"));
		ac.moveToElement(assignAlias).click().perform();

		Thread.sleep(3000);
		WebElement stat = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Status']"));
		ac.moveToElement(stat).click().perform();

		Thread.sleep(3000);
		WebElement selc = driver.findElement(By.xpath("//a[text()='0 options selected']"));
		ac.moveToElement(selc).click().perform();

		Thread.sleep(3000);
		WebElement Inprg = driver.findElement(By.xpath("//a[@title='In Progress']"));
		ac.moveToElement(Inprg).click().perform();

		Thread.sleep(3000);
		WebElement Donefiletr = driver.findElement(By.xpath("//span[text()='Done']"));
		ac.moveToElement(Donefiletr).click().perform();
		
		
//		Thread.sleep(3000);
//		WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
//		driver.executeScript("arguments[0].click();", save);
		
		
		//%%%%%%%%%% REMOVE THIS TEMP ISSUE%%%%%%%%%%%%%%%%
//		Thread.sleep(3000);
//		WebElement errorMsg = driver.findElement(By.xpath("//span[text()='OK']"));
//		ac.moveToElement(errorMsg).click().perform();
		
		Thread.sleep(6000);
		WebElement save2 = driver.findElement(By.xpath("//button[text()='Save']"));
		driver.executeScript("arguments[0].click();", save2);


		Thread.sleep(3000);
		String name = driver.findElement(By.xpath("(//div[@role='alert'])[3]//following::span[contains(@class,'toastMessage')]")).getText();
		if (name.contains("updated")) {

			System.out.println("Filter Added!!");
		}

		String inprogessValidate = driver.findElement(By.xpath("(//td//span//div//div[text()='In Progress'])[1]")).getText();
		if (inprogessValidate.contains("In Progress")) {

			System.out.println("Filter Validated Successfully");
		}

	}

}
