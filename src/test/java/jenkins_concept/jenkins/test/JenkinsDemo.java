package jenkins_concept.jenkins.test;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class JenkinsDemo {
	
	@Test
	public void test(Method mt) {
		
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports//VtigerExtentReport.html");
		extent.attachReporter(spark);
		
		ExtentTest extTest=extent.createTest(mt.getName());// fetch method name(testcase Name)

		extTest.log(Status.INFO, "Test has been started");
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		extTest.log(Status.INFO, "System setting of chrome diver has been set successfully");
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:8888");
		extTest.log(Status.INFO, "url is launched successfully");
		driver.manage().window().maximize();
		extTest.log(Status.INFO, "window is maximize successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		extTest.log(Status.INFO, "Implicitily wait is set for 20 seconds successfully");
		Actions act=new Actions(driver);
		act.sendKeys("admin",Keys.TAB).sendKeys("admin",Keys.ENTER).build().perform();
		extTest.log(Status.INFO, "user is logged in application");
		WebElement markWeb=driver.findElement(By.linkText("Marketing"));
		act.moveToElement(markWeb).perform();
		extTest.log(Status.INFO, "The Hover action on marketing is success by Actions class");
		driver.findElement(By.xpath("//div[@id='Marketing_sub']/descendant::a[text()='Accounts']")).click();
		extTest.log(Status.INFO, "Accounts buttons is clicked successfull");
		
		
		extent.flush();
		
		
	}

}
