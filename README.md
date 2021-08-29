# Automate-Samsung-Website

DriverFactory.java --> initialize the driver according to the browser

HomePage.feature, ComparePage.feature, AddToCartPage.feature --> Feature files describing scenarios

HomePage.java, CompagePage.java, AddToCartPage.java --> WebElement repositories containing webelements of a particular page (POM classes)

HomeSteps.java, CompareSteps.java, AddToCartSteps.java --> Respective StepDefinitions for the POM classes

AppHooks.java --> Launching the browser before each scenario and closing the browser after each scenario

TestRunner.java --> Runner class 

ConfigReader.java --> Reads data from configuration file

UtilClass.java --> provides basic actions

config.properties --> properties file

pom.xml --> contains all the necessary dependencies
