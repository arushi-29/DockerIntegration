import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBrowsers {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeClass(alwaysRun = true)
	public static void FirstRun() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://google.com");
	}

	@Test(priority = 0)
	public static void Login() {

		wait = new WebDriverWait(driver, 40);
		driver.findElement(By.name("q")).sendKeys("Selenium");
	}

}