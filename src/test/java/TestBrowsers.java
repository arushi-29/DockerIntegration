import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestBrowsers {

	public static WebDriver driver;
	public static WebDriverWait wait;
	static String testurl = "https://google.com";

	@Parameters({"browser"})
	@BeforeClass
	public static void FirstRun(String Browser) throws Exception 
	{
		if(Browser.equalsIgnoreCase("chrome"))
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			caps.setCapability("zal:name", "NewTestName");
			caps.setCapability("zal:build", "NewTestBuild");
			caps.setCapability("zal:tz", "Europe/Berlin");
			caps.setCapability("zal:screenResolution", "1280x720");
			caps.setCapability("zal:idleTimeout", 180);
			caps.setCapability("zal:recordVideo", false);  
			
			try
			{
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	@Test(priority = 0)
	public static void TestIntegration() {

		driver.get(testurl);
		wait = new WebDriverWait(driver, 40);
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	}

}