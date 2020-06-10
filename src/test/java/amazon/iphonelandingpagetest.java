package amazon;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.iphonelandingpage;
import resources.driverinit;

public class iphonelandingpagetest extends driverinit {
	
	public static Logger log=LogManager.getLogger(iphonelandingpagetest.class.getName());
	public WebDriver driver;
	iphonelandingpage ip;
	
	
	@Test(priority=0)
	public void checkboxtest() throws InterruptedException, IOException
	{
		Assert.assertTrue(ip.brandcheckboxcount()==12);
		log.info("brand has "+ip.brandcheckboxcount()+" checkboxes");
	}
	@Test(priority=1)
	public void resultcheck()
	{
		Assert.assertTrue(ip.iphonecheck().getText().contains(prop.getProperty("search")));
	}
	@Test(priority=2) 
	public void no_of_footerlinks()
	{
		
		Assert.assertTrue(ip.footerlinkscount()==36);
		log.info("footer has "+ip.footerlinkscount()+" links");
	}
	@Test(priority=3)
	public void eastdanecheck()
	{
		
		Assert.assertTrue(ip.eastdanecheck().getText().contains("East Dane"));
	}
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=base();
		driver.get(prop.getProperty("url"));
		log.info("url invoked");
		ip=new iphonelandingpage(driver);
		Homepage hp=new Homepage(driver);
		hp.searchbox().sendKeys(prop.getProperty("search"));
		hp.Go().click();
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
