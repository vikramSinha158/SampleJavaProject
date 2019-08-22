Feature: Verifiy the functionality of Patient operations

  Background: user navigates to Service Field Scope Configuration
  Given user is on R1 hub page
  When user clicks on facility list
  And user select the facility "SJMA - St. John Macomb-Oakland Hospital"
  And user clicks on Patient Access link
  And user clicks on Pre-Registration
    
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
 And Then user should not able to view Gurantor tab;
  
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
  When user checked on checkbox
  And user clicks on update button
  Then user should be able to view the critical message "Street Number not valid."  
  And user should be able to view the critical message "Patient Address- Street Address Missing Patient Address-City Missing Patient Address-Zip Missing."  
  When user clicks on complete button
  Then user should be able to view message "Critical Exceptions Exist-Completion not allowed"                        

@393732 @Patient
  Scenario: Verify all Non-Critical Exceptions populates in Exception Panel
  When user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  And user clicks on checkout button
  Then user should be able to view and clear the fields Address City Zip.  
  When user clicks on update button
  When user checked on checkbox
  And user clicks on update button
  Then user should be able to view the critical message "Street Number not valid."  
  And user should be able to view the critical message "Patient Address- Street Address Missing Patient Address-City Missing Patient Address-Zip Missing."  
  When user clicks on complete button
  When user clicks on cancel button
  Then user should able to view the incomplete state of account
  When user clicks on ok button
  Then user should able to view the complete state of account  

@393856 @Patient
  Scenario: Verify for Override functionality when both Exception Level 1 & Level 2 exist on account
 When user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  And user checked on checkbox
  Then user should be able view patient tab color as red
  When user clicks on complete button
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
  
  @391874 @Patient
  Scenario: Verify Skip Trace functionality for fresh discharged patient account (Irrespective of address exception)
  When user run the query and fetch the encounterid for discharge patient
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  Then user should be able to clicks on checkout button
  And user should be able to view patient information
  And user should be able to view skip button
  When user clicks on skip button
  And user click on ok button
  Then user should be able to view address grid
  When user click lastname link of grid 
  Then user should be able to view lastname updated address
  
   @391875 @Patient
  Scenario: Verify Skip Trace functionality for an account which is not discharged and no address exception on it (irrespective of previously skip traced or not)
  When user run the query and fetch the encounterid for not discharge patient
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  Then user should be able to clicks on checkout button
  And user should be able to view patient information
  And user should be able to view skip and skip date button
  And user enter invalid address city and zip
  And user clicks on update button
  When user clicks on skip button
  And user click on ok button
  Then user should be able to view address grid
  When user click lastname link of grid 
  Then user should be able to view lastname updated address
  
  @419166 @Patient
  Scenario: Verify for 'Add New Account' functionality in R1Access
  When user clicks on New link 
  Then Then new page should get opened with blank required fields
  When user Add fill fields 
  Then new account should be created 
  
   @419167 @Patient
  Scenario: Verify 'Update' functionality on 'Patient' tab of an account
  When user run the query and fetch the encounterid for not having red tab
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then Patient Visit and Address Panel should get displayed
  Then user should be able to clicks on checkout button
  And Status should be appear incomplete
  And Patient tab color should be appear Red 
  When user make changes against the SSN field by adding one or two more digits  
  And user clicks on update button
  Then message should display as Invalid SSN at the bottom of the Patient Visit and Address Panel 
  When user clicks on the Patient tab 
  And user make changes against the SSN field but not adding any other digits 
  And user clicks on update button
  And Update Patient Record? With unchecked checkbox should display in front of Skip Trace button 
  When user set the value as Checked for the Update Patient Record to checked
  And user clicks on Update button 
 Then Value of SSN should get updated
  And Record updated message should be displayed 
  And Patient Tab turn into Blue 
  When user clicks on Log Tab 
  Then  user should be able to view the updated history 
  When user clicks on any Account where the Traffic light of P column is Red
  Then user should be able to clicks on checkout button
  Then Patient Visit and Address Panel should get displayed
  And Status should display in the ribbon as Incomplete with Red color
  When user update the exisiting SSN as Null
  And user update the existing phone field as Null
  And user clicks on Update button 
  Then message SSN has changed should display at the bottom of the panel 
  And Update Patient Records? checkbox with its value setted to Unchecked should display 
  When user set the value as Checked for the Update Patient Record?
  And user clicks on Update button 
  Then Value of SSN should get updated
  When user update the Phone and SSN fields with correct values 
  And user clicks on Update button 
  Then fields should get updated and exceptions should get removed 
  
  @419168 @Patient
 Scenario: Verify address verification functionality
 When user clicks on any Account where the Traffic light of P column is Blue
 And user clicks on search button of menu 
 And user enter encounterid in search textbox
 And user clicks on submit button
 Then Patient Visit and Address Panel should get displayed
 And user should be able to clicks on checkout button
And Patient Visit and Address Panel should be visible and details should be displayed 
 And verify the Ribbon color it should get changed into Red color and Status should be displayed as Redo
 When user enter invalid address in mandatory fields
 And clicks on Update button 
 Then display message Record Updated should visible at bottom left of Patient visit and Address Panel  
 When user clicks on Complete button 
 Then Street Number Not Valid with exception should display in exception panel
 And Exceptions Exist - Are you sure you want to mark the task complete? With Continue & Cancel button should display
 When user clicks on Continue button
 Then Tab gets completed and displays tab colour blue 
 And Status should be Completed
 When user clicks on the Patient Tab 
 And Verify the Patient Visit and Address panel
 Then Upadetd address should display
 And Street Number Not Valid exception message should display in exception panel 
 When user clicks on Log tab 
Then user should be able to view the updated history 
When user clicks on Patient tab
Then Tab will open 

  @419171 @Patient
  Scenario: Verify Skip Trace functionality for account that is not discharged as yet and is previously skip traced with Trace Date less than/ Equal to Rerun days in facility settings and has address exception existing on the account
  When user run the query and fetch the encounterid for previously skip traced and not discharged
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  Then user should be able to clicks on checkout button
  And user should be able to view patient information
  And user should be able to view skip button with date
  When user clicks on skip show trace button
  Then user should be able to view address grid
  When user click lastname link of grid 
  Then user should be able to view lastname updated address  
  
  @419172 @Patient
  Scenario: Verify Skip Trace functionality for account that is not discharged and is previously skip traced with Trace Date greater than Rerun days in facility settings and has address exception existing on it
  When user run the query and fetch the encounterid for previously skip traced and with greater then return days
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  Then user should be able to clicks on checkout button
  And user should be able to view patient information
  And user should be able to view skip button with date
  When user clicks on skip show trace button
  Then user should be able to view address grid
  When user click lastname link of grid 
  Then user should be able to view lastname updated address
    
  @419173 @Patient
  Scenario: Verify Show Trace <date> and kip Trace button functionality for guarantor panel
  When user run the query and fetch the encounterid for skip trace functionality on gurantor tab
  And user clicks on search button of menu 
  And user enter encounterid in search textbox
  And user clicks on submit button
  Then user should be able to view on Account Level Details Page
  When user clicks on Patient tab
  Then user should be able to clicks on checkout button
  When uhen user clicks on Add gurantor button 
  Then user should be able to add values 
  When uhen user clicks on update button
 Then user should be able to updated values
When user clicks on edit button 
  Then user should be able to update SSN number
  When user clicks on skip button of gurantor tab
  And user click on ok button
  Then user should be able to view address grid
  When user click lastname link of grid 
  Then user should be able to view lastname updated address
  
  
  






 

 

 
 

 
 

  

  
  

  

 

  

  

  
  

  



  


