Feature: Article Page Function
 
Scenario: Invalid Login into app
Given User is on login Page
When User enter inValid credentials
| emailid | password |
| pragathisayee@gmail.com | pragathi |
Then Should display the invalid login message
| Wrong email/password combination |
 
Scenario: Valid Login into app
Given User is on the login Page
When User enter Valid Credentials
| emailid | password |
| pragathisayee@gmail.com | pragathi8 |
Then Should display the success login message
 
 
Scenario: User Create the Article with duplicate Title
Given User is on newArticleCreationPage
When   User Create the duplicate article
| articleTitle | description | body | tags |
| 27 | 2 | des | auto |
Then   Should display the duplicate article message
 
Scenario: User Create the new Article
Given User is on the newArticleCreationPage
When User create the new Article
| articleTitle | description | body | tags |
| arti | 2 | des | auto |
Then Should display the new Article Title
 
Scenario: User delete the Article
Given User is on deleteArticlePage
| articleTitle |
| arti2 |
When User delete the Article
Then should the article to be deleted

Scenario: User update the Article
Given User is on updateArticlePage
| articleTitle |
| arti |
When User Update the Article
| articleBody |
| automation in testing |
Then Should display the updated Article Title