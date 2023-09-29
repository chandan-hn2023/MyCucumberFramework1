@all
Feature: User login
User should be able to access his/her account using login functionality

Background: 
Given User has navigated to Login page

@login @validcredentials @smoke @regression
Scenario Outline: Login with valid credentials
When User enters valid email address <email>
And Enters valid password <password>
And Clicks on Login Button
Then User should be able to successfully login
Examples:
|          email         | |password|
|chandanhngowda@gmail.com| |Password@2023|
|chandanhn174@gmail.com  | |Password@2023|

@login @invalidcredentials @regression
Scenario: Login with invalid credentials
When User enters invalid email address
And Enters invalid password "11232"
And Clicks on Login Button
And An error message should be displayed

@login @validusernameinvalidpasssword @regression
Scenario: Login with valid username and invalid password
When User enters valid email address "chandanhngowda@gmail.com"
And Enters invalid password "11232"
And Clicks on Login Button
Then An error message should be displayed

@login @invalidusernamevalidpassword @regression
Scenario: Login with invalid username and valid password
When User enters invalid email address
And Enters valid password "Password@2023"
And Clicks on Login Button
Then An error message should be displayed

@login @nocredentials @regression @dev
Scenario: Login with no credentials
When User dont enter any credentials
And Clicks on Login Button
Then An error message should be displayed

