Feature: Verify the functionality of Service2.0 

Background: User should be able to navigate on Account Worklist Grid 

	Given user is on R1 hub page 
	When user clicks on facility list 
	And user select the facility "SCFL - St Vincents Medical Center Clay County" 
	And user clicks on "Patient Access" link 
	And user clicks on "Pre-Registration" side sub menu
	Then verify facility "SCFL - St Vincents Medical Center Clay County" service "FRONT_SERVICES_TASK_VERSION" and residual "FRONT_RESIDUAL_TASK_VERSION" has version two
	Then user should be able to view Account Worklist Grid
			
@391637 @391638 @391835 @391837 @391648 @Service2
Scenario: Verify Radio Buttons for Single and multiple pricing modes 
	When user clicks on any Unassigned Account 
	And user clicked on "Services" tab 
	Then verify the fields before checkout 
	When user clicked on checkout button 
	And user clicked on Admitting if exists 
	Then verify the fields after the checkout 
	When user enter services like "Skin" in search field 
	Then searched result should be shown in service pane 
	And verify radio buttons 
	When user add services 
	Then verify service should be added 
	When user delete added services 
	Then service search result grid will not be displayed 
	When user clicks on "Release" btn 
	Then single multiple radio buttons of pricing will not be displayed 

@391642 @Service2
Scenario: Verify 'Search' and add services by ICD9/ICD10Code 
    When user clicks on any Unassigned Account 
	And user clicked on "Services" tab 	 
	And user clicked on checkout button 
	And user clicked on Admitting if exists 
	Then verify that IcdNine codes checkbox exist 	
	When user clicks on IcdNine codes checkbox
	And user enter services like "172" in search field 
	Then verify "ICD10" codes are coming in diagnosis grid	
	When user clicks on IcdNine codes checkbox
	And user enter services like "172" in search field
	Then verify "ICD9" codes are coming in diagnosis grid	
    And user add ICD Codes
	And user clicks on "Release" btn
	
@391639 @Service2
Scenario: Verify 'Search' and add services by ICD9/ICD10Code 
    When user select filter "Type" operator "=" value "O" from dropdown
    And user clicks on any Unassigned Account 
	And user clicked on "Services" tab 	 
	And user clicked on checkout button 
	And user clicked on Admitting if exists 
	Then verify that IcdNine codes checkbox exist 	
	When user clicks on IcdNine codes checkbox
	And user enter services like "740" in search field 
	Then verify "ICD10" codes are coming in diagnosis grid	
	When user clicks on IcdNine codes checkbox
	And user enter services like "740" in search field
	Then verify "ICD9" codes are coming in diagnosis grid
	And user add ICD Codes
	And user clicks on "Release" btn
			
@393857 @Service2
Scenario: Service_Verify default pricing mode in facility setting. 
    When user clicks on the "Settings" link from footer Tab
	And user clicks on "IT Tools" side sub menu
	And user clicks on "FacilitySetting Configuration" side sub menu
	And user set the facility "SJMA" setting name "PRICINGMODE_SINGLEDEFAULT" setting value "S"
	And user clicks on the "Patient Access" link from footer Tab
	And user clicks on facility list
	And user select the facility "SJMA - St. John Macomb-Oakland Hospital"
	And user clicks on Pre-Registration	
	And user clicks on any Unassigned Account 
	And user clicked on "Services" tab 
    And user clicked on checkout button 
	And user clicked on Admitting if exists
	Then verify "Single" radio button should be selected by default 
	And user clicks on "Release" btn
				
 @391646 @Service2
Scenario: Verify user is able to complete the 'Service' tab when services are added to it 
	When user clicks on any Unassigned Account 
	And user clicked on "Services" tab 
	And user clicked on checkout button 
	And user clicked on Admitting if exists 
	And user enter services like "Skin" in search field 
	And user add services 
	And user add ICD Codes 
	And user clicks on "Complete" btn 
	#And user clicked on "Continue" btn 
	And user clicked on "Services" tab 
	Then verify the status of the "Services" tab is "Complete" and color "blue"
	And user clicks on "Release" btn
	
@391644 @Service2
Scenario: Verify user is able to move the services up/down 
	When user clicks on any Unassigned Account 
	And user clicked on "Services" tab 
	And user clicked on checkout button 
	And user clicked on Admitting if exists 
	And user enter services like "Skin" in search field 
	And user add services 
	And user add ICD Codes 
	And user enter services like "Skin" in search field 
	And user add services 
	And user add ICD Codes 
	Then verify that up down arrow key is moving of ICD codes 

#@391873 @Service2
#Scenario: Verify an expired code
#	When user clicks on any Unassigned Account 
#	And user clicked on "Services" tab 
#	And user clicked on checkout button 
#	And user clicked on Admitting if exists
#	Then verify that search label, button, textbox, switch to final is visible 
#	When  user fetch expired hcpc code and enter it
#	Then verify error message is coming HCPC found but expired
		
	
	
	
	