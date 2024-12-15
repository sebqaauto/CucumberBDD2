#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

 Background:
	Given the browser is launched
	

@smoke
Scenario: Login Test
Given user clicks on the login link 
And enters the email address
And enter the password
And clicks on submit button
Then login should be successful
 
 @regressionTest
 Scenario Outline: Registration Test
   Given the user is on the homepage
   When I user enters the "<firstname>"
   And the last name "<lastname>"
   And the email "<emailAddress>"
   And the password "<password>"
   And the confirmPassword "<confirmPassword>"
   And clicks on the continue button
   Then user should be logged in
   Then login should be successful
   Examples:
     | firstname  | lastname | emailAddress  | password | confirmPassword  |
     | yuvi |    singh23 | yuvi22@pbks998.com |YouKnowMe001|YouKnowMe001|
     | shami |    mhd2 | shamimhd34@gt392.com    |YouKnowMe001|YouKnowMe001|


