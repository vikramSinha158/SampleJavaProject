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
   
   @391666 @FCC
   Scenario: Verify User should be able to go to the next FCC tab while clicking Right VCR > button.
   Given user is on FCC worklist
   When user clicks on any record on the worklist
   And user clicks on the right VCR > button
   Then user should be able to view the next account FCC Tab
   