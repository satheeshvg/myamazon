package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Keyboard;

import pageobjects.Homepage;

public class driverinit {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver base() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\information.properties");
		prop.load(fis);
		if(System.getProperty("browser").contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver83.exe");
			 driver = new ChromeDriver();
		}
		if(System.getProperty("browser").contains("Internet"))
		{
			System.out.println("IT");
		}
		if(System.getProperty("browser").contains("firefox"))
		{
			System.out.println("firefox");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public void screenshot(String result, WebDriver driver) throws IOException
	{
		
		String path=System.getProperty("user.dir")+"\\reports\\"+result+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path));
		
	}
	
}
