package Sprint_01;

import java.time.Duration;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


@Test
public class PieChartIssue{

	public void newChart() throws InterruptedException, MalformedURLException {
		
		
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			ChromeDriver driver = new ChromeDriver(option);
			driver.get("https://testleaf-7b-dev-ed.develop.lightning.force.com/lightning/o/Task/list?filterName=OpenTasks");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Leaf@123");
			driver.findElement(By.id("Login")).click();
			driver.findElement(By.xpath("//button[@title='Select list display']")).click();
			driver.findElement(By.xpath("//li[@title='Display as table']")).click();
			driver.findElement(By.xpath("//button[@aria-label='Charts']")).click();
			Thread.sleep(2000);
			WebElement canvasEle = driver.findElement(By.xpath("//h2[text()='Charts']"));
			Actions action = new Actions(driver);
			action.moveToLocation(1300, 400).pause(2000).click().perform();

		
		
		
	}}