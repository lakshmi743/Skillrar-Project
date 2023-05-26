package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * This class contains all reusable methods to perform operations on webDriver
 */
public class WebDriverUtility {
	private WebDriver driver;
	
	
	
	/**
	 * This method is used to launch the browser and navigate to application
	 * @param browser
	 * @param url
	 * @param time
	 * @return 
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		default:
			System.out.println("Invalid browser data");
		}
		return driver;
	}
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	public void navigateToApp(String Url) {
		driver.get(Url);
	}
	public void waitUntilElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
		
	public WebElement explicitWait(Duration time,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement explicitWait(WebElement element,Duration time) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean explicitWait(Duration time,String title) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		return wait.until(ExpectedConditions.titleContains(title));
	}

	public void mouseHover(WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to right click on an element
	 * @param element
	 */
	
	public void doubleClickOnElement(WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void rightClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	/**
	 * This method is used to dra and drop an element to dest
	 * @param element
	 * @param target
	 */
	
	public void dragAndDropElement(WebElement element, WebElement dest) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element, dest).perform();
	}
	
	
	
	/**
	 * This method is used to select an element from drop down based on index
	 * @param element
	 * @param index
	 */
	
	public void dropdown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void dropdown(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	public void dropdown(String text, WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to switch to frame on index
	 * @param index
	 */
	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to scroll till element using element reference
	 * @param element
	 */
	
	public void scrollToElement() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)");
	}
	
	/**
	 * This method is used to capture the screenshot of a web page
	 * @param javaUtil
	 */
	
	public void takeScreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/screenshot.png");
		try {
			FileUtils.copyFile(src,dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to handle alert pop up
	 * @param status
	 */
	
	public void handleAlert(String status) {
		Alert a1=driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
			a1.accept();
		else
			a1.dismiss();
	}
	
	/**
	 * This method is used to switch to parent window
	 */
	
	public void switchToParentWindow() {
		String parentID=driver.getWindowHandle();
		driver.switchTo().window(parentID);
	}
	
	/**
	 * This method is used to hablde child browser pop up
	 */
	public void handleChildBrowser() {
		Set<String> set=driver.getWindowHandles();
		for(String wId:set) {
			driver.switchTo().window(wId);
		}
	}
	
	/**
	 * This method is used to close current tab or window
	 */
	public void closeCurrentTab() {
		driver.close();
	}
	
	/**
	 * This method is used to close all tabs and quit the browser																									
	 */
	
	public void quitAllwindows() {
		driver.quit();
	
	}
	public void scrollToElement(WebElement contactUs) {
		// TODO Auto-generated method stub
		
	}
}


