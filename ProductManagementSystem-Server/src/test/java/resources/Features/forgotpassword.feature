#This is the feature file which contains the step by step procedure of 
#the system in gherkins language.

Feature: Signup Automation
Scenario Outline: ForgotPassword page testing
Given Open Chrome Browser And Navigate to forgotpassword
When User enters email "<email>"
Then User clicks on forgotpassword button



Examples:
|email|
|varuns435@gmail.com|