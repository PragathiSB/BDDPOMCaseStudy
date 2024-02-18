package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {

	@FindBy(xpath="//button[text()='Update Article']")
	WebElement updateBtn;
	
	@FindBy(xpath="//input[@name='description']")
	WebElement description;
	
	@FindBy(xpath="//textarea[@name='body']")
	WebElement body;
	
	public EditPage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
	}
	public void update(String artiBody)
	{
		body.clear();
		body.sendKeys(artiBody);
		updateBtn.click();

		
	}

}
