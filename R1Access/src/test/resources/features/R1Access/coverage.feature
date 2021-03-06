@Coverage 
Feature: verify features and functionality of coverage 

Background: user navigates to worklist 
	Given user is on R1 hub page 
	When user clicks on facility list 
	And user select the facility 
	And user clicks on "Patient Access" link 
	And user clicks on "Pre-Registration" side submenu 
	
@392231 
Scenario: Verify visibility of all the coverage related information 
	Given user is on "Pre-Registration" worklist page 
	When user run the query and fetch the coverage "EncounterID" 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Coverage" moduleTab 
	And user should not able to view delete icon 
	And user should able to view all active coverage with columns value 
		| COB | Code | Plan | Group | Subscriber | Copay | ER | Deduct | Coins | OOP |
	And user run the query and matches all the column value with database 
	And user should able to view Edit icon 
	When user take checkout on account 
	Then user should able to view delete icon 
	And user should able to view + icon for add new coverage 
	
@392232 
Scenario: verify search payor plan textbox while adding coverage 
	Given user is on "Pre-Registration" worklist page 
	When user run the query and fetch the coverage "EncounterID" 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Coverage" moduleTab 
	And user checkout the account 
	And user fetches the existing plan code in coverage panel 
	And user delete existing coverage 
	And user clicks on + sign of coverage panel 
	Then user should able to view search payor plan text box 
	When user enters any valid plan code 
	And user clicks on coverage cancel button 
	Then user should not able to view search payor plan text box 
	
@392232 
Scenario: verify add coverage functionality 
	Given user is on "Pre-Registration" worklist page 
	When user run the query and fetch the coverage "EncounterID" 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Coverage" moduleTab 
	And user checkout the account 
	And user fetches the existing plan code in coverage panel 
	And user delete existing coverage 
	And user clicks on + sign of coverage panel 
	And user enters any valid plan code 
	And user clicks on Find button 
	Then user should able to view Search result grid 
	When user clicks on any plan code hyperlink under search result criteria 
	Then user should able to view cancel and Add button 
	When user clicks on coverage Add button 
	Then user should able to view added active coverage in coverage panel 
	
@392232 @392273 
Scenario: verify delete coverage functionality 
	Given user is on "Pre-Registration" worklist page 
	When user run the query and fetch the coverage "EncounterID" 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Coverage" moduleTab 
	And user checkout the account 
	And user fetches the existing plan code in coverage panel 
	And user delete existing coverage 
	Then user should able to view deleted coverage as inactive coverage in Other patient coverage panel 
	When user clicks on any inactive coverage from other coverage panel 
	Then user should able to view clicked coverage gets added in coverage panel 
	
@392233 
Scenario: verify coverage edit functionality 
	Given user is on "Pre-Registration" worklist page 
	When user updates the setting "EnableGroupNumberException" value as "ON" 
	And user clicks on "Pre-Registration" side submenu 
	And user run the query and fetch the coverage "EncounterID" 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Coverage" moduleTab 
	And user checkout the account 
	And user fetches the existing plan code in coverage panel 
	And user clicks on coverage editable icon 
	Then user should able to view New Coverage panel 
	When user edits the Group and Subscriber field 
	And user clicks on cancel button of coverage edition 
	Then user should not able to view New Coverage panel 
	When user clicks on coverage editable icon 
	And user edits the Group and Subscriber field 
	And user clicks on update button of coverage edition 
	Then user should able to view updated data in coverage grid 
	
@392234 
Scenario: Verify account becomes self pay in case no coverage is added to it 
	Given user is on "Pre-Registration" worklist page 
	When user run the query and fetch the coverage "EncounterID" 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Coverage" moduleTab 
	And user checkout the account 
	And user fetches the existing plan code in coverage panel 
	And user delete existing coverage 
	Then user should able to view exception message "If patient does not have coverage, select Self Pay, Charity, Workers Comp, etc" 
	When uer clicks on complete button 
	Then user should able to view exception message "Exceptions Exist - Are you sure you want to mark the task complete?" with continue and cancel button 
	When user clicks on exception continue button 
	When user clicks on "Coverage" moduleTab 
	Then user should able to view coverage tab status as complete 
	And user should able to view coverage tab status bar color as Blue 
	And user should able to view "Self pay" added as default 
	
@392236 
Scenario:
Verify Up/Down arrows functionality in the Coverage grid and the impact in Residual Calculation 
	Given user is on "Pre-Registration" worklist page 
	When user updates the setting "FRONT_SERVICES_TASK_VERSION" value as "2" 
	And user updates the setting "FRONT_RESIDUAL_TASK_VERSION" value as "2" 
	And user clicks on "Pre-Registration" side submenu 
	And user run the query and fetches the coverage "EncounterID" 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Services" moduleTab 
	And user checkout the account 
	And user add services if no services exists 
	And user clicks on "Residual" moduleTab 
	And user fetches the Residual balance 
	And user click on "Coverage" tab 
	And user checkout the account 
	And user clicks on Arrow button 
	And user clicks on "Coverage" moduleTab 
	And user clicks on "Residual" moduleTab 
	Then user should able to view different Residual balance 
	
@392247 
Scenario:
Verify Eligibility Results panel for an account for which eligibility has never been run previously 
	Given user is on "Pre-Registration" worklist page 
	When user run the query and fetch the "EncounterID" of coverage 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Coverage" moduleTab 
	And user checkout the account 
	And user click on TBD hyperlink under verified column in coverage grid 
	Then user should not able to view Eligibility Results panel 
	
@392270 @392271 
Scenario:
Verify Update Functionality for Eligibility panel and benefit panel and of unlimited checkbox 
	Given user is on "Pre-Registration" worklist page 
	When user run the query and fetches the "EncounterID" of coverage 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Coverage" moduleTab 
	And user checkout the account 
	And user click on any hyperlink under verified column in coverage grid 
	And user clicks on Unlimited checkbox 
	Then user should able to view limit($) textbox get populated with value "Unlimited" 
	And user should able to view limit($) textbox as disabled 
	When user changes plan name 
	And user changes copay,ER,Deductible,Coins field value 
		| copay | ER | Deductible | coins |
		| $2.00 | $2.00 | $2.00 | 2.00 % |
	And user clicks on update button after editing 
	Then user should able to view updated field value 
		| copay | ER | Deductible | coins |
		| $2.00 | $2.00 | $2.00 | 2.00 % |
	When user run the query and passes the current Encounter ID 
	Then user should able to view same updated value in database 
	
@392274 
Scenario: Verify Control Number Logs under Log tab after hitting Run Query 
	Given user is on "Pre-Registration" worklist page 
	When user run the query and fetched the "EncounterID" of coverage 
	And user clicks on search tab 
	And user enters the fetched EncounterID into search textbox 
	And user clicks on the Search button 
	And user clicks on "Coverage" moduleTab 
	And user checkout the account 
	And user click on any hyperlink under verified column in coverage grid 
	And user clicks on Run Query button 
	Then user should able to view Control number under Trace Number section 
	And user should able to view REFERENCED TRANSACTION TRACE NUMBERS under Trace Number section 
	And user should able to view CURRENT TRANSACTION TRACE NUMBERS under Trace Number section 
	When user clicks on "Log" moduleTab 
	Then user should able to view generated control number under Eligibility log section