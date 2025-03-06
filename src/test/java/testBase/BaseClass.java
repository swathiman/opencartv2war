package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups = {"Sanity","Regression","Master"})	
	@Parameters({"os","browser"})
	public void setup(String os,String browser) throws IOException
	{
		FileReader file= new FileReader("./src/test/resources//config.properties");
		p = new Properties();
		p.load(file);
		
		logger= LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
			DesiredCapabilities capabilities= new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("no matching os found");
				return;
			}
			switch(browser.toLowerCase())
			{
			case "chrome" :capabilities.setBrowserName("chrome");
						   break;
			case "edge"   :capabilities.setBrowserName("MicosoftEdge");
					       break;
			case "firefox":capabilities.setBrowserName("firefox");
			   break;
			
			default:System.out.println("invalid browser name");
			        return;
			}
			
			driver = new RemoteWebDriver(new URL(" http://10.0.0.123:4444/wd/hub"),capabilities);
		}
		
		
		
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{	
		
		
		switch(browser.toLowerCase())
		{
		case "chrome" :driver=new ChromeDriver();
					   break;
		case "edge"   :driver=new EdgeDriver();
				       break;
		case "firefox":driver=new FirefoxDriver();
					   break;
		default:System.out.println("invalid browser name");
		        return;
		
		}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		logger.info("got url from properties");
		driver.manage().window().maximize();
	}

	
	
	@SuppressWarnings("deprecation")
	public String randomString()
	{
		
		
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	@SuppressWarnings("deprecation")
	public String randomNumber()
	{
		
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
		
	}
	@SuppressWarnings("deprecation")
	public String randomAlphaNumeric()
	{
		
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return generatedString+"@"+generatedNumber;
	}
	
	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}



	public String captureScreen(String name) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		
TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
File targetFile=new File(targetFilePath);

sourceFile.renameTo(targetFile);
	
return targetFilePath;
	}



	
}
