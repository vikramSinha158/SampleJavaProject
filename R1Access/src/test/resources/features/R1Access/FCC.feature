Feature: Verification of FCC functionality and attributes

  Background: user navigates to FCC worklist page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility "SJMA - St. John Macomb-Oakland Hospital"
    And user clicks on "FCC" link
    And user clicks on "Global Coverage Follow Up" link

  @391664 @FCC
  Scenario: Verify that user is able to access FCC tab under worklist
    Given user is on FCC worklist
    When user clicks on any record on the worklist
    And user clicks on the "FCC" tab
    Then user should be able to verify the patient details above the tabs

  @391665 @FCC
  Scenario: Verify User should be able to select the Facility from the Top dropdown
    Given user is on FCC worklist
    When user clicks on facility list
    And user select the facility "SJMC - St. John Hospital and Medical Center"
    Then user should be able to view the selected facility

  @391666 @FCC
  Scenario: Verify User should be able to go to the next FCC tab while clicking Right VCR > button.
    Given user is on FCC worklist
    When user clicks on any record on the worklist
    And user clicks on the right VCR > button
    Then user should be able to view the next account FCC Tab

  @391667 @FCC
  Scenario: Verify that user is able to filter worklist data
    Given user is on FCC worklist
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
    Then user should be able to view the worklist
    When user clicks on the Clear button
    And user clicks on the column header
    Then worklist data should appear in ascending order
    When user clicks on the column header
    Then worklist data should appear in descending order
    When user select patient type "Inpatient"
    Then user should be able to view the I in PT column
