package Sprint_01;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

@Test
public class S6_46_Delete_Attachmen_Campaign extends BaseClass_Parikshit {

	public void editCampaign() throws InterruptedException, MalformedURLException {

//		EdgeOptions options = new EdgeOptions();
//		DesiredCapabilities dc = new DesiredCapabilities(options);
//		dc.setBrowserName("MicrosoftEdge");
//		dc.setPlatform(Platform.LINUX);
//		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);
//
//		 ChromeOptions chromeOptions = new ChromeOptions();
//		 chromeOptions.addArguments("--disable-notifications");
//		 ChromeDriver driver = new ChromeDriver(chromeOptions);
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

		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		WebElement campaigns = driver.findElement(By.xpath("//a[@title='Campaigns']"));
		driver.executeScript("arguments[0].click();", campaigns);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();

		Thread.sleep(3000);
		WebElement attach = driver
				.findElement(By.xpath("//span[@class='view-all-label']//following::span[text()='Attachments']"));
		driver.executeScript("arguments[0].click();", attach);

		Thread.sleep(3000);
		WebElement drpdown = driver.findElement(By.xpath("(//tbody//tr[1]//th)[3]//following::a[@role='button']"));
		driver.executeScript("arguments[0].click();", drpdown);

		Thread.sleep(3000);
		WebElement dele = driver.findElement(By.xpath("//div[@title='Delete']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(dele).click().perform();

		Thread.sleep(3000);
		WebElement delecConfirm = driver.findElement(By.xpath("//span[text()='Delete']"));
		ac.moveToElement(delecConfirm).click().perform();

		Thread.sleep(3000);
		String SuccessMesg = driver
				.findElement(By.xpath("(//div[@role='alert'])[3]//following::span[contains(@class,'toastMessage')]"))
				.getText();
		System.out.println(SuccessMesg);
		driver.quit();

	}

}
