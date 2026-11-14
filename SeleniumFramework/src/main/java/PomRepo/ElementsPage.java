package PomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseTest;

public class ElementsPage extends BaseTest {
	
	WebDriver driver;
	public ElementsPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(xpath="//button[@data-target=\"#elements\"]")
	private WebElement elementbtn;
	
	@FindBy(xpath="//a[text()='text box']")
	private WebElement TextBoxBtn;
	
	public void clickonElementTab()
	{
		clickele(elementbtn);
		
		
	}
	
	

	public void clickontextBox()
	{
		clickele(TextBoxBtn);
		
		
	}
}
