package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver;
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//h1[text()='Sign in']")
	WebElement title;
	
	@FindBy(xpath="//ul[@class='error-messages']//li[text()='Wrong email/password combination']")
    WebElement invalidmsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String emailid,String pswd) 
	{
        email.clear();
		email.sendKeys(emailid);
		password.clear();
		password.sendKeys(pswd);
		loginBtn.click();
	}
	
	public String getTitle()
	{
		return title.getText();
	}
	
	public String inValidMsg()
	{
		return invalidmsg.getText();
	}
	
	public WebElement validUserName(WebDriver driver,String userName) {
    	WebElement ele=driver.findElement(By.xpath("//div[contains(text(),'"+userName+"')]"));
    	return ele;
    }
	
	
	public String checkInValidLogin() {
		   return invalidmsg.getText();
	   }
	
	public String checkValidLogin(WebElement ele) {
		return ele.getText();
	}
}
