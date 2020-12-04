package com.capg.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/rahulreddy/OnlineElectronicBidding/ProductManagementSystem-Server/src/test/java/resources/Features",
glue="com.capg.stepdefinition" 
//plugin= {"html:target/cucumber_html_report","json:target/cucumber_json_report.json","pretty:target/pretty_report.txt"}
)
public class TestRunner {

}