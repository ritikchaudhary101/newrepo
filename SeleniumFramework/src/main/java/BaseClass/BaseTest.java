package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ExcelReader;
import Utils.commonutils;
import Utils.propertyreader;

public class  BaseTest implements propertyreader ,commonutils , ExcelReader {
	
	String configpath = "C:\\workspace\\java workspace\\SeleniumFramework\\src\\test\\resources\\Configdata\\config.properties";
	
	
	protected WebDriver driver;
	WebDriverWait wait;
	public void setUp(String browser , String env ) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			 driver = new ChromeDriver();
			}
		else if(browser.contentEquals("edge"))
		{
			 driver = new EdgeDriver();
		}
		if(env.equalsIgnoreCase("Qa")) {
		driver.get(getData(configpath, "QAurl"));
		}else if(env.equalsIgnoreCase("uat"))
		{
			
			driver.get(getData(configpath, "UATurl"));
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		}
	
	public void tearDown()
	{
		driver.quit();
		
	}
		 
	@Override
	public String getData(String path, String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
		
	}

	@Override
	public void clickele(WebElement ele) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		
	}

	@Override
	public void entervalue(WebElement ele , String value) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).sendKeys(value);

		
	}

	

	@Override
	public String getdata(String path, int sheetno, int row, int column) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
     XSSFSheet sheet	= wb.getSheetAt(sheetno);
     
	}
}
