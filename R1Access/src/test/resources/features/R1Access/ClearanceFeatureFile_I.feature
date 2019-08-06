Feature: Verification of the tab and ribbon color, status changes, logging functionality and filter folder movement on completing an incomplete account

    Background: user navigates to Clearance tab 
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility "SCFL - St Vincents Medical Center Clay County"
    When user clicks on "Patient Access"
    And user clicks on "Pre-registration"
    And user clicks on "Incomplete Task" expand button
    Then user clicks on Clearance sub filter folder
    And user clicks on any Account from filter subfolder 
    And user clicks on Clearance tab 
   
    @391781 @Clearance
    Scenario: Verify the tab and ribbon color, status changes, logging functionality and filter folder movement on completing an incomplete account
    Given user is on Clearance tab 
    When user clicks on Checkout button
    And user set the value of MSP and Order checkbox to Checked
    And user set the value of Clearance  checkbox equals to Checked
    Then user should be able to view MSP and Order checkbox to be Checked
    And user should be able to view tab Status equal to Completed and tab and tab ribbon color equal to Blue
    When user clicks on Log tab
    Then user should be able to see a log for Task equal to Clearance and Status equal to Completed
    When user clicks on Clearance sub filter folder
    Then user should not able to see the account in the worklist
    When user clicks on worklist folder
    Then user is able to see the account in the worklist using filter criteria
    And user is able to see the traffic light in BLUE color for the record

    @391782 @Clearance
	Scenario: Verify the tab and ribbon color, status changes, logging functionality and filter folder movement on re-doing a complete account
	Given user is on Clearance tab
	When user clicks on Redo button
	Then user is able to see Clearance check box becomes unchecked and enabled for editing with Clearance tab color as RED
	When user clicks on Log tab
	Then user is able to see the Log page related to that account
	And user is able to see a log for Task equal to Clearance and Status equal to Redo
	When user clicks on Clearance sub filter folder
	Then user is able to see Accounts having RED traffic light under CI filter folder in the filtered worklist
	
	@392268 @Clearance
	Scenario: Verify MSP tab get automatically checked in case of non medicare accounts
    Given user is on Clearance tab
	Then user is able to see MSP checkbox on Clearance tab as checked in case of non medicare accounts
	And MSP tab gets automatically checked

	@392269 @Clearance
	Scenario: Verify MSP tab doesn't get automatically checked in case of medicare accounts
    Given user is on Clearance tab
	Then user is able to see Clearance Tab should be visible in RED color
	And user is able to see MSP check box on Clearance tab 
	And user is able to see Clearance tab doesnt get automatically checked in case of medicare coverage accounts
	
	
	
   
     
