package Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import PomRepo.ElementsPage;

public class ElementTest extends BaseTest{
	
	ElementsPage ep;

	@Parameters({"browser" , "env"})
	@BeforeClass
	public void initialize(String browser , String env ) throws IOException
	{
	setUp(browser, env)	;
	ep= new ElementsPage(driver);	
		
	}
	
	@Test
	public void validateTextBox()
	{
		ep.clickonElementTab();
		ep.clickontextBox();
		
	}
}
