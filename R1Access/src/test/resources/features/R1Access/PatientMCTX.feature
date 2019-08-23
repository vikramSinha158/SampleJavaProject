Feature: Verifiy the functionality of Patient operations for PA Supervisor role

Background: user navigates to Service Field Scope Configuration
Given user is on R1 hub page
When user clicks on facility list
And user select the facility "MCTX - Seton Medical Center Austin"
 And user clicks on Patient Access link
Then  And user clicks on Pre-Registration

  @419178 @PASupervisorDisable
  Scenario: Verify that I08 plan code and address is BAD ADDRESS Homelessthen patient tab should be blue and address exception message should not be populated.
  When user run the query and fetch the encounteridForBadAddress
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  And user clicks on checkout button
  Then user should be able to view cancelled checkbox in disableState mode 
  And use should be able to address 
