package pageobjects;


import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.driverinit;

public class Homepage extends driverinit {
	public WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
@FindBy(xpath="//a[@id='nav-link-accountList']")
private WebElement signin;
@FindBy(xpath="//div[@id='nav-al-title']")
private WebElement yourlist;
@FindBy(xpath="//div[text()='Your Account']")
private WebElement youraccount;
@FindBy(xpath="//div[@id='nav-al-wishlist']")
private WebElement totalyourlist;
@FindBy(xpath="//div[@id='nav-al-your-account']")
private WebElement totalyouraccount;
@FindBy(xpath="//div[@id='nav-xshop']")
private WebElement header;
@FindBy(xpath="//a[@tabindex='47']")
private WebElement todaydeal;
@FindBy(xpath="//a[@tabindex='48']")
private WebElement customerserv;
@FindBy(xpath="//a[@tabindex='49']")
private WebElement gift;
@FindBy(xpath="//a[@tabindex='50']")
private WebElement registry;
@FindBy(xpath="//a[@tabindex='51']")
private WebElement sell;
@FindBy(xpath="//input[@id='twotabsearchtextbox']")
private WebElement searchbox;
@FindBy(xpath="//input[@value='Go']")
private WebElement go;

public WebElement Go()
{
	return go;
}


public WebElement hellosignin()
{
	return signin;
}
public WebElement yourlisttext()
{
	return yourlist;
}
public WebElement youraccounttext()
{
	return youraccount;
}
public int yourlistlinks()
{
	WebDriverWait w=new WebDriverWait(driver, 4);
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-al-wishlist']")));
	 List<WebElement> count =totalyourlist.findElements(By.xpath("//div[@id='nav-al-wishlist']/a"));
	return count.size();
}
public int youraccountlinks()
{
	
	List<WebElement> count =totalyouraccount.findElements(By.tagName("a"));
	return count.size();
}
public int headerlinks()
{
	List<WebElement> count=header.findElements(By.xpath("//a[@class='nav-a  ']"));
	return count.size();
}
public WebElement todaydealtext()
{
	return todaydeal;
}
public WebElement customerservicetext()
{
	return customerserv;
}
public WebElement gifttext()
{
	return gift;
}
public WebElement registry()
{
	return registry;
}
public WebElement selltext()
{
	return sell;
} 
public WebElement searchbox()
{
	 return searchbox;
}



}
