import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTestAutomation {
	String driverPath = "(Add the path to geckodriver.exe here)";
	public WebDriver browser;
	
	@Test
	public void TestCaseOne() throws InterruptedException {
		System.out.println("Launching Firefox Browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		browser = new FirefoxDriver();
		//Go to www.google.com
		browser.get("https://www.google.com/");
		//Go to the search box
		WebElement search = browser.findElement(By.name("q"));
		//Type 'GMAIL' in the search box
		search.sendKeys("GMAIL");
		//Hit enter/search
		search.submit();
		//Stop the execution until the page loads
		Thread.sleep(5000);
		//go to 'Email from Google'
		browser.findElement(By.xpath("/html/body/div[5]/div[2]/div[9]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[7]/div/div[1]/a")).click();
		//Stop the execution until the page loads
		Thread.sleep(2000);
		//go to 'Sign-in' page
		browser.findElement(By.id("gmail-sign-in")).click();
		//Stop the execution until the page loads
		Thread.sleep(2000);
		//Go to the 'Email or Phone' box
		WebElement username = browser.findElement(By.id("identifierId"));
		//Type username/email
		username.sendKeys("xxxxxxxxxx@gmail.com");  //Enter a valid email address
		//Hit 'Next'
		browser.findElement(By.id("identifierNext")).click();
		//Stop the execution until the page loads
		Thread.sleep(2000);
		//Go to the 'Enter your password' box
		WebElement password = browser.findElement(By.name("password"));  
		//Type password
		password.sendKeys("xxxxxxxx"); //Enter the correct password
		//Hit Next
		browser.findElement(By.id("passwordNext")).click();
		//Stop the execution until the page loads
		Thread.sleep(2000);
		//After click on next, will be directed to 'Verify it's you' page
		//Verify "Username" tab
		String expectedUsername = "xxxxxxxxxx@gmail.com";  //Enter the above mentioned email
		//Switch account tab contains the username of the account that we just logged in
		String switchAccount = browser.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div")).getAttribute("aria-label");
		//This tab contains the text 'xxxxxxxxxx@gmail.com selected. Switch account'
		//Let's get only the username part from that text as the actual username
		String actualUsername = switchAccount.split(" ")[0];
		//Check whether expected and actual usernames are equal
		Assert.assertEquals(actualUsername, expectedUsername);
		browser.close();
	}
}