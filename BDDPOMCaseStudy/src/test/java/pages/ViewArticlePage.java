package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ViewArticlePage {
	
	WebDriver driver;
	@FindBy(xpath="(//button//a[text()=' Edit Article'])[2]")
	WebElement editBtn;
	
	@FindBy(xpath="(//button[text()=' Delete Article'])[2]")
    WebElement deleteBtn;
	
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement check;

	@FindBy(xpath="//h1[contains(text(),'arti')]")
	WebElement hdr;
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement chck;

	@FindBy(xpath="//textarea[@name='body']")
	WebElement body;
	
	public ViewArticlePage(WebDriver driver) 
	{ 
		this.driver=driver;
	
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToEditArticle()
	{
		editBtn.click();
	}
	
	public String getHeading()
	{
		return hdr.getText();
	}

	
}
