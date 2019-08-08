Feature: Verify the Service Automation Rule functionality

  Background: user navigates to Patient Shopper Tool page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility "SJMA - St. John Macomb-Oakland Hospital"
    And user clicks on setting link
    And user clicks on IT Tool
    And user clicks on Zero-Touch-Residual-Configuration 
    
  @396632 @ServiceAutomationRule
  Scenario: Verify create a new Service Automation Rule and Services get added on the account having matching rule
    Given User is on Zero-Touch-Residual-Configuration Page
    When user add service automation rule by click on add button
    And user enters rule name "SARTesting" ,Patient Type "O" ,Facility Patient Type "O"
    And user should able to view rule Accuracy is "100"
    And enter CPT Code "99283"
    And user click on check boxes for Is Enabled and Complete Service Task  
    And user click on save button
    Then user should able to view newly created rule in Service Automation Rule worklist
    When user clicks on setting link
    And user clicks on IT Tool
    And user clicks on Service Bus Monitor
    And user click on Message Publish plus button
    And user enters Facility code "SJMA" and "taskID"
    And user clicks on publish button
    And user clicks on "Patient Access" link
    And user clicks on "Pre-Registration" link
    And user clicks on show all button
    And user select a value "Outpatient Diagnostic" from patient type dropdown
    And user clicked Unassigned Account
    Then verify Service associated with automation rule should get added to account and service tab should get completed 
    
   @396633 @ServiceAutomationRule
   Scenario: Verify that newly created Service Automation rules has accuracy as 100% and accuracy can't be edited while editing a Service Automation rule
   Given User is on Zero-Touch-Residual-Configuration Page 
   When user select any service automation rule and clicks on edit button
   Then user enters rule name "TestAccuracy" ,Patient Type "O" ,Facility Patient Type "O"
   And user should not able to edit accuracy value