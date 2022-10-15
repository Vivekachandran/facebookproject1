package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Viveka\\eclipse-workspace\\FacebookProject\\src\\test\\resources\\FeatureFiles",glue="org.stepdefinition",plugin= 
{"json:src\\test\\resources\\ReportGeneration\\json\\reportjson.xml"})

public class TestRunner {

}
