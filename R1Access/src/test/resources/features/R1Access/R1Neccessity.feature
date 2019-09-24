@R1Neccessity
Feature: Verify the workflow of Notes tab

  Background: user navigates to worklist page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility 
    And user clicks on "Patient Access" link 
    And user clicks on "Pre-Registration" side submenu
    Then user is on "Pre-Registration" page
    Then user should be able to view Filters in left panel
    And user should be able to view labels NEW,TASK,COLUMNS,SEARCH,EXPORT,SAVE LIST and CONFIG
    When user clicks on any Unassigned Account 
    Then user should be able to view all tabs in Red, Blue and Yellow color

  @391775 
  Scenario Outline: Verification of R1Necessity Tab on accounts
    Given user is on account detail page
    When user click on the "Search" button on blue ribbon
    And user should be able to view SSN:, L/F Name:, Med Rec: and Visit: labels
    And user fetch the "<QueryForEncountered>" from Query for FCC
    And user enters the EncounterID into search field
    And user clicks on the Search button
    Then user should be able to view R1 Necessity tab with ribbon color red/blue
    
   Examples:
	| QueryForEncountered   |
	| QueryWorklistAccount  |
	 

  @391776 
  Scenario Outline: Verification of Print ABN English and Print ABN Spanish button functionality
    Given user is on account detail page
    When user clicks on the "Necessity Required" filter
    Then user should be able to view records
    When user clicks on any Unassigned Account 
    And user clicks on "Services" moduleTab 
    And user take checkout on account
    And user search the service "skin"
    Then user clicks on the searched service link
    And user clicks on any diagnosis link
    And user clicks on "Complete" button
    When user clicks on "R1 Necessity" moduleTab 
    And user take checkout on account
    Then user should be able to view follow up history grid with labels and data
    And user clicks on the Print ABN English button
    Then user should be able to view ABN English pdf
    And user clicks on the Print ABN Spanish button
    Then user should be able to view ABN Spanish pdf
    And user clicks on "Log" moduleTab 
    Then user should be able to view the Activity Log grid with labels
    When user click on the "Search" button on blue ribbon
    And user fetch the "<QueryForRegistrationID>" get registrationID
    And user fetch the "<QueryForEncountered>" get EncounterID
    And user enters the EncounterID into search field
    And user clicks on the Search button
    When user clicks on "R1 Necessity" moduleTab 
    And user take checkout on account
    And user clicks on the Print ABN English button
    Then user should be able to view ABN English pdf
    When user clicks on the Print ABN Spanish button
    Then user should be able to view ABN Spanish pdf
    
    Examples:
	| QueryForRegistrationID         | QueryForEncountered        |
	| QueryNeccessityRegistrationID  | QueryNeccessityEncounterID |

  @391779 
  Scenario Outline: Verification of Log Followup action functionality
    Given user is on account detail page
    When user click on the "Search" button on blue ribbon
    And user fetch the "<QueryForEncountered>" get EncounterID
    And user enters the EncounterID into search field
    And user clicks on the Search button
    When user clicks on "R1 Necessity" moduleTab 
    And user select activity "Option 1: Patient signed ABN, bill Medicare" from activity drop down
    And user enters text "Note123Test" into Note text box
    And Disposition drop down should disappear
    And user clicks on the Add button
    Then user should be able to view new log under FollowUp history section with note "Note123Test"
    
   Examples:
	 | QueryForEncountered        |
	 | QueryNeccessityEncounterID | 

  @392057 
  Scenario Outline: Verification Necessity Incomplete subfolder accounts
    Given user is on account detail page
    When user clicks on the Necessity Incomplete filter
    And user fetch the "<QueryForIncompleteAccount>" and verify with UI
    When user clicks on any Unassigned Account 
    And user clicks on "R1 Necessity" moduleTab 
    Then user should be able to view the status Incomplete, Redo or Assigned
    
    Examples:
	 | QueryForIncompleteAccount                  |
	 | QueryNecessityIncompleteAccountEncounterID |

  @393848 
  Scenario Outline: Verification of Exceptions visible on the Necessity Tab
    Given user is on account detail page
    When user click on the "Search" button on blue ribbon
    And user fetch the "<QueryForRegistrationID>" get registrationID
    And user fetch the "<QueryForEncountered>" get EncounterID
    And user enters the EncounterID into search field
    And user clicks on the Search button
    When user clicks on "Services" moduleTab 
    And user take checkout on account
    And user search the service "skin"
    Then user clicks on the searched service link
    And user clicks on any diagnosis link
    And user clicks on "R1 Necessity" moduleTab 
    And user clicks on "Complete" button
    Then user should be able to view the exceptions
      | Necessity Actions  | Please select a valid action to complete the task  |
      | Necessity Services | Please complete the Services Task before Necessity |
    And user should be able to view Necessity tab color in RED
    When user clicks on "Services" moduleTab 
    And user clicks on "Complete" button
    Then user should be able to view Service tab color in BLUE
    And user clicks on "R1 Necessity" moduleTab 
    And user clicks on "Complete" button
    Then user should be able to view the critical exception "Critical Exceptions Exist - Completion not allowed."
    And user should be not able to view the exception "Necessity Services  Please complete the Services Task before Necessity"
    And user should be able to view Necessity tab color in RED
    And user should be able to view Service tab color in BLUE
    When user select activity "Option 2: Patient signed ABN, do not bill Medicare" from activity drop down
    And user clicks on the Add button
    When user clicks on "Complete" button
    Then user should be able to view the critical exception "Critical Exceptions Exist - Completion not allowed."
    And user should be able to view the exception "Necessity Actions  Please select a valid action to complete the task"
    And user should be able to view Necessity tab color in RED
    When user select activity "Option 1: Patient signed ABN, bill Medicare" from activity drop down
    And user clicks on the Add button
    When user clicks on "Complete" button
    And user should be not able to view the exception "Necessity Actions  Please select a valid action to complete the task"
    And user should be able to view Necessity tab color in BLUE
    
   Examples:
	| QueryForRegistrationID         | QueryForEncountered        |
	| QueryNeccessityRegistrationID  | QueryNeccessityEncounterID | 

  @393862 
  Scenario Outline: Verify the criteria of Necessity to be visible on tab menu
    Given user is on account detail page
    When user click on the "Search" button on blue ribbon
    Then user fetch the outpatient "<QueryForEncountered>"
    And user enters the EncounterID into search field
    And user clicks on the Search button
    Then Necessity tab should not be visible
    When user clicks on "Coverage" moduleTab 
    And user take checkout on account
    When user add "Medicare" coverage
    Then user should be able to view COB as 1
    When user clicks on "Complete" button
    Then user should be able to view Coverage tab color in BLUE
    When user clicks on "Patient" moduleTab 
    Then user should be able to view the patient type as O on demographic details panel
    And user clicks on "Complete" button
    Then user should be able to view Patient tab color in BLUE
    And Necessity tab should be visible
    
    Examples:
	 | QueryForEncountered         |
	 | QueryPatientTypeEncounterID |
    
