Feature: Verification of Settlement tab functionality.


Background: User navigates to the Settlement tab
Given user is on R1 hub page
When user clicks on facility list
And user select the facility "SJMC - St. John Hospital and Medical Center"
When user clicks on "Patient Access and then Pre-registration"

@396272 @Settlement
Scenario: Verify settlement tab color for account having prior balance > 0
Given user is on Pre-registration worklist
When user filters the account having "PriorBalance" ">" "0"
And user selects an account having prior balance greater than zero
And user is able to view the R1 access modules tab
And user clicks on Settlement tab
Then user is able to view Settlement tab color as "Red"
And Settlement tab status as "Incomplete"
And user is able to view Prior Balance label
When user clicks on "Check Out" button
Then fields on the tab becomes editable

@396274 @Settlement
Scenario: Total Payments panel for an account having total payments value not equal to zero
Given user is on Pre-registration worklist
When user runs the query and fetches the encounterid_1
And user clicks on search button of menu 
And user enters the encounterid in search textbox
And user clicks on submit button
And user clicks on Settlement tab
Then user should be able to view Total Payments panel
When user clicks on expand button
Then user should be able to view corresponding columns
| PostDate | Pmt Code | Description | Plan Code | Tran Type | Tran Date | Amount |
Then sum of all the values under Amount column should be equal to Total Payments value

@396276 @Settlement
Scenario: Verify default values of the controls
Given user is on Pre-registration worklist
When user clicks on an account
And user clicks on Settlement tab
Then user should be able to view show all related visits checkbox as unchecked 
And No payment selected in Primary Disposition label  
And Select One value is displayed in Non-Collection Reason
