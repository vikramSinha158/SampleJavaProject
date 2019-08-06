Feature: Verify the Patient Shopper Tool functionality

  Background: user navigates to Patient Shopper Tool page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility "SJMA - St. John Macomb-Oakland Hospital"
    And user Clicks "Patient Access" link
    And user Clicks On "Prospective Patient Estimates"
  
  @391865 @ProspectivePatientEstimates
  Scenario: Verify patient section fields and error messages while mandatory fields are left blank
    Given User is on Prospective Patient Estimates Page
    When user click "New" link
    Then user should be able to view controls in patient section
    When user clicks on add button
    Then validation messages should display for empty fields
    
   @391864 @ProspectivePatientEstimates
  Scenario: Verify Add New Account functionality if patient is below eighteen years
    Given User is on Prospective Patient Estimates Page
    When user click "New" link
    And user enter first name "shla" and last name "hetha"
    And user select a value "I - Inpatient" from patient type dropdown
    And user enter values in DOB "02/02/2010" and Gender "Male" and Phone "9999999999" no fields
    And user clicks on add button 
    Then verify message as "You have saved person without guarantor while Person age below 18"
    And account should be present in the "worklist"
      
  @391864 @392093 @ProspectivePatientEstimates
  Scenario: Verify Add New Account functionality if patient is above eighteen years
    Given User is on Prospective Patient Estimates Page
    When user click "New" link
    And user enter first name "joe" and last name "niit"
    And user select a value "I - Inpatient" from patient type dropdown
    And user fill values in DOB "02/01/1987" and Gender "Male" and Phone "9999999999" no fields
    And user enter guarantor information first name "QA" and last name "Test"
    And user enter date of birth in "02/02/1987" field 
    And user clicks on add button 
    Then request should be submitted with success message "Record Created"
    
  @391867 @ProspectivePatientEstimates
  Scenario: Verify coverage detail section of patient on Prospective Patient Estimates Page
    Given User is on Prospective Patient Estimates Page  
    When user clicked Unassigned Account
    And user select a value from payor "AETNA" and plan "AMO - Aetna Medicare " dropdown and enter subscriber ID "Test1" in text box
    And user clicks on Add Coverage button 
    And user click on Check Eligibility button
    And user input a values in copay "7" ,coinsurance "12" , deductible "60" and MAXOOP "102" fields
    And user select a value "Passed" from the Status dropdown
    And user clicks on update coverage button
    Then user should be able to view updated value at Columns in Coverage Grid
    
  @391868 @391872 @ProspectivePatientEstimates
  Scenario: Verify Service Search functionality under Service section for inpatient account
    Given User is on Prospective Patient Estimates Page
    When user clicked Unassigned Account
    And user select a value "I - Inpatient" from patient type dropdown 
    And user clicked on update button
    And user select a value from payor "AETNA" and plan "AMO - Aetna Medicare " dropdown and enter subscriber ID "Test2" in text box
    And user clicks on Add Coverage button 
    And user click on Check Eligibility button
    And user input a values in copay "5" ,coinsurance "10" , deductible "50" and MAXOOP "103" fields
    And user select a value "Passed" from the Status dropdown
    And user clicks on update coverage button
    And user enters the DRG code "606" and pass into search text box
    And user clicks on search button
    And user clicks on add button from search result grid inorder to add the DRG 
    Then user should able to view added service in service selected grid

    
  @391870 @ProspectivePatientEstimates
  Scenario: Verify Service Search functionality under Service section for O, S, E account
    Given User is on Prospective Patient Estimates Page
    When user clicked Unassigned Account
    And user select Unassigned emergency "E - Emergency" Account
    And user clicked on update button
    And user select a value from payor "AETNA" and plan "AMO - Aetna Medicare " dropdown and enter subscriber ID "Test3" in text box
    And user clicks on Add Coverage button 
    And user click on Check Eligibility button
    And user input a values in copay "6" ,coinsurance "13" , deductible "52" and MAXOOP "109" fields
    And user select a value "Passed" from the Status dropdown
    And user clicks on update coverage button
    And user enters the CPT code "0042T" and pass into search text box
    And user clicks on search button
    And user clicks on add button from search result grid inorder to add the CPT 
    Then user should able to view added HCPC service in service selected grid
    
  @391871 @ProspectivePatientEstimates
  Scenario: Verify Patient Portion grid in Residual section for an account for which Non self-pay account and Coverage is passed 
    Given User is on Prospective Patient Estimates Page
    When user clicked Unassigned Account
    And user select a value "I - Inpatient" from patient type dropdown
    And user clicked on update button
    And user select a value from payor "AETNA" and plan "AMO - Aetna Medicare " dropdown and enter subscriber ID "Test4" in text box
    And user clicks on Add Coverage button 
    And user click on Check Eligibility button
    And user input a values in copay "12" ,coinsurance "20" , deductible "80" and MAXOOP "200" fields
    And user select a value "Passed" from the Status dropdown
    And user clicks on update coverage button
    And user enters the DRG code "606" and pass into search text box
    And user clicks on search button
    And user clicks on add button from search result grid inorder to add the DRG
    Then patient portion value should match with coverage grid
    
    
   
 
     
     
     
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
