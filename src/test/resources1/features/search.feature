@all
Feature: Search functionality

Background: 
Given User opens the application

@search @existingproduct @smoke @regression
Scenario: Search for a existing product
When User enter existing product "HP" in Search field
And User click on Search button
Then Existing product should be displayed in search results

@search @non-existingproduct @regression
Scenario: Search for a non-existing product
When User enter non-existing product "Honda" in Search field
And User click on Search button
Then Products not matching error message should be displayed

@search @withoutprovidinganyproduct @regression @wip
Scenario: Search without providing any product
When User dont enter any product in Search field
And User click on Search button
Then Products not matching error message should be displayed