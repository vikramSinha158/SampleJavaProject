@CorrectAddress
Feature: Verify correct address work list page functionality 

Background: user navigates to correct address worklist page 
	Given user is on R1 hub page 
	When user clicks on facility list 
	And user select the facility 
	And user clicks on "Patient Access" link 
	And user clicks on "Correct Address" side submenu 
	
@391657 
Scenario: verify duplicate MRN does not exists in the worklist 
	Given user is on correct address worklist page 
	When user clicks on MRN column to sort the records 
	Then user should able to view sorted records with no duplicate MRN on worklist 
	And user should not view any accounts with prior balance equals to zero or null on worklist 
	And user should able to view 15 records on worklist 
	
@391658
Scenario: verify the detail page of an account 
	Given user is on correct address worklist page 
	When user clicks on any account 
	Then user should able to view "Patient","Settlement","Notes","Log" tab 
	And user should able to view patient tab by default 
	And user should able to view patient demographics information on patient tab 
	When user clicks on "Settlement" moduleTab 
	Then user should able to view data loaded on settlement tab 
	
@391658  
Scenario: verify notes and log tab functionality 
	Given user is on correct address worklist page 
	When user clicks on any account 
	And user clicks on "Notes" moduleTab 
	And user add notes 
	Then user should able to view Notes entered 
	When user clicks on "Log" moduleTab 
	Then user should able to view Action log 
	
@391659  
Scenario: verify the movement of account from Pre-Reg to Returned Mail worklist on updating the value of Returned Mail checkbox to Checked 
	Given user is on correct address worklist page 
	When user clicks on footer patient access tab 
	And  user clicks on "Pre-Registration" side submenu 
	And user clicks on any account having "PriorBalance" greater than "0" 
	And user clicks on "Patient" moduleTab 
	And user take checkout on account 
	And user fetches the Account num 
	And user marks Returned Mail checkbox as checked 
	And user click on update button 
	And user clicks on the "Patient Access" link from footerTab 
	And user clicks on "Correct Address" link 
	Then user should able to view same fetched account on correct address worklist