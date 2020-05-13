package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;
	public Properties prop;
    public WebDriverWait wait;
    public static Select select ;
    public static Logger log = LogManager.getLogger(Base.class.getName());
    public WebDriver initializeDriver(String browser,String platform ) throws IOException
    {
	
       prop= new Properties();
       FileInputStream fis=new FileInputStream("src/main/java/resources/data.properties");
       prop.load(fis);

       if(browser.equals("chrome") && platform.equals("mac"))
       {
	      System.setProperty("webdriver.chrome.driver", "src/main/java/resources/drivers/browsers/chromedriver");
	      driver= new ChromeDriver();
       }
       else if(browser.equals("chrome") && platform.equals("windows"))
       {
           System.setProperty("webdriver.chrome.driver", "src/main/java/resources/drivers/browsers/chromedriver.exe");
           driver= new ChromeDriver();
       }
       else if (browser.equals("firefox"))
       {
	       driver= new FirefoxDriver();
	      //firefox code
       }
       else if (browser.equals("IE"))
       {
            //	IE code
       }

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       return driver;

}

public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	
}


    public WebDriver getDriver() {
        return driver;
    }
}
