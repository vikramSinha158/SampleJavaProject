@FCC
Feature: Verification of FCC functionality and attributes

  Background: user navigates to FCC worklist page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility
    And user clicks on "FCC" menu

  @391664
  Scenario: Verify that user is able to access FCC tab under worklist
    Given user is on R1 FCC menu page
    When user clicks on "Global Coverage Follow Up" menu
    Then user is on FCC "FCC Coverage Workflow" worklist
    When user clicks on any record on the worklist
    And user clicks on the "FCC" tab
    Then user should be able to verify the patient details above the tabs

  @391665
  Scenario: Verify User should be able to select the Facility from the Top dropdown
    Given user is on R1 FCC menu page
    When user clicks on "Global Coverage Follow Up" menu
    Then user is on FCC "FCC Coverage Workflow" worklist
    When user clicks on facility list
    And user select the facility "SJMC - St. John Hospital and Medical Center"
    Then user should be able to view the selected facility "SJMC"

  @391666
  Scenario: Verify User should be able to go to the next FCC tab while clicking Right VCR > button.
    Given user is on R1 FCC menu page
    When user clicks on "Global Coverage Follow Up" menu
    Then user is on FCC "FCC Coverage Workflow" worklist
    When user clicks on any record on the worklist
    And user clicks on the right VCR > button
    Then user should be able to view the next account FCC Tab

  @391667
  Scenario: Verify that user is able to filter worklist data
    Given user is on R1 FCC menu page
    When user clicks on "Global Coverage Follow Up" menu
    Then user is on FCC "FCC Coverage Workflow" worklist
    Then user select value from Filter and operator drop down
      | Facility     |
      | Acct#        |
      | PT           |
      | Svc          |
      | Svc_Loc      |
      | Days         |
      | New          |
      | FirstName    |
      | LastName     |
      | P_Payor      |
      | P_PlanCD     |
      | P_Status     |
      | S_Payor      |
      | S_Plan       |
      | S_Status     |
      | Audit        |
      | Disposition  |
      | FollowupDate |
      | IsAuthCreate |
    When user select the filter "Acct#"
    And user select the operator "LIKE"
    And user enters text "00" into text box
    And user clicks on the Filter button
    Then user should be able to view the worklist with account containing "00"
    When user clicks on the Clear button
    And user clicks on the column header
    Then worklist data should appear in ascending order
    When user clicks on the column header
    Then worklist data should appear in descending order
    When user select patient type "Inpatient"
    Then user should be able to view the I in PT column

  @391669 @391670
  Scenario: Verify that user is able to filter worklist data and log tab
    Given user is on R1 FCC menu page
    When user clicks on "Global Coverage Follow Up" menu
    Then user is on FCC "FCC Coverage Workflow" worklist
    When user clicks on any record on the worklist
    And  user clicks on "FCC" moduleTab
    And user select activity from activity drop down
    And user select disposition from disposition drop down
    And user enters text "Note" into Note text box
    And user clicks on the Add button
    Then user should be able to view the follow up labels with type "Coverage Workflow" and note "Note"
    When user clicks on "Log" moduleTab
    Then user should be able to view the action log labels with values and note "Note"

  @391671
  Scenario: Verify that user is able to access FCC Contact worklist
    Given user is on R1 FCC menu page
    When user clicks on "FCC Contact" menu
    Then user is on FCC "FCC Contact" worklist

  @391672
  Scenario: Verify that user is able to filter worklist data for FCC-Contact worklists
    Given user is on R1 FCC menu page
    When user clicks on "FCC Contact" menu
    Then user is on FCC "FCC Contact" worklist
    Then user select value from Filter and operator drop down
      | Facility     |
      | Acct#        |
      | PT           |
      | Svc          |
      | Svc_Loc      |
      | Days         |
      | New          |
      | FirstName    |
      | LastName     |
      | P_PlanCD     |
      | P_Status     |
      | PriorBalance |
      | Residual     |
      | Disposition  |
      | FollowupDate |
      | FollowupTime |
    When user select the filter "Acct#"
    And user select the operator "LIKE"
    And user enters text "00" into text box
    And user clicks on the Filter button
    Then user should be able to view the worklist with account containing "00"
    When user clicks on the Clear button
    And user clicks on the column header
    Then worklist data should appear in ascending order
    When user clicks on the column header
    Then worklist data should appear in descending order
    When user select patient type "Inpatient"
    Then user should be able to view the I in PT column

  @391673
  Scenario: Verify that user is able to access filter folder for FCC Contact worklist
    Given user is on R1 FCC menu page
    When user clicks on "FCC Contact" menu
    Then user is on FCC "FCC Contact" worklist
    When user clicks on the FCC Contact filter in filter folder
    Then user should be able to view records
    When user clicks on the "Clearance Incomplete" filter
    Then user should be able to view records
    And user should be able to view the "Clearance Incomplete" title on worklist
    When user clicks on the "Universal Host" filter
    Then user should be able to view records
    And user should be able to view the "Universal Host" title on worklist
    When user clicks on the "Services Incomplete" filter
    Then user should be able to view records
    And user should be able to view the "Services Incomplete" title on worklist
    When user clicks on the "Services Complete" filter
    Then user should be able to view records
    And user should be able to view the "Services Complete" title on worklist
    When user clicks on the "Verify Re-Reg" filter
    Then user should be able to view records
    And user should be able to view the "Verify Re-Reg" title on worklist
    When user clicks on the sub filter "01-Incomplete Universal Host" under filter "Universal Host"
    Then user should be able to view records
    And user should be able to view the "01-Incomplete Universal Host" title on worklist
    When user clicks on the sub filter "02-Sch. Update" under filter "Universal Host"
    Then user should be able to view records
    And user should be able to view the "02-Sch. Update" title on worklist
    When user clicks on the sub filter "03-Sch. Complete" under filter "Universal Host"
    Then user should be able to view records
    And user should be able to view the "03-Sch. Complete" title on worklist
    When user clicks on the sub filter "Pt Liability" under filter "Services Complete"
    Then user should be able to view records
    And user should be able to view the "Pt Liability" title on worklist
    When user clicks on the sub filter "No Pt Liability" under filter "Services Complete"
    Then user should be able to view records
    And user should be able to view the "No Pt Liability" title on worklist

  @391674
  Scenario: Verify user is able to take action by using FCC Contact worklist
    Given user is on R1 FCC menu page
    When user clicks on "FCC Contact" menu
    Then user is on FCC "FCC Contact" worklist
    When user clicks on any record on the worklist
    And user clicks on the "FCC Contact" tab
    And user select activity from activity drop down
    And user select disposition from disposition drop down
    And user enters text "Note" into Note text box
    And user clicks on the Add button
    Then user should be able to view the follow up labels with type "FCC Contact" and note "Note"
    When user click on the "Worklist" button on blue ribbon
    Then user should be able to view the added Disposition and FollowUpDate as today's date

  @392059
  Scenario: Verify a task for FCC Contact for Pre-registration worklist is available in Facility Setting Configuration
    Given user is on hub page
    When user clicks on "Settings" menu
    And user clicks on "IT Tools" menu
    And user clicks on "FacilitySetting Configuration" menu
    Then user select the "Code" from search dropdown
    And user enter code "MCWI" in text field
    And user clicks on the search icon
    And user clicks on the view link
    Then user should be able to view the "Pre-Registration" in Facility Setting - Task section
    When user clicks on the Edit button against worklist "Pre-Registration"
    Then user should be able to view "FCC Contact" in Tasks detail window

  @392060
  Scenario Outline: Verify user should be able to take Activity & Disposition on FCC Contact tab under Pre-Registration worklist
    Given user is on R1 FCC menu page
    When user clicks on "Patient Access" link 
	And user clicks on "Pre-Registration" side submenu
    Then user is on "Pre-Registration" page
    When user clicks on facility list
    And user select the facility "MCWI"
    When user click on the "Search" button on blue ribbon
    Then user runs the query "<query>" for facility "MCWI"
    And user fetch the encounterID "<column>"
    Then user enters the encounterID into search field
    And user clicks on the Search button
    And user clicks on the "FCC Contact" tab
    And  user take checkout on account
    And user select activity from activity drop down
    And user select disposition from disposition drop down
    And user enters text "Note" into Note text box
    And user clicks on the Add button
    And user clicks on "Complete" button
    Then user should be able to view FCC Contact tab color in BLUE
    And user should be able to view the Status as Complete

    Examples: 
      | query            | column      |
      | queryEncounterID | EncounterID |

  @392109
  Scenario: Verify Search button  functionality.
    Given user is on R1 FCC menu page
    When user clicks on "Global Coverage Follow Up" menu
    Then user is on FCC "FCC Coverage Workflow" worklist
    When user click on the "Search" button on blue ribbon
    Then user should be able to view SSN:, L/F Name:, Med Rec: and Visit: labels
    Then user run the query and fetch the "EncounterID"
    And user enters the EncounterID into search field
    And user clicks on the Search button
    Then user should be able to view the searched visit number on patient details panel
