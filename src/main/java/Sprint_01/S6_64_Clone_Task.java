package Sprint_01;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class S6_64_Clone_Task {

	public void cloneTask() throws InterruptedException, MalformedURLException {

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

		// ----------

		Thread.sleep(3000);
		WebElement settings = driver.findElement(By.xpath("//button[@title='List View Controls']"));
		ac.moveToElement(settings).click().perform();

		WebElement clone = driver.findElement(By.xpath("//span[text()='Clone']"));
		driver.executeScript("arguments[0].click();", clone);

		WebElement tit = driver.findElement(By.xpath("//label[text()='List Name']//following::input[@name='title']"));
		tit.clear();
		tit.sendKeys("New open tasks Clone");
		WebElement apiname = driver
				.findElement(By.xpath("//label[text()='List API Name']//following::input[@part='input']"));
		apiname.clear();
		apiname.sendKeys("skjfnsdj");

		WebElement listvi = driver.findElement(By.xpath("//span[text()='All users can see this list view']"));
		ac.moveToElement(listvi).click().perform();

		WebElement save = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		ac.moveToElement(save).click().perform();

		Thread.sleep(2000);
		//WebElement saves = driver.findElement(By.xpath("//tbody//tr[1]//th//span[@class='triggerContainer']"));
		//ac.moveToElement(saves).click().perform();
		
		WebElement peniconfield = driver.findElement(By.xpath("//tbody//tr[1]//th//following-sibling::span[@class='triggerContainer']"));
		ac.moveToElement(peniconfield).click().perform();
		
		
//		WebElement pen = driver.findElement(By.xpath("//span[text()='Edit Subject: Item map']"));
//		ac.moveToElement(pen).click().perform();
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-value='map']")));
		Thread.sleep(5000);
		WebElement mainfield = driver.findElement(By.xpath("(//div[@part='input-container'])[2]"));
		ac.moveToElement(mainfield).click().perform();
		
		
		WebElement mainfield1 = driver.findElement(By.xpath("//div[@part='input-container']//input[@data-value='Email']"));
		
		
		
		driver.executeScript("arguments[0].value = '';", mainfield1);
		ac.moveToElement(mainfield).click().perform();
		driver.executeScript("arguments[0].value='Maps';", mainfield1);
		
		driver.executeScript("arguments[0].dispatchEvent(new Event('input'));", mainfield1);
		driver.executeScript("arguments[0].dispatchEvent(new Event('change'));", mainfield1);
		driver.executeScript("arguments[0].dispatchEvent(new Event('blur'));", mainfield1);
		
		
		
		Thread.sleep(3000);	
		WebElement clkout = driver.findElement(By.xpath("//tbody//tr[15]//th[1]"));
		ac.moveToElement(clkout).click().perform();
		
		Thread.sleep(3000);		
	//WebElement stayonpage = driver.findElement(By.xpath("//span[text()='Stay on this List']"));
	//	ac.moveToElement(stayonpage).click().perform();

		

		Thread.sleep(3000);	
		WebElement save2 = driver.findElement(By.xpath("//span[text()='Save']"));
		driver.executeScript("arguments[0].click();", save2);

		Thread.sleep(3000);	
		WebElement openTaskDropDwn2 = driver.findElement(By.xpath("//button[@title='Select a List View: Tasks']"));
		ac.moveToElement(openTaskDropDwn2).click().perform();

		Thread.sleep(3000);
		WebElement openTask1 = driver.findElement(By.xpath("//span[text()='Open Tasks']"));
		ac.moveToElement(openTask1).click().perform();

		String subject = driver.findElement(By.xpath("//tbody//tr[1]//th")).getText();
		String name = driver.findElement(By.xpath("//tbody//tr[1]//td[3]")).getText();

		if (subject.contains("Maps") && name.contains("Gokul")) {

			System.out.println("CLone Successfull");
		}

	}

}
