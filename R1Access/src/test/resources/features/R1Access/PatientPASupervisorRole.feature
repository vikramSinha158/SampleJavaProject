Feature: Verifiy the functionality of Patient operations for PA Supervisor role 

Background: user navigates to Service Field Scope Configuration 
	Given user is on R1 hub page 
	When user clicks on facility list 
	And user select the facility "SJMA - St. John Macomb-Oakland Hospital" 
	When user clicks on Setting link 
	And user clicks on user managment of IT Tools 
	Then user clicks on ARSupervisor CheckBoxs 
	
@391772 @PASupervisorEnable 
Scenario:
Patient_Verify "Cancelled" checkbox status for account having totalcharges = 0 for an account having "PA Supervisor" role 
	When user run the query and fetch the encounteridForEqualZero 
	And user clicks on search button of menu 
	And user enter encounterid in search textbox 
	And user clicks on submit button 
	Then user should be able to view on Account Level Details Page 
	When user clicks on Patient tab 
	And user clicks on checkout button 
	Then user should be able to view cancelled checkbox in disableState mode 
	
@391773 @PASupervisorEnable 
Scenario:
Patient_Verify "Cancelled" checkbox status for account having totalcharges <> 0 for an account having "PA Supervisor" role 
	When user run the query and fetch the encounteridForNotEqualZero 
	And user clicks on search button of menu 
	And user enter encounterid in search textbox1 
	And user clicks on submit button 
	Then user should be able to view on Account Level Details Page 
	When user clicks on Patient tab 
	And user clicks on checkout button 
	Then user should be able to view cancelled checkbox in disableState mode 
	
