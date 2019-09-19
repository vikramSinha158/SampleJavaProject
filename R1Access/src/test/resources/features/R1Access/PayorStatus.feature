@PayorStatus 
Feature: verify payor status worklist grid with Admin roles 

Background: user navigates to payor status worklist 
	Given user is on R1 hub page 
	When user clicks on facility list 
	And user select the facility 
	And user clicks on "Patient Access" link 
	And user clicks on "Payor Status" side submenu 
	
	
@391605 
Scenario: verify Payor status worklist table column name 
	Given user is on Payor Status worklist page 
	Then user should able to view column header name 
		| Payor Name | Status | Update Date | Downtime Retries Scheduled | Connector |
	And user should able to view all values under Status column as "Active" or "Inactive" 
	And user should able to view all values under Status column as HyperLink 
	
@391605 
Scenario: verify Active and Inactive Hyperlink 
	Given user is on Payor Status worklist page 
	When user clicks on "Active" hyperlink under status column for any particular Payor name 
	Then user should able to view clicked hyperlink as "Inactive" for same Payor name with updated Date 
	When user clicks on "Inactive" hyperlink under status column for any particular Payor name 
	Then user should able to view clicked hyperlink as "Active" for same Payor name with updated Date