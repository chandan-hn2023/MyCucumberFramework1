@all
Feature: User Registeration

Background:
Given User navigates to Register Account page

@register @mandatoryfields @smoke @regression
Scenario Outline: Register with mandatory fields
When User enter following inputs
|firstname|Chandan|
|lastname|HN|
|telephone|1234567890|
|password|12345|
|confirmpassword|12345|

And Selects Privacy Policy field
And Clicks on Continue button
Then Account should get successfully created

@register @allthefields @smoke @regression
Scenario Outline: Register with All the fields
When User enter following inputs
|firstname|Chandan|
|lastname|HN|
|telephone|1234567890|
|password|12345|
|confirmpassword|12345|

And Select Yes for News Letter RadioButton
And Selects Privacy Policy field
And Clicks on Continue button
Then Account should get successfully created

@register @withoutprovidinganyfields @regression @ignore
Scenario: Register without providing any fields
When User dont enter any fields
And Clicks on Continue button
Then Warning messages should be displayed for the mandatory fields

@register @withduplicateemailaddress @regression
Scenario: Register with duplicate email address
When User enter following inputs along with a duplicate email
|firstname|Chandan|
|lastname|HN|
|email|chandanhngowda@gmail.com|
|telephone|1234567890|
|password|12345|
|confirmpassword|12345|

And Select Yes for News Letter RadioButton
And Selects Privacy Policy field
And Clicks on Continue button
Then Account already exist warning message should be displayed


