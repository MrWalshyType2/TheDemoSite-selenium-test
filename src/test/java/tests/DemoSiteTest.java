package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSiteTest {

	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\morga\\OneDrive\\Documents\\QA\\TheDemoSite\\src\\test\\resources\\drivers\\chromedriver84.exe");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void createLoginTest() throws InterruptedException {
		String url = "http://thedemosite.co.uk/";
		String username = "Bobbyo";
		String password = "Bobbyo123";
		
		driver.get(url);
		
		// Redirect to Add a user page
		WebElement addUserBtn = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUserBtn.click();
		
		// Get elements to add a user
		WebElement userNameField = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		WebElement passwordField = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		WebElement saveBtn = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		
		// Send content to add a user
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		saveBtn.click();
		
		// redirect to login page
		WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		loginBtn.click();
		
		// Get elements for login
		WebElement loginUsernameField = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		WebElement loginPasswordField = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		WebElement testLoginBtn = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		
		// Send content to login
		loginUsernameField.sendKeys(username);
		loginPasswordField.sendKeys(password);
		testLoginBtn.click();

		Thread.sleep(3000);
		
		String expected = "Login example page to test the PHP MySQL online system";
		assertEquals(expected, driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
