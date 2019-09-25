Feature: Verifiy the functionality of Patient operations 

Background: user navigates to Service Field Scope Configuration 
	Given user is on R1 hub page 
	When user clicks on facility list 
	And user select the facility 
	And user clicks on "Patient Access" link 
	And user clicks on "Pre-Registration" side submenu
	
@419174 @Patient-P
Scenario Outline:
Verify that user should be able to edition and deletion guarantor details functionality for guarantor panel 
	When user runs the query "<QueryForGurantorPanel>" for patient details 
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	Then user should be able to view on Account Level Details Page 
	When user clicks on "Patient" moduleTab 
	And user clicks on checkout button 
	And user clicks on edit button 
	Then user should be able to modify fields 
	When user clicks on gurantorupdate button 
	Then user should be able to view the popup containing message "Are you sure?" with ok and cancel button 
	When user clicks on ok button 
	Then user should be able to view updated values 
	When user clicks on delete button 
	Then user should be able to view the popup containing message "Are you sure?" with ok and cancel button 
	Examples: 
		| QueryForGurantorPanel                           |
		| r1accessQuery_419174_PatientEncounterid         | 
	
@419180 @Patient-N 
Scenario Outline: Verify all Critical Exceptions populates in Exception Panel 
	When user runs the query "<QueryForCriticalAccount>" for patient details 
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button	
	And user clicks on "Patient" moduleTab 
	Then user should be able to view on Account Level Details Page 
	And user clicks on checkout button 
	Then user should be able to view and clear the fields Address City Zip. 
	When user clicks on update button 
	When user checked on checkbox 
	And user clicks on update button 
	Then user should be able to view the critical message "Street Number not valid." 
	And user should be able to view the critical message "Patient Address- Street Address Missing Patient Address-City Missing Patient Address-Zip Missing." 
	When user clicks on complete button 
	Then user should be able to view message "Critical Exceptions Exist-Completion not allowed" 
		Examples: 
		| QueryForCriticalAccount                          |
		| r1accessQuery_419180_PatientEncounterid          | 
	
@419181 @Patient-ND 
Scenario Outline: Verify all Non-Critical Exceptions populates in Exception Panel 
	When user runs the query "<QueryForNonCriticalAccount>" for patient details 
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	Then user should be able to view on Account Level Details Page 
	When user clicks on "Patient" moduleTab 
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
		Examples: 
		| QueryForNonCriticalAccount                       |
		| r1accessQuery_419180_PatientEncounterid          |    
	
@419183 @Patient-p 
Scenario Outline:
Verify for Override functionality when both Exception Level 1 & Level 2 exist on account 
	When user runs the query "<QueryForExceptionLevel>" for patient details 
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	When user clicks on "Patient" moduleTab 
	Then user should be able to view on Account Level Details Page 
	And user clicks on checkout button 
	Then user should be able view patient tab color as red 
	When user clicks on complete button 
	Then user should be able to view message "Critical Exceptions Exist - Completion not allowed." 
	Examples: 
		| QueryForExceptionLevel                          |
		| r1accessQuery_419180_PatientEncounterid         |    
	
@419182 @Patient-P 
Scenario Outline: Verify checkboxes present in with level of Patient visit and address 
	When user runs the query "<QueryForPatientAccount>" for patient details 
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	Then user should be able to view on Account Level Details Page 
	When user clicks on "Patient" moduleTab 
	Then user should be able to clicks on checkout button by run query "<QueryForPatientCheckBoxState>" 
		
	Examples: 
		| QueryForPatientAccount                  | QueryForPatientCheckBoxState	   |
		| r1accessQuery_393733_PatientEncounterid | r1accessQuery_393733_PatientCheckBoxState |
		
	
@419169 @PatientP 
Scenario Outline:
Verify Skip Trace functionality for fresh discharged patient account (Irrespective of address exception) 
	When user runs the query "<QueryForPatientdischargeAccount>" for patient details
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	And user clicks on "Patient" moduleTab 
	Then user should be able to view on Account Level Details Page 
	And user should be able to clicks on checkout button 
	And user should be able to view patient information
	And user should be able to view skip button 
	When user clicks on skip button 
	And user click on ok button 
	Then user should be able to view address grid 
	When user click lastname link of grid 
	Then user should be able to view lastname updated address 
	Examples: 
		| QueryForPatientdischargeAccount                          |
		| r1accessQuery_419169_PatientEncounterid                 |
	
@419170 @Patient-p
Scenario Outline:
Verify Skip Trace functionality for an account which is not discharged and no address exception on it (irrespective of previously skip traced or not) 
	When user runs the query "<QueryForPatientNotdischargeAccount>" for patient details
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	Then user should be able to view on Account Level Details Page 
	When user clicks on "Patient" moduleTab 
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
	Examples: 
		| QueryForPatientNotdischargeAccount                     |
		| r1accessQuery_419170_PatientEncounterid                |
		
@419171 @Patient 
Scenario Outline:
Verify Skip Trace functionality for account that is not discharged as yet and is previously skip traced with Trace Date less than/ Equal to Rerun days in facility settings and has address exception existing on the account 
	When user runs the query "<QueryForPatientNotDischage>" for patient details
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	Then user should be able to view on Account Level Details Page 
    When user clicks on "Patient" moduleTab  
	Then user should be able to clicks on checkout button 
	And user should be able to view patient information 
	And user should be able to view skip button with date 
	When user clicks on skip show trace button 
	Then user should be able to view address grid 
	When user click lastname link of grid 
	Then user should be able to view lastname updated address 
		Examples: 
		| QueryForPatientNotDischage                     |
		| r1accessQuery_419171_PatientEncounterid        |
	
	
@419172 @PatientND
Scenario Outline:
Verify Skip Trace functionality for account that is not discharged and is previously skip traced with Trace Date greater than Rerun days in facility settings and has address exception existing on it 
	 When user runs the query "<QueryForSkipRaceGreaterReturn>" for patient details  
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	And user clicks on "Patient" moduleTab
	Then user should be able to view on Account Level Details Page 
	And user should be able to clicks on checkout button 
	And user should be able to view patient information 
	And user should be able to view and alter the SSN Address
	When user clicks on update button 
	When user checked on checkbox 
	And user clicks on update button
	Then user should be able to view skip button with date 
	When user clicks on skip show trace button 
	Then user should be able to view address grid 
	When user click lastname link of grid 
	Then user should be able to view lastname updated address 
		Examples: 
		| QueryForSkipRaceGreaterReturn                 |
		| r1accessQuery_419172_PatientEncounterid        | 
	
@419173 @Patient-N
Scenario Outline:
Verify Show Trace <date> and kip Trace button functionality for guarantor panel 
 When user runs the query "<QueryForPatientGurantorAccount>" for patient details  
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	And user clicks on "Patient" moduleTab
	Then user should be able to view on Account Level Details Page 
	And user should be able to clicks on checkout button 
	When uhen user clicks on Add gurantor button 
	Then user should be able to add values 
	When uhen user clicks on update button 
	When user clicks on edit button 
	And user click on ok button 
	Then user should be able to view address grid 
	When user click lastname link of grid 
	Then user should be able to view lastname updated address 
	
	Examples: 
		| QueryForPatientGurantorAccount                 |
		| r1accessQuery_419173_PatientEncounterid        | 
				
	
@419166 @Patient-P
Scenario: Verify for 'Add New Account' functionality in R1Access 
	When user clicks on New link 
	Then Then new page should get opened with blank required fields 
	When user Add fill fields 
	Then new account should be created 
	
@419167 @Patient 
Scenario Outline: Verify 'Update' functionality on 'Patient' tab of an account 
 When user runs the query "<QueryForPatientUpdateFunctionality>" for patient details  
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
	And user clicks on "Patient" moduleTab 
	And user make changes against the SSN field but not adding any other digits 
	And user clicks on update button 
	And Update Patient Record? With unchecked checkbox should display in front of Skip Trace button 
	When user set the value as Checked for the Update Patient Record to checked 
	And user clicks on Update button 
	Then Value of SSN should get updated 
	And Patient Tab turn into Blue 
	When user clicks on "Patient" moduleTab 
	Then user should be able to clicks on checkout button 
	Then Patient Visit and Address Panel should get displayed 
	And user clicks on Update button 
	Then Value of SSN should get updated 
	And user clicks on Update button 
	Examples: 
		| QueryForPatientUpdateFunctionality                      |
		| r1accessQuery_419167 _PatientEncounterid                |
	
@419168 @Patient=P 
Scenario Outline: Verify address verification functionality 
  When user runs the query "<QueryForPatientAddressVerification>" for patient details  
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	And user clicks on "Patient" moduleTab 
	Then user should be able to view on Account Level Details Page 
	And user should be able to clicks on checkout button 
	When user enter invalid address in mandatory fields 
	And clicks on Update button 
	Then display message Record Updated should visible at bottom left of Patient visit and Address Panel 
	When user clicks on Complete button 
	Then user should be able to view the critical message "Street Number not valid." 
	And Exceptions Exist - Are you sure you want to mark the task complete? With Continue & Cancel button should display 
	When user clicks on Continue button 
	And user clicks on "Log" moduleTab 
	Then user clicks on "Patient" moduleTab
	Examples: 
		| QueryForPatientAddressVerification                    |
		| r1accessQuery_419180_PatientEncounterid               |
	

@419179 @Patient-N 
Scenario Outline:
Verify that Patient tab should not automatically reopen without any exception message on front end. 
	 When user runs the query "<QueryForPatientAddressVerification>" for patient details  
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	And user clicks on "Patient" moduleTab 
	Then user should be able to view on Account Level Details Page 
	And user should be able to clicks on checkout button 
	When user clicks on Complete button 
	Then Patient Tab turn into Blue 
	And Patient Tab not load 
	When user clicks on "Log" moduleTab 
	Then use should be verify complete status 
	 When user runs the query "<QueryForPatientAddressVerification>" for patient details  
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	Then Patient Tab not load 
		Examples: 
		| QueryForPatientAddressVerification                      |
		| r1accessQuery_419179 _PatientEncounterid                |     
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
