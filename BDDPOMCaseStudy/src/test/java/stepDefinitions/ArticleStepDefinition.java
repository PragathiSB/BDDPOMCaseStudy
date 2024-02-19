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
import pages.DeleteArticlePage;
import pages.HomePage;
import pages.LoginPage;
import pages.UpdateArticlePage;


public class ArticleStepDefinition {
	WebDriver driver;
    HomePage homepage;
    LoginPage loginPage;
    Dashboard dashboard;
    CreateNewArticlePage crnwArticle;
    DeleteArticlePage deleteArticlePage;
    UpdateArticlePage updateArticlePage;
    
    public ArticleStepDefinition()
    {TestBase.initDriver();
	  driver=TestBase.getDriver();
    	
    	 homepage=new HomePage(driver);
		  loginPage=new LoginPage(driver); 
		  dashboard=new Dashboard(driver);
		  crnwArticle=new CreateNewArticlePage(driver);
		  deleteArticlePage= new  DeleteArticlePage(driver);
		  updateArticlePage=new UpdateArticlePage(driver);

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
    public void should_display_the_success_login_message(DataTable dataTable) {
    	List<String> msgs=dataTable.asList();
		String userName=msgs.get(0);
		WebElement ele=loginPage.validUserName(driver,userName);
	    Assert.assertEquals(loginPage.checkValidLogin(ele),userName);
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
    public void should_display_the_new_article_title(DataTable dataTable) {
    	List<String> msg=dataTable.asList();
		String artiTitle=msg.get(0);
    	 Assert.assertEquals(crnwArticle.getHeading(),artiTitle);
    }
    
    @Given("User is on updateArticlePage")
    public void user_is_on_update_article_page() {
    	updateArticlePage.navigateToProfile();
       
    }
    @When("User Update the Article")
    public void user_update_the_article(DataTable dataTable) {
    	List<Map<String,String>> article=dataTable.asMaps();
		String articleTitle=article.get(0).get("articleTitle");
		String updatebody=article.get(0).get("articleBody");

		WebElement locateArticle=updateArticlePage.articleTitleElement(driver,articleTitle);
		updateArticlePage.update(locateArticle,updatebody);
    	
    }
    @Then("Should display the updated Article Title")
    public void should_display_the_updated_article_title(DataTable dataTable) {
    	List<String> msgs=dataTable.asList();
		String expmsg=msgs.get(0);
		WebElement updateBody=updateArticlePage.getUpdateArticleElement(driver, expmsg);
		Assert.assertEquals(updateArticlePage.updateArticleValidate(updateBody),expmsg);
    }
    
    @Given("User is on deleteArticlePage")
    public void user_is_on_delete_article_page() {
    	deleteArticlePage.navigateToProfile();
    }
    @When("User delete the Article")
    public void user_delete_the_article(DataTable dataTable) {
    	List<Map<String,String>> article=dataTable.asMaps();
		String delTitle=article.get(0).get("articleTitle");
		WebElement delelement=deleteArticlePage.locateDelArticle(driver, delTitle);
	    deleteArticlePage.deleteArticle(delelement);
    }
    @Then("should the article to be deleted")
    public void should_the_article_to_be_deleted() {
    	Assert.assertEquals(deleteArticlePage.deleteCheck(), "Articles not available.");
    }  
}
