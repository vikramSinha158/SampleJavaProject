Feature: Verifiy the functionality of Patient operations for PA Supervisor role 

Background: user navigates to Service Field Scope Configuration 
	Given user is on R1 hub page 
	When user clicks on facility list 
	And user select the facility 
	When user clicks on Setting link 
	And user clicks on user managment of IT Tools 
	Then user clicks on ARSupervisor CheckBoxs 
	
@419175 @PASupervisorEnable 
Scenario Outline:
Patient_Verify "Cancelled" checkbox status for account having totalcharges = 0 for an account having "PA Supervisor" role 
  When user runs the query "<QueryForPatientTotalchargezero>" for patient details  
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	Then user should be able to view on Account Level Details Page 
	When user clicks on "Patient" moduleTab 
	And user should be able to clicks on checkout button 
	Then user should be able to view patient information 
	And user should be able to view cancelled checkbox in disableState mode 
	Examples: 
		| QueryForPatientTotalchargezero                         |
		| r1accessQuery_419175_PatientEncounterid                |
		
	
@419176 @PASupervisorEnable 
Scenario Outline:
Patient_Verify "Cancelled" checkbox status for account having totalcharges <> 0 for an account having "PA Supervisor" role 
    When user runs the query "<QueryForPatientNotdischargeAccount>" for patient details
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	Then user should be able to view on Account Level Details Page 
	When user clicks on "Patient" moduleTab 
	And user should be able to clicks on checkout button 
	Then user should be able to view patient information 
	And user should be able to view cancelled checkbox in disableState mode 
	
	Examples: 
		| QueryForPatientNotdischargeAccount                     |
		| r1accessQuery_419176_PatientEncounterid                |
		
	
