Feature: Validate Login Feature
#Global Property Will run against all scenario
Background: 
Given	open browser
And go to facebook.com
@Smoke
Scenario: As a user using valid credentials should be logged in
When user type valid userID in userID textbox
And user type valid password in password box
And user click on login button
Then user should see profile page

# Data Driven Testing
@Reg
Scenario Outline: As a user using invalid credentials should not be logged in
When user type "<userID>" in userID textbox
And user type "<password>" in password box
And user click on login button
Then user should not see profile page
Examples: 
| userID | password |
| user1   | pass1   |
| user2   | pass2   |

