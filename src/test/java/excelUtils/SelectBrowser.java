package excelUtils;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class SelectBrowser {
	 static WebDriver driver;
	 static Actions actions;
	     public static WebDriver StartBrowser(String browsername) 
	    		 throws InterruptedException {
	        // ---If the browser is Firefox----
	        if (browsername.equalsIgnoreCase("Firefox")) {
	            // Set the path for geckodriver.exe
	        	System.setProperty("webdriver.gecko.driver",
	        			"C:\\Drivers\\firefoxDriver\\geckodriver.exe");
	            driver = new FirefoxDriver();
	        }
	        //---- If the browser is Chrome--
	        else if (browsername.equalsIgnoreCase("Chrome")) {
	            // Set the path for chromedriver.exe
	            System.setProperty("webdriver.chrome.driver" ,
	            		"C:\\Drivers\\chromeDriver\\chromedriver.exe");
	            ChromeOptions options= new ChromeOptions();
	    		options.setExperimentalOption("excludeSwitches", 
	    				Arrays.asList("enable-automation"));
	    		options.addArguments("--remote-allow-origins=*");
	    		// Open browser
	    		//options.addArguments("--headless");
	    		driver=new ChromeDriver(options);
	    	actions = new Actions(driver);     
	            Thread.sleep(6000);
	        }
	        // ----If the browser is  EdgeIE----
	        else if (browsername.equalsIgnoreCase("EdgeExplore")) {
	            // Set the path for IEdriver

	            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/msedgedriver.exe");
	            // Instantiate a EdgeDriverclass.
	            EdgeOptions options = new EdgeOptions();
	            driver = new EdgeDriver(options);
	        }
	        driver.manage().window().maximize();
	        return driver;
	    }

}
