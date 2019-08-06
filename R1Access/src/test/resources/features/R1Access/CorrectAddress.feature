Feature: Verify correct address work list page functionality

Background: user navigates to correct address worklist page
Given user is on R1 hub page
When user clicks on facility list
And user select the facility "SCFL - St Vincents Medical Center Clay County"
And user clicks on patient access tab
And user clicks on "Correct Address" link

@391657 @CorrectAddress
Scenario: verify duplicate MRN does not exists in the worklist
Given user is on correct address worklist page
When user clicks on MRN column to sort the records
Then user should able to view sorted records with no duplicate MRN on worklist
And user should not view any accounts with prior balance equals to zero or null on worklist
And user should able to view 15 records on worklist

@391658 @CorrectAddress
Scenario: verify the detail page of an account
Given user is on correct address worklist page
When user clicks on any account
Then user should able to view "Patient","Settlement","Notes","Log" tab
And user should able to view patient tab by default
And user should able to view patient demographics information on patient tab
When user click on "Settlement" tab
Then user should able to view data loaded on settlement tab

@391658 @CorrectAddress
Scenario: verify notes and log tab functionality
Given user is on correct address worklist page
When user clicks on any account
And user click on "Notes" tab
And user add notes 
Then user should able to view Notes entered
When user click on "Log" tab 
Then user should able to view Action log

@391659 @CorrectAddress
Scenario: verify the movement of account from Pre-Reg to Returned Mail worklist on updating the value of "Returned Mail" checkbox to "Checked"
Given user is on correct address worklist page
When user clicks on footer patient access tab
And user clicks on "Pre-Registration" worklist
And user clicks on any account having "PriorBalance" greater than "0"
And user click on "Patient" tab
And user checkout the account
And user fetches the Account num
And user marks Returned Mail checkbox as checked
And user click on update button
And user clicks on footer patient access tab
And user clicks on "Correct Address" link
Then user should able to view same fetched account on correct address worklist