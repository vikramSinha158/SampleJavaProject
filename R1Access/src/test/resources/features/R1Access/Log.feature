Feature: Verify Log functionality

Background: user navigates to worklist 
Given user is on R1 hub page
When user clicks on facility list
And user select the facility 
And user clicks on "Patient Access" link
And user clicks on "Pre-Registration" side submenu

@391633 @Log
Scenario: verify Log labels
Given user is on "Pre-Registration" worklist page
When user clicks on any Unassigned Account
And user clicks on "Log" moduleTab
Then user should able to view label column
| Type/Disposition | Task | Updated By | Status | Note | Date/Time  |

@391633 @Log
Scenario: verify Log column value sorting
Given user is on "Pre-Registration" worklist page
When user clicks on any Unassigned Account
And user clicks on "Log" moduleTab
Then user should able to view triangle icon with column value sorted on clicking column header
| Type/Disposition | Task | Updated By | Status | Note |


@391633 @Log
Scenario: verify radio button functionality on Log tab
Given user is on "Pre-Registration" worklist page
When user clicks on any Unassigned Account
And user clicks on "Log" moduleTab
When user clicks on "All" radio button
Then user should able to view both "Action" and "Task" type log
When user clicks on "Tasks" radio button
Then user should able to view all "Task" type log
When user clicks on "Actions" radio button
Then user should able to view all "Action" type log

@391633 @Log
Scenario: verify view of logs for performed events
Given user is on "Pre-Registration" worklist page
When user clicks on any Unassigned Account
And user clicks on "Services" moduleTab
And user take checkout on account
And user enter services like "Skin" in search field
And user add services
And user clicks on "Complete" button
And user clicks on "Log" moduleTab
Then user should able to verify a log for last task of performed tasks
