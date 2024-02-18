package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Dashboard {
    WebDriver driver;

	@FindBy(xpath="//a[text()='New Article']")
	WebElement newArticle;
	
	@FindBy(xpath="//div[contains(text(),'pragathi')]")
	WebElement username;
	
	@FindBy(xpath="//a[text()='conduit']")
	WebElement title;
	
	@FindBy(xpath="//button[text()='Global Feed']")
	WebElement globalFeedBtn;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement homeBtn;
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public void navigateToNewArticlePage()
	{
		newArticle.click();
	}
	public String username()
	{
		return username.getText();
	}
	
	public String getTitle()
	{
		return title.getText();
	}
	
	public WebElement locateArticle(String articleTitle)
	{
		WebElement search=driver.findElement(By.xpath("//h1[contains(text(),'"+articleTitle+"')]"));
		return search;
	}
	
	public void navigateToglobalFeed()
	{
		homeBtn.click();
		globalFeedBtn.click();
	}
	

	public void searchArticle(WebElement search)
	{
		search.click();
	}

}
