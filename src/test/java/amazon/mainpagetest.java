package amazon;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.iphonelandingpage;
import pageobjects.mainpage;

import resources.driverinit;

public class mainpagetest extends driverinit {
	public static Logger log=LogManager.getLogger(mainpagetest.class.getName());
	public WebDriver driver;
	mainpage mp;
	
	@Test(priority=0)
	public void stockunavailtext()
	{
		Assert.assertTrue(mp.statustext().getText().equalsIgnoreCase(prop.getProperty("status")));
		
	}
	@Test(priority=1)
	public void colourcheck() throws InterruptedException
	{
		mp.colourclick(prop).click();;
		Assert.assertTrue(mp.colourselected().getText().contains(prop.getProperty("colour")));
		
	}
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver=base();
		driver.get(prop.getProperty("url"));
		Homepage hp=new Homepage(driver);
		iphonelandingpage ip=new iphonelandingpage(driver);
		hp.searchbox().sendKeys(prop.getProperty("search"));
		hp.Go().click();
		ip.clickiphone(prop).click();
		mp=new mainpage(driver);
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
}
