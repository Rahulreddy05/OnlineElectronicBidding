#This is the feature file which contains the step by step procedure of 
#the system in gherkins language.

Feature: Signup Automation
Scenario Outline: Changepassword page testing
Given Open Chrome Browser And Navigate to loginpage
When User enters login email "<email>"
And user enters login password "<password>"
Then User clicks on login button



Examples:
|email|password|
|banda.rahulreddy@gmail.com|123456|