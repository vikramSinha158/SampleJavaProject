Feature: Verify the Service Automation Rule functionality

  Background: user navigates to Patient Shopper Tool page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility "SJMC - St. John Hospital and Medical Center"
    And user clicks on setting link
    And user clicks on IT Tool
    And user clicks on Zero-Touch-Residual-Configuration 
    
  @392064 @ServiceAutomationRule
  Scenario: Verify create a new Service Automation Rule and Services get added on the account having matching rule
    Given User is on Zero-Touch-Residual-Configuration Page
    When user add service automation rule by click on add button
    And user enters rule name "TestAutomation123" ,Patient Type "O" ,Facility Patient Type "O" 
    And user should able to view rule Accuracy is "100.00"
    And enter CPT Code "99283"
    And user click on check boxes for Is Enabled and Complete Service Task  
    And user click on save button
    Then user should able to view newly created rule in Service Automation Rule worklist
    When user clicks on setting link
    And user clicks on IT Tool
    And user clicks on Service Bus Monitor
    And user click on Message Publish plus button
    And user enters Facility code "SJMC"
    And user clicks on publish button
    And user clicks on "Patient Access" link
    And user clicks on "Pre-Registration" link
    And user clicks on show all button
    And user select a value "Outpatient Diagnostic" from patient type dropdown
    And user clicked Unassigned Account
    Then verify Service associated with automation rule should get added to account and service tab should get completed 
    
   @392065 @ServiceAutomationRule
   Scenario: Verify that newly created Service Automation rules has accuracy as 100% and accuracy can't be edited while editing a Service Automation rule
   Given User is on Zero-Touch-Residual-Configuration Page 
   When user select any service automation rule and clicks on edit button
   Then user should not able to edit accuracy value
   
   @392066 @ServiceAutomationRule
   Scenario: Verify the functionality of Esc and Cancel button on Add Service Automation Rule window
     Given User is on Zero-Touch-Residual-Configuration Page
     When user add service automation rule by click on add button 
     Then user should able to view Add Service Automation Rule window
     When user clicks on cancel button
     Then Add Service Automation Rule window should disappear
     When user add service automation rule by click on add button
     And user enters rule name "TestServices" ,Patient Type "O" ,Facility Patient Type "O" 
     And user clicks on cancel button
     Then Add Service Automation Rule window should disappear
     
   @392067 @ServiceAutomationRule
   Scenario: Verify that user is able to Edit existing Service Automation Rule
    Given User is on Zero-Touch-Residual-Configuration Page 
    When user select any service automation rule and clicks on edit button
    And user enters rule name "TestQA" ,Patient Type "O" ,Facility Patient Type "O" 
    Then user should able to view updated value in Service Automation Rule panel
    
    @392068 @ServiceAutomationRule
   Scenario: Verify that user is able to Deactivate existing Service Automation rule  
     Given User is on Zero-Touch-Residual-Configuration Page
     When user select any existing service automation rule having Is Enable as True
     And user clicks on Deactivate button 
     Then value of Is Enabled should be updated as False
     When user clicks on setting link
     And user clicks on IT Tool
     And user clicks on Service Bus Monitor
     And user click on Message Publish plus button
     And user enters Facility code "SJMC"
     And user clicks on publish button
     And user clicks on "Patient Access" link
     And user clicks on "Pre-Registration" link
     And user clicks on show all button
     And user select a value "Outpatient Diagnostic" from patient type dropdown
     And user clicked Unassigned Account
     Then verify No service should get added from the audit and tab should not be completed  
     
    @392068 @ServiceAutomationRule
   Scenario: Verify that user is able to Activate existing Service Automation rule  
     Given User is on Zero-Touch-Residual-Configuration Page
     When user select any existing service automation rule having Is Enable as False
     And user clicks on Activate button 
     Then value of Is Enabled should be updated as True
     When user clicks on setting link
     And user clicks on IT Tool
     And user clicks on Service Bus Monitor
     And user click on Message Publish plus button
     And user enters Facility code "SJMC"
     And user clicks on publish button
     And user clicks on "Patient Access" link
     And user clicks on "Pre-Registration" link
     And user clicks on show all button
     And user select a value "Outpatient Diagnostic" from patient type dropdown
     And user clicked Unassigned Account
     Then verify service should get added from the audit and tab should be completed
    
     @392068 @ServiceAutomationRule
   Scenario: Verify that user is able to Delete existing Service Automation rule   
    Given User is on Zero-Touch-Residual-Configuration Page
    When user select any existing service automation rule
    And user Clicks on delete button
    Then selected Service Automation rule should get deleted successfully
    
    @392069 @ServiceAutomationRule
   Scenario: Verify Export functionality
   Given User is on Zero-Touch-Residual-Configuration Page
   When user clicks on Export button
   Then user should able to view exported excel in system   
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      