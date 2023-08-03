package DataDriven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_CloudTesla {
	@Test(dataProvider = "yash")
	public void action(String Name, String Client_ID, String Ph_No, String Email, String Username, String Description, String Password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://e2e.cloudtesla.com/");
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sign up')]")));
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
		driver.findElement(By.id("firstName")).sendKeys(Name);
		driver.findElement(By.id("lastName")).sendKeys(Client_ID);
		driver.findElement(By.id("mobile")).sendKeys(Ph_No);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.id("desc")).sendKeys(Description);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(2000);
		driver.quit();
	}
	@DataProvider(name="yash", parallel = true)
	public Object[][] testing() throws EncryptedDocumentException, IOException
	{
		return ExcelData_CloudTesla.registerdata("RegisterData");
	}
}
