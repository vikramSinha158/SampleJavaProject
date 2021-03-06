@Notes
Feature: Verify the workflow of Notes tab

  Background: user navigates to account detail page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility 
    And user clicks on "Patient Access" link
    And user clicks on "Pre-Registration" side submenu
    Then user should be able to view the "Pre-Registration" label on worklist page
    Then user clicks on any Unassigned Account
    
    @406413  
    Scenario: Verification of Notes entry drop down and attributes
    Given: user is on account detail page
    When user clicks on "Notes" moduleTab 
    Then user should be able to view Notes label
    And user clicks on the green + icon
    Then user should be able to view notes entry drop down
    And user clicks on the green + icon
    Then user should be able to view notes entry drop down
    And user clicks on "Patient" moduleTab 
    Then user should be able to view the Notes tab in blue color
    And user clicks on the green + icon
    Then user should be able to view notes entry drop down
    
    @406413  
    Scenario: Verification of Notes functionality for Note, PatientID and Prescription drop down menu with blank value
    Given: user is on account detail page
    When user clicks on "Notes" moduleTab 
    And user clicks on the green + icon
    And user select "Note" menu from drop down
    And user clicks on the Add button
    Then user should be able to view blank note with date and time stamped
    When user clicks on "Notes" moduleTab 
    And user clicks on the green + icon
    And user select "Patient ID" menu from drop down
    And user clicks on the Add button
    Then user should be able to view blank note with date and time stamped
    When user clicks on "Notes" moduleTab 
    And user clicks on the green + icon
    And user select "Prescription" menu from drop down
    And user clicks on the Add button
    Then user should be able to view blank note with date and time stamped 
    
    @406413  
    Scenario Outline: Verification of Notes functionality for Note, PatientID and Prescription drop down menu with alphanumeric and special characters and cancel functionality
    Given: user is on account detail page
    When user clicks on "Notes" moduleTab 
    And user clicks on the green + icon
    And user select "Note" menu from drop down
    And user enters text "Note123Test" into Note text box
    And user clicks on the Add button
    Then user should be able to view note "Note123Test" with date and time stamped
    And user fetch the "<QueryForEncountered>" from Query
    Then user verify the database column "<column>" with UI
    When user clicks on "Notes" moduleTab 
    And user clicks on the green + icon
    And user select "Patient ID" menu from drop down
    And user enters text "Patient123Test" into Note text box
    And user clicks on the Add button
    Then user should be able to view the pop up with labels and note "Patient123Test" 
    Then user should be able to view note "Patient123Test" with date and time stamped
    When user clicks on "Notes" moduleTab 
    And user clicks on the green + icon
    And user select "Prescription" menu from drop down
    And user enters text "Prescription123Test" into Note text box
    And user clicks on the Add button
    Then user should be able to view the pop up with labels and note "Prescription123Test"
    Then user should be able to view note "Prescription123Test" with date and time stamped
    When user clicks on "Notes" moduleTab 
    And user clicks on the green + icon
    And user select "Note" menu from drop down
    And user enters text "NoteTest" into Note text box
    And user clicks on the Cancel button
    Then user should not able to view added note "NoteTest"
    
    Examples:
    |QueryForEncountered   | column |
    |QueryNote_EncounterID | Note   |
  