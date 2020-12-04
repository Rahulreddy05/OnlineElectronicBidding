#This is the feature file which contains the step by step procedure of 
#the system in gherkins language.

Feature: Signup Automation
Scenario Outline: Changepassword page testing
Given Open Chrome Browser And Navigate to changepassword
When User enters new password "<npassword>"
And user enters confirm password "<cpassword>"
Then User clicks on changepassword button



Examples:
|npassword|cpassword|
|varun123|varun123|