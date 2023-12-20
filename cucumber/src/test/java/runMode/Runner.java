package runMode;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

//The path system is to run the entire feature file
//Second method we is tag method to select specific scenario according to tag name 
@CucumberOptions(features = {"C:\\Users\\binsh\\eclipse-workspace\\Cucumber_Framework\\login.feature"},
tags = {"@Reg"},plugin={"pretty","html:Folder_Name"})
public class Runner {
	//BDD Cucumber Requirement
	//Feature file
	//StepDefition Class
	//Runner Class
}
