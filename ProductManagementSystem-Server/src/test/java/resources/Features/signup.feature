#This is the feature file which contains the step by step procedure of 
#the system in gherkins language.

Feature: Signup Automation
Scenario Outline: Registration page testing
Given Open Chrome Browser And Navigate to signup
When User enters name "<name>"
And  User enters a valid email "<email>"
And user enters password "<pwd>"
And  User enters a valid phonenumber "<phonenumber>"

And  User enters address "<address>"
Then User clicks on signup button



Examples:
|name|email|pwd|phonenumber|address|
|Likith|likitha@gmail.com|likitha54321|9876543212|Hyderabad|