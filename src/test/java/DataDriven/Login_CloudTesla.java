package DataDriven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_CloudTesla {
	@Test(dataProvider = "Yash")
	public void loginaction(String Email, String Password, String Result) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://e2e.cloudtesla.com/");
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		System.out.println(Email+" and "+Password+" Result is "+Result);
		Thread.sleep(1000);
		driver.quit();
	}
	@DataProvider(name="Yash", parallel = true)
    public Object[][] testinglogin() throws EncryptedDocumentException, IOException
	{
		return ExcelData_LoginCT.logindata("LoginData");
	}
}
