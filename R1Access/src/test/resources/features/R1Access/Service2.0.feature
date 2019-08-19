Feature: Verify the functionality of Service2.0 

Background: User should be able to navigate on Account Worklist Grid 

	Given user is on R1 hub page 
	When user clicks on facility list 
	And user select the facility "SCFL - St Vincents Medical Center Clay County" 
	And user clicks on Patient Access link 
	And user clicks on Pre-Registration 
	Then user should be able to view Account Worklist Grid 
	
@391638 @391835 @391837 @391648 
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
	
@391646 
Scenario:
Verify user is able to complete the 'Service' tab when services are added to it 
	When user clicks on any Unassigned Account 
	And user clicked on "Services" tab 
	And user clicked on checkout button 
	And user clicked on Admitting if exists 
	And user enter services like "Skin" in search field 
	And user add services 
	And user add ICD Codes 
	And user clicks on "Complete" btn 
	And user clicked on "Continue" btn 
	And user clicked on "Services" tab 
	Then verify the status of the tab is completed 
	
@391644 
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
	
@391644 
Scenario: Service_Verify default pricing mode in facility setting. 
    When user clicks on the "Settings" link from footer Tab
	And user clicks on "IT Tools" 
	And user clicks on "FacilitySetting Configuration"
	And user set the facility "SCFL" setting name "PRICINGMODE_SINGLEDEFAULT" setting value "S"
	And user clicks on the "Patient Access" link from footer Tab
	And user clicks on facility list
	And user select the facility "SCFL - St Vincents Medical Center Clay County"
	And user clicks on Pre-Registration	
	And user clicks on any Unassigned Account 
	And user clicked on "Services" tab 
    And user clicked on checkout button 
	And user clicked on Admitting if exists
	Then verify "Single" radio button should be selected by default 
	
	
	
 