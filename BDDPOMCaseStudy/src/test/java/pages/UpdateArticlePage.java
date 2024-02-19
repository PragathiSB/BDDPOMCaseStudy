package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateArticlePage {

	@FindBy(xpath="(//a[contains(text(),' Edit Article')])[1]")
    WebElement editBtn;
    @FindBy(xpath="//input[@placeholder='Article Title']")
    WebElement articleTitle;
    @FindBy(xpath="//input[@class='form-control ' and @name='description']")
    WebElement description;
    @FindBy(xpath="//textArea[@name='body']")
    WebElement body;
    @FindBy(xpath="//input[@placeholder='Enter tags']")
    WebElement tag;
    @FindBy(xpath="//button[contains(text(),'Update Article')]")
    WebElement updateBtn;    
     @FindBy(xpath="(//a[@href='#/'])[2]")
     WebElement home;
     @FindBy(xpath="(//button)[2]")
     WebElement globalFeed;

     @FindBy(xpath = "(//a[@class='author'])[1]")
 	WebElement profile;
     
     public WebElement articleTitleElement(WebDriver driver,String articleTitle) {
    	 WebElement ele=driver.findElement(By.xpath("//h1[contains(text(),'"+articleTitle+"')]"));
    	 return ele;
     }
     public WebElement getUpdateArticleElement(WebDriver driver,String articleBody) {
    	 WebElement ele=driver.findElement(By.xpath("//p[contains(text(),'"+articleBody+"')]"));
    	 return ele;
     }
     public  UpdateArticlePage(WebDriver driver) {
    	 PageFactory.initElements(driver,this);
     }
     public void homePage() {
    	 home.click();
    	 globalFeed.click();
     }
	public void update(WebElement articleTitle,String text) {
		     articleTitle.click();
	         editBtn.click();   
	    	 body.clear();
	    	 body.sendKeys(text);  
	    	 updateBtn.click();
 }
	public String updateArticleValidate(WebElement check) {
		return check.getText();
	}
	
	
	public void navigateToProfile()
	{
			profile.click();
		
	}
	
	
}
