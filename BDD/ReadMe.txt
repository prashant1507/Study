Link to refer - https://www.youtube.com/watch?v=vHzMJuc9Zuk&list=PLFGoYjJG_fqoBFPevCDZDCufDX5h-o3yO&index=1
About Project:
Language: Java
Reporting: Allure ( ./Resources/allure-2.7.0/bin/allure.bat serve allure-results/)
Framework: BDD Framework
Project Type: junit Maven - POM using BDD Framework

- BDD: Defining the behavior of the framework in plain English language call Gherkin language

- Components in BDD cucumber framework
	- .feature: Has Gherkin keywords
		- Background
		- Feature
		- When
		- Then
		- Given
		- As
		- But
		- *
		- Scenario
		- Scenario Outline
			-Examples
	- Step Definition: Annotations, Java, Selenium
	- TestRunner: To run the feature, to generate output, generate report

- Data driven in cucumber
	- Simple - without example keyword - Passing directly form the steps in feature file
	- With Example + Scenario Outlet
	- Using DataTables
	- using DataDriven Map - https://www.youtube.com/watch?v=99qAnsYIYA0&list=PLFGoYjJG_fqoBFPevCDZDCufDX5h-o3yO&index=5

- Tags
	- tags = {"@Smoke , @Regression"} ->> Smoke OR Regression
	- tags = {"@Smoke" , "@Regression"} ->> Smoke AND Regression
	- tags = {"~@Smoke" , "~@Regression"}  ->> Do not run tags with Smoke AND Regression

- Hooks
- Using testNG: https://www.youtube.com/watch?v=4GxS0-122ds&list=PLFGoYjJG_fqoBFPevCDZDCufDX5h-o3yO&index=9


To Run
- mvn clean test (as the TestRunner is configured in maven pom.xml)