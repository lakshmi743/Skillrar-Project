package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryHomePage {
	
	//Declaration
	@FindBy(xpath="//img[@class='SkillRary']")
	private WebElement logo;
	
	@FindBy(xpath="//a[text()='GEARS']")
	private WebElement gearsTab;
	
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu')]/descendant::a[text()='SkillRary Demo App']")
	private WebElement skillraryDempAppLink;
	
	@FindBy(xpath="//ul[contains(@class,'home_menu')]/li[1]")
	private WebElement language;
	
	@FindBy(xpath="//ul[contains(@class,'home_menu')]/descendant::a[text()='English']")
	private WebElement english;
	
	//Initialization
	public SkillraryHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getLogo() {
		return logo;
	}
	
	public void clickGearsTab() {
		gearsTab.click();
	}
	
	public void clickSkillraryDemoApp() {
		skillraryDempAppLink.click();
	}
	
	public void chooseEnglish() {
		language.click();
		english.click();
	}
}
