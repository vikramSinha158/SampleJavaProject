Feature: Verify PFA functionality

  Background: user navigates to R1 hub page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility "SJPK - Providence and Providence Park Hospital"
    
    
  @418872@PFA
  Scenario: Verify the user is able to see PFA tab color as RED for the uninsured patients BLUE for insured patients
    When user clicks on "Patient Access" link
    And user clicks on "R1 detect" link
    And user clicks on Unworked subfolder
    And user open an account from unworked subfolder worklist
    Then "PFA" tab color should be visible "Red" 
    And status should be "Incomplete" appear
    When user clicks on "Coverage" tab 
    And check out the account 
    And user run the query and fetch "PayorCode"
    And add coverage by click on plus button
    And user enters the payor code in search text box
    And user clicks on find button
    And user select plan code from search result grid
    And click on Add button
    And user changes coverage status as "Passed" in verified column
    When user clicks on "Complete" button
    And user clicks on "PFA" tab
    Then "PFA" tab color should be visible "Blue" 
    #And status should be "Completed" appear
    
  @418875@PFA
    Scenario: Verify the workflow of the common data needs section under 'Screening Needs' tab
     When user clicks on "Patient Access" link
     And user clicks on "R1 detect" link
     And check out the account
     And select all the question answer on Screening Questions tab
     And user clicks on save and continue button 
     Then first section should be common data needs appear on screening needs tab
     And Total income text box should be disable and should display "0" by default
     And Annual Income text box should be disable and should display "0" by default
     And FPL text box should be disable and should display "0" percent by default
    
    
