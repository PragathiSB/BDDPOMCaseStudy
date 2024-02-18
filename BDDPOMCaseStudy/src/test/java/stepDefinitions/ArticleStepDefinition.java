package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateNewArticlePage;
import pages.Dashboard;
import pages.EditPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ViewArticlePage;

public class ArticleStepDefinition {
	WebDriver driver;
    HomePage homepage;
    LoginPage loginPage;
    Dashboard dashboard;
    CreateNewArticlePage crnwArticle;
    ViewArticlePage upArticle;
    EditPage edpage;
    
    public ArticleStepDefinition()
    {TestBase.initDriver();
	  driver=TestBase.getDriver();
    	
    	 homepage=new HomePage(driver);
		  loginPage=new LoginPage(driver); 
		  dashboard=new Dashboard(driver);
		  crnwArticle=new CreateNewArticlePage(driver);
		  upArticle=new ViewArticlePage(driver);
		  edpage=new EditPage(driver);
    }

    @Given("User is on the login Page")
    public void user_is_on_login_page() {
       TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/");
       homepage.login();
       Assert.assertEquals(loginPage.getTitle(),"Sign in");
       
    }
    @When("User enter Valid Credentials")
    public void user_enter_valid_credentials(DataTable dataTable) {
    	List<Map<String,String>> users=dataTable.asMaps();
    	String email=users.get(0).get("emailid");
    	String psd=users.get(0).get("password");
    	loginPage.login(email, psd);
        
    }
    @Then("Should display the success login message")
    public void should_display_the_success_login_message() {
    	String name=driver.findElement(By.xpath("//div[contains(text(),'pragathi')]")).getText();
		Assert.assertEquals(name,"pragathi");
    }
    
    @Given("User is on login Page")
    public void user_is_on_login_page1() {
    	 TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/");
         homepage.login();
         Assert.assertEquals(loginPage.getTitle(),"Sign in");
    }
    @When("User enter inValid credentials")
    public void user_enter_in_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
    	List<Map<String,String>> users1=dataTable.asMaps();
    	String email=users1.get(0).get("emailid");
    	String psd=users1.get(0).get("password");
    	loginPage.login(email, psd);
    }
    @Then("Should display the invalid login message")
    public void should_display_the_invalid_login_message(io.cucumber.datatable.DataTable dataTable) {
    	List<String> msgs=dataTable.asList();
		String expMsg=msgs.get(0);
    	 Assert.assertEquals(loginPage.inValidMsg(),expMsg);
    }
    
    @Given("User is on newArticleCreationPage")
    public void user_is_on_new_article_creation_page() {
    	dashboard.navigateToNewArticlePage(); 
    }
    @When("User Create the duplicate article")
    public void user_create_the_duplicate_article(DataTable dataTable) {
    	List<Map<String,String>> article=dataTable.asMaps();
    	 String articletitle=article.get(0).get("articleTitle");
		 String description=article.get(0).get("description");
		 String	body=article.get(0).get("body");
		 String tags=article.get(0).get("tags");
		 dashboard.navigateToNewArticlePage(); 
		 crnwArticle.createNewArticle(articletitle,description,body,tags);
    }
    @Then("Should display the duplicate article message")
    public void should_display_the_duplicate_article_message() {
    	 Assert.assertEquals(crnwArticle.duplicateArticleMsg(),"Title already exists..");
    }
    
    @Given("User is on the newArticleCreationPage")
    public void user_is_on_new_article_creation_page1() {
    	dashboard.navigateToNewArticlePage(); 
    }
    @When("User create the new Article")
    public void user_create_the_new_article(io.cucumber.datatable.DataTable dataTable) {
    	List<Map<String,String>> article=dataTable.asMaps();
   	     String articletitle=article.get(0).get("articleTitle");
		 String description=article.get(0).get("description");
		 String	body=article.get(0).get("body");
		 String tags=article.get(0).get("tags");
		 crnwArticle.createNewArticle(articletitle,description,body,tags);
    }
    @Then("Should display the new Article Title")
    public void should_display_the_new_article_title() {
    	 Assert.assertEquals(upArticle.getHeading(),"arti");
    }
    
    @Given("User is on updateArticlePage")
    public void user_is_on_update_article_page(DataTable dataTable) {
    	List<Map<String,String>> article=dataTable.asMaps();
    	String articleTitle=article.get(0).get("articleTitle");
    	System.out.println(articleTitle);
    	dashboard.navigateToglobalFeed();
    	WebElement search=dashboard.locateArticle(articleTitle);
    	dashboard.searchArticle(search);
    	 upArticle.navigateToEditArticle();
       
    }
    @When("User Update the Article")
    public void user_update_the_article(io.cucumber.datatable.DataTable dataTable) {
    	List<Map<String,String>> article=dataTable.asMaps();
    	String articleBody=article.get(0).get("articleBody");
    	 edpage.update(articleBody);
    }
    @Then("Should display the updated Article Title")
    public void should_display_the_updated_article_title() {
    	 Assert.assertEquals(upArticle.upBody(),"automation in testing");
    }
    
    @Given("User is on deleteArticlePage")
    public void user_is_on_delete_article_page(DataTable dataTable) {
    	List<Map<String,String>> article1=dataTable.asMaps();
    	String articleTi=article1.get(0).get("articleTitle");
    	System.out.println(articleTi);
   
    	dashboard.navigateToglobalFeed();;
    
    	WebElement search=dashboard.locateArticle(articleTi);
    	dashboard.searchArticle(search);
    }
    @When("User delete the Article")
    public void user_delete_the_article() {
    	upArticle.deleteArticle();
    }
    @Then("should the article to be deleted")
    public void should_the_article_to_be_deleted() {
    	Assert.assertEquals(upArticle.deleteCheck(), "Articles not available.");
    }  
}
