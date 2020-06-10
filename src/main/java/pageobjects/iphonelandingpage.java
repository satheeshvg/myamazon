package pageobjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.driverinit;

public class iphonelandingpage extends driverinit {
	
	public WebDriver driver;
	public iphonelandingpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='brandsRefinements']")
	private WebElement brandcolumn;
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	private WebElement resultsfor;
	@FindBy(xpath="//div[@class='navFooterLine navFooterLinkLine navFooterDescLine']")
	private WebElement footer;
	@FindBy(xpath="//td[@class='navFooterDescItem']")
	private WebElement linksinfooter;
	@FindBy(xpath="//table[@class='navFooterMoreOnAmazon']/tbody/tr[7]/td[5]/a")
	private WebElement eastdane;
	private By iphone =By.xpath("//div[@class='a-section a-spacing-none']/h2/a");
	private By checkbox =By.xpath("//div[@id='brandsRefinements']/ul/li/span/a/div");
	public int brandcheckboxcount() throws InterruptedException
	{	
		
		WebDriverWait w=new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='brandsRefinements']")));
		List<WebElement> count=driver.findElements(checkbox);
		return count.size();
	}
	public WebElement iphonecheck()
	{
		return resultsfor;
	}
	public int footerlinkscount()
	{
	List<WebElement> footerlinks=footer.findElements(By.xpath("//td[@class='navFooterDescItem']"));
		return footerlinks.size();
	}
	public WebElement eastdanecheck()
	{
		return eastdane;
	}
	public WebElement clickiphone(Properties prop) throws InterruptedException
	{
		WebDriverWait w=new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(iphone));
		WebElement iphoneneeded = null;
		List<WebElement> count=driver.findElements(iphone);
		for(int i=0;i<count.size();i++)
		{
			if(count.get(i).getText().equalsIgnoreCase(prop.getProperty("iphone")))
			{
				iphoneneeded=count.get(i);
			}
		}
		return iphoneneeded;
	}
}

