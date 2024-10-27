package Sprint_01;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class S6_85_Post_Deleted {

	public void createPay() throws InterruptedException {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Step 1: Login to Login | Salesforce
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.xpath("//a[text()='Home']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='File']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Select a file from Salesforce']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		List<String> windowStrings = new ArrayList<>(windowHandles);
		String reqWindow = windowStrings.get(1);
		driver.switchTo().window(reqWindow);

		driver.findElement(By.xpath("//span[text()='Owned by Me']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search Files I Own...']")).sendKeys("Maven");
		driver.findElement(By.xpath("//a[@title='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Attach']")).click();
		driver.switchTo().window(parent);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@title='Share']")).click();
		driver.findElement(By.xpath("(//span[text()='More Actions'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='File Sharing Settings'])[1]")).click();
		driver.findElement(By.xpath("(//td[contains(@class, 'overlay')]//span[@class='permissionLabel'])[1]")).click();
		WebElement collabolators = driver.findElement(By.xpath("//span[contains(text(), 'Coll')]"));
		if (collabolators.isDisplayed()) {

			System.out.println("Collabolators Already Enabled");
		} else {
			driver.executeScript("argumeants[0].click();", collabolators);
		}

		WebElement checkbox = driver.findElement(By.xpath("//input[@id='sharingOption']"));

		if (checkbox.isSelected()) {
			System.out.println("Already Enabled");

		} else {
			checkbox.click();
		}
		driver.findElement(By.xpath("//input[@value='Close']")).click();

		driver.findElement(By.xpath("//a[text()='Click to add topics:']")).click();
		WebElement topicInput = driver.findElement(By.xpath("//div[@class='topicInput']"));
		driver.executeScript("arguments[0].value = 'Maven Installation Guide';", topicInput);
		driver.findElement(By.xpath("//input[@title='Done']")).click();

		String mavenVerify = driver.findElement(By.xpath("(//span[@class='contentTitleLink'])[1]"))
				.getText();
		if (mavenVerify.contains("Maven")) {
			System.out.println("Topic Verified");
		}

		driver.findElement(By.xpath("(//a[@title='More Actions'])[1]")).click();
		driver.findElement(By.xpath("(//a[@title='Delete this post'])[1]")).click();
		
	Thread.sleep(3000);
		Set<String> windowHandles2 = driver.getWindowHandles();
		String parent2 = driver.getWindowHandle();
		List<String> windowStrings2 = new ArrayList<>(windowHandles2);
		String reqWindow2 = windowStrings2.get(1);
		
		driver.switchTo().window(reqWindow2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='OK']")).click();
		
		
		
		

	}
}