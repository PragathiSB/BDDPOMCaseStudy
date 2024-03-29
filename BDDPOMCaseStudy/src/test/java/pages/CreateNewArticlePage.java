package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewArticlePage {
	
	@FindBy(xpath="//input[@name='title']")
	WebElement articletitle;
	
	@FindBy(xpath="//input[@name='description']")
	WebElement description;
	
	@FindBy(xpath="//textarea[@name='body']")
	WebElement body;
	
	@FindBy(xpath="//input[@name='tags']")
	WebElement tags;
	
	@FindBy(xpath="//button[text()='Publish Article']")
	WebElement publishBtn;
	
	@FindBy(xpath="//span[text()='Title already exists.. ']")
	WebElement invalidMsg;
	
	@FindBy(xpath="//h1[contains(text(),'arti')]")
	WebElement hdr;
	
	public CreateNewArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewArticle(String title,String artDes,String artBody,String artTag)
	{
		articletitle.clear();
		articletitle.sendKeys(title);
		description.clear();
		description.sendKeys(artDes);
		body.clear();
		body.sendKeys(artBody);
		tags.clear();
		tags.sendKeys(artTag);
		publishBtn.click();
		
	}
	
	public String duplicateArticleMsg()
	{
		return invalidMsg.getText();
	}
	
	public String getHeading()
	{
		return hdr.getText();
	}

}
