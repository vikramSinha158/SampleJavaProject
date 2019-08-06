Feature: verify PCP functionality

Background: user navigates to worklist page
Given user is on R1 hub page
When user clicks on facility list
And user select the facility "SCFL - St Vincents Medical Center Clay County"
And user clicks on setting link
And user clicks on IT Tool
And user clicks on Facility Setting configuration
And user select "Code" from search dropdown
And user enters "SCFL" on search textbox
And user clicks on search icon
And user clicks on view icon of corresponding code
And user select "Setting Name" from search drop down for Locations
And user enters "TrackPCPComplete" on search textbox for Locations
And user clicks on search icon for Locations 
And user edits the setting value to "1"
And user clicks on patient access tab
And user clicks on "Pre-Registration" worklist

@392088 @PCP
Scenario: verify 'PCP' tab visibility and functionality
Given user is on "Pre-Registration" worklist page
When user open any account 
Then user should able to view "PCP Validation" tab
When user click on "PCP Validation" tab
And user checkout the account
Then user should able to view pcp tab status as Incomplete
And user should able to view pcp tab status bar color as Red

@392089 @PCP
Scenario: verify account with incomplete PCP tab exists in Incomplete Task -->PCP sub-filter folder
Given user is on "Pre-Registration" worklist page
When user open any account
And user clicks on expand + icon of incomplete task filter folder
And user clicks on PCP sub filter folder
Then user should able to view incomplete pcp accounts

@392090 @PCP
Scenario: verify on completing an account log goes in Log tab
Given user is on "Pre-Registration" worklist page
When user open any account
And user click on "PCP Validation" tab
And user checkout the account
And user set the value of pcp checkbox equals to checked
Then user should able to view pcp tab status as complete
And user should able to view pcp tab status bar color as Blue
When user click on "Log" tab
Then user should able to view a log for task equals to pcp and status equals to completed as last log in Action Log panel 

@392091 @PCP
Scenario: verify account with complete 'PCP' tab does not exists in Incomplete Task in PCP sub-filter folder
Given user is on "Pre-Registration" worklist page
When user clicks on expand + icon of incomplete task filter folder
And user clicks on PCP sub filter folder
And user open any account
And user click on "PCP Validation" tab
And user checkout the account
And user set the value of pcp checkbox equals to checked
And user fetch the Account num
And user clicks on PCP sub filter folder
Then user should not able to view same fetched Account num in worklist
