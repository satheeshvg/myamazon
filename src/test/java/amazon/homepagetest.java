package amazon;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.Homepage;
import resources.driverinit;

public class homepagetest extends driverinit {

	public static Logger log=LogManager.getLogger(homepagetest.class.getName());
	public WebDriver driver;
	Homepage hp;
	Actions a;
	SoftAssert soft=new SoftAssert();
	@Test(priority=0)
	public void Checktext()
	{
		
		
		a.moveToElement(hp.hellosignin()).build().perform();
		Assert.assertTrue(hp.yourlisttext().getText().equalsIgnoreCase("Your Lists"));
		
		Assert.assertTrue(hp.youraccounttext().getText().equalsIgnoreCase("Your Account"));
		
	}
	
	@Test(priority=1)
	public void Nooflinks() throws InterruptedException
	{
		System.out.println(hp.yourlistlinks());
		Assert.assertTrue(hp.yourlistlinks()==14);
		log.info("yourlist has "+hp.yourlistlinks()+" links");
		Assert.assertTrue(hp.youraccountlinks()==17);
		log.info("youraccount has "+hp.youraccountlinks()+" links");
	
		
	}
	
	@Test(priority=2)
	public void Headercheck()
	{	
		
		
		a.moveToElement(hp.searchbox()).build().perform();
		Assert.assertTrue(hp.headerlinks()==5);
		Assert.assertTrue(hp.todaydealtext().getText().equalsIgnoreCase("Today's Deals"));
		Assert.assertTrue(hp.customerservicetext().getText().equalsIgnoreCase("Customer Service"));
		Assert.assertTrue(hp.gifttext().getText().equalsIgnoreCase("Gift Cards"));
		Assert.assertTrue(hp.registry().getText().equalsIgnoreCase("Registry"));
		Assert.assertTrue(hp.selltext().getText().equalsIgnoreCase("Sell"));
		log.info("Header validated successfully");
		
	}
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=base();
		driver.get(prop.getProperty("url"));
		log.info("url invoked");
		hp=new Homepage(driver);
		a=new Actions(driver);
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
