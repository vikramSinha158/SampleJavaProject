@FCC
Feature: Verification of FCC functionality and attributes

  Background: user navigates to FCC worklist page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility "SJMA - St. John Macomb-Oakland Hospital"
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
  Then user should be able to view the selected facility "SJMC - St. John Hospital and Medical Center"
  
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
  And user clicks on the "FCC" tab
  And user select activity from activity drop down
  And user select disposition from disposition drop down
  And user enters text "Note" into Note text box
  And user clicks on the Add button
  Then user should be able to view the follow up labels with type "Coverage Workflow" and note "Note"
  When user clicks on the "Log" tab
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

  @391674
  Scenario: Verify user is able to take action by using "FCC Contact" worklist
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
  	Scenario: Verify a task for FCC Contact for Pre-registration worklist is available in Facility Setting Configuration (only for facility OCWI, MCWI or SHWI)
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
  	
  	
    