package excelUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositCalculator2 {

	//@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		
		
	
		WebElement dep=driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
		WebElement rate=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		WebElement len=driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		
		WebElement cal=driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));
		System.out.println("user has identified all elements to calculate CD");
		
		String file=System.getProperty("user.dir")+"\\testdata\\caldata2.xlsx";
		int rows=ExcelUtils.getRowCount(file, "Sheet1");
		System.out.println("row count is : " + rows);
		
		for(int i=1;i<=rows;i++)
		{
			//read data from excel
			String deposit=ExcelUtils.getCellData(file,"Sheet1",i,0);
			String rateofinterest=ExcelUtils.getCellData(file,"Sheet1",i,1);
			String length=ExcelUtils.getCellData(file,"Sheet1",i,2);
			String compounding=ExcelUtils.getCellData(file,"Sheet1",i,3);
			String total=ExcelUtils.getCellData(file,"Sheet1",i,4);
			//String exp_mvalue=ExcelUtils.getCellData(file,"Sheet1",i,5);
			
				
			//pass data to the app
			
			
			
			dep.clear();
			len.clear();
			rate.clear();
			Thread.sleep(3000);
			
			dep.sendKeys(deposit);
			len.sendKeys(length);
			rate.sendKeys(rateofinterest);
			
			WebElement compoundrp = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));   //select class object compounddrp will find elelment by id
			compoundrp.click();
			List<WebElement>cmpd=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			
			for(WebElement cmpds:cmpd) {
				
				if(cmpds.getText().equals(compounding)) 
					cmpds.click();
				
			}
				//Thread.sleep(3000);
			cal.click();
			
			String totalamt=driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			System.out.println("act total is: " + totalamt);
			System.out.println("exp total is: " + total);
				//Thread.sleep(3000);
						
			//validation & update results in excel
			
			
			if(total.equals(totalamt))
			{
				System.out.println("Test Passsed");
				ExcelUtils.setCellData(file, "Sheet1",i,6,"Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1",i,6);
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(file, "Sheet1",i,6,"Failed");
				ExcelUtils.fillRedColor(file, "Sheet1",i,6);
			}
					
			}
		System.out.println("calculation has been completed");
		driver.close();
	}

}
