package pageobjects;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.driverinit;

public class mainpage extends driverinit{
	public WebDriver driver;
	
	public mainpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//span[@class='a-size-medium a-color-price qa-availability-message']")
	private WebElement unavailabletext;
	private By colour = By.xpath("(//ul[@class='a-unordered-list a-nostyle a-button-list a-horizontal a-spacing-top-mini'])[1]/li");
	@FindBy(xpath="(//span[@class='twisterSelection qa-twister-selection'])[1]")
	private WebElement selectedcolour;
	
public WebElement statustext()
{
	return unavailabletext;
}
public WebElement colourselected()
{
	return selectedcolour;
}
public WebElement colourclick(Properties prop) throws InterruptedException
{
	WebDriverWait w=new WebDriverWait(driver, 5);
	w.until(ExpectedConditions.visibilityOfElementLocated(colour));
	WebElement colourneeded = null;
	List<WebElement> count=driver.findElements(colour);
	for(int i=0;i<count.size();i++)
	{
		
		if(count.get(i).getAttribute("title").contains(prop.getProperty("colour")))
		{
			colourneeded=count.get(i);
		}
			
	}
	return  colourneeded;
}
}
