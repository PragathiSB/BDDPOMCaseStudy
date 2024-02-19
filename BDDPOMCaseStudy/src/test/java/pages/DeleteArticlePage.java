package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteArticlePage {

	WebDriver driver;
	@FindBy(xpath = "//button[@class='btn btn-sm'][1]")
	WebElement deleteBtn;
	@FindBy(xpath="//div[contains(text(),'Articles not available.')]")
	WebElement check;
	@FindBy(xpath="(//a[@href='#/'])[2]")
    WebElement home;
    @FindBy(xpath="(//button)[2]")
    WebElement globalFeed;
    @FindBy(xpath = "(//a[@class='author'])[1]")
   	WebElement profile;

	 public DeleteArticlePage(WebDriver driver) {
		 this.driver=driver;
	 		PageFactory.initElements(driver,this);
	 }
	 public void home() {
		 home.click();
		 globalFeed.click();
	 }
	 public WebElement locateDelArticle(WebDriver driver,String articleTitle) {
		WebElement articleToDelete=driver.findElement(By.xpath("//h1[contains(text(),'"+articleTitle+"')]"));
		 return articleToDelete;

	 }
	 public void deleteArticle(WebElement deleteTitle)
	 {
			deleteTitle.click();
		    deleteBtn.click();
			Alert alert=driver.switchTo().alert();
			alert.accept();
	 }
	 public String deleteCheck() {
		 return check.getText();
	 }
	 
	 public void navigateToProfile()
	 {
			profile.click();
     }
}
