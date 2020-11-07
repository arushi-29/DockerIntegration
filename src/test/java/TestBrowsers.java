import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestBrowsers {

	public static WebDriver driver;
	public static WebDriverWait wait;
	String testurl = "https://google.com";

	@Parameters({"browser"})
	@BeforeClass
	public static void FirstRun(String Browser) throws Exception 
	{
		if(Browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.setCapability(ChromeOptions.CAPABILITY, options);
			options.setCapability("browserName", "chrome");
			options.setCapability("acceptSslCerts", "true");
			options.setCapability("javascriptEnabled", "true");		
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			options.merge(cap);
			try
			{
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	@Test(priority = 0)
	public static void TestIntegration() {

		wait = new WebDriverWait(driver, 40);
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.className("Tg7LZd")).sendKeys(Keys.ENTER);
		
	}

}