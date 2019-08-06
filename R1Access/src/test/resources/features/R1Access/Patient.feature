Feature: Verifiy the functionality of Patient operations

  Background: user navigates to Service Field Scope Configuration
  Given user is on R1 hub page
  When user clicks on facility list
  And user select the facility "SJMA - St. John Macomb-Oakland Hospital"
  And user clicks on Patient Access link
  And user clicks on Pre-Registration
  Then user should be able to view Account Worklist Grid 
    
 @391770 @Patient
  Scenario: Verify that user should be able to edition and deletion guarantor details functionality for guarantor panel
  When user run the query and fetch the encounteridOne 
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  And user clicks on checkout button
  And user clicks on edit button 
  Then user should be able to modify fields
  When user clicks on gurantorupdate button
  Then user should be able to view the popup containing message "Are you sure?" with ok and cancel button
  When user clicks on ok button
  Then user should be able to view updated values
  When user clicks on delete button
  Then user should be able to view the popup containing message "Are you sure?" with ok and cancel button
 
  
 @393731 @Patient
  Scenario: Verify all Critical Exceptions populates in Exception Panel
  When user run the query and fetch the encounteridTwo 
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  And user clicks on checkout button
  Then user should be able to view and clear the fields Address City Zip. 
  When user clicks on update button
  Then user should be able to view Update Patient Record? checkbox with unchecked state
  When user checked on checkbox
  And user clicks on update button
  Then user should be able to view the critical message "Street Number not valid."  
  And user should be able to view the critical message "Patient Address- Street Address Missing Patient Address-City Missing Patient Address-Zip Missing."  
  When user clicks on complete button
  Then user should be able to view message "Critical Exceptions Exist-Completion not allowed"                        

@393732 @Patient
  Scenario: Verify all Non-Critical Exceptions populates in Exception Panel
  When user run the query and fetch the encounteridThree 
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  And user clicks on checkout button
  Then user should be able to view and clear the fields Address City Zip.  
  When user clicks on update button
  Then user should be able to view Update Patient Record? checkbox with unchecked state
  When user checked on checkbox
  And user clicks on update button
  Then user should be able to view the critical message "Street Number not valid."  
  And user should be able to view the critical message "Patient Address- Street Address Missing Patient Address-City Missing Patient Address-Zip Missing."  
  When user clicks on complete button
  Then user should be able to view message "Exceptions Exist-Are you sure you want to mark the task complete?" with ok and cancel button 
  When user clicks on cancel button
  Then user should able to view the incomplete state of account
  When user clicks on ok button
  Then user should able to view the complete state of account  

@393856 @Patient
  Scenario: Verify for Override functionality when both Exception Level 1 & Level 2 exist on account
  When user run the query and fetch the encounteridFour
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  Then user should be able view patient tab color as red
  When user clicks on complete button
  Then user should be able to view message "Critical Exceptions Exist - Completion not allowed" with ok and cancel button 
  And user should be able to patient tab color as red

@393733 @Patient
  Scenario: Verify checkboxes present in with level of Patient visit and address
  When user run the query and fetch the encounteridFifth
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  Then user should be able to clicks on checkout button
  And user should be able to view patient details
  And user verify the patient tab color
   When user clicks on complete button
  Then user should be able to view message "Critical Exceptions Exist-Completion not allowed"
   And user verify the patient tab color
