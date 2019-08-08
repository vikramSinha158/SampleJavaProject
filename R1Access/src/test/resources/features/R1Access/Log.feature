Feature: Verify Log functionality

Background: user navigates to worklist 
Given user is on R1 hub page
When user clicks on facility list
And user select the facility "SJMA - St. John Macomb-Oakland Hospital"
And user clicks on patient access tab
And user clicks on "Pre-Registration" worklist

@391633 @Log
Scenario: verify Log labels
Given user is on "Pre-Registration" worklist page
When user open any account
And user click on "Log" tab
Then user should able to view label column
| Type/Disposition | Task | Updated By | Status | Note | Date/Time  |

@391633 @Log
Scenario: verify Log column value sorting
Given user is on "Pre-Registration" worklist page
When user open any account
And user click on "Log" tab
Then user should able to view triangle icon with column value sorted on clicking column header
| Type/Disposition | Task | Updated By | Status | Note |


@391633 @Log
Scenario: verify radio button functionality on Log tab
Given user is on "Pre-Registration" worklist page
When user open any account
And user click on "Log" tab
When user clicks on "All" radio button
Then user should able to view both "Action" and "Task" type log
When user clicks on "Tasks" radio button
Then user should able to view all "Task" type log
When user clicks on "Actions" radio button
Then user should able to view all "Action" type log

@391633 @Log
Scenario: verify view of logs for performed events
Given user is on "Pre-Registration" worklist page
When user open any account
And user click on "Services" tab
And user checkout the account
And user search the service
And user clicks on first value of Service search result
And user clicks on complete button
And user click on "Log" tab
Then user should able to verify a log for last task of performed tasks
