 @CWL
 Feature: verify CWL functionality
 
 Background: Facility selects
 Given user is on R1 hub page
 When user clicks on facility list
 And user select the facility
 
 @391785
 Scenario: CWL_Verify that end user is able to see mapped Plan Codes
 When user clicks on "Settings" link 
 Then List of sub-menus should be displayed in left panel
 When user clicks on "Payor and Plan Config" side submenu
 Then Sub menu list of worklist for "Payor and Plan Config" menu should be displayed
 When Click on 'Conversion Plan Mapping' sub menu
 Then All the necessary plan codes which are mapped into CWL should be displayed
 
 @391787
 Scenario: CWL_Verify the filter folders in the worklist
 When user clicks on "Patient Access" link 
 And user clicks on "Conversion Followup" side submenu
 Then verify following filter folder lists
 
 @391788
 Scenario: CWL_Verify records in I/S at Risk filter folder
 When user clicks on "Patient Access" link 
 And user clicks on "Conversion Followup" side submenu
 Then user clicks "I/S at Risk"
 And verify "PT" value
 And Verify NFU date
 And Verify Total Open Balance value
 And LA column<> "Referred to Care Coverage" / "Referred to Supervisor" 
 
 @391789
 Scenario: CWL_Verify records in E/O at Risk filter folder
 When user clicks on "Patient Access" link
 And user clicks on "Conversion Followup" side submenu
 Then user clicks E/O at Risk
 And verify "PT" value as 'E' OR 'O' 
 And Verify NFU date
 And Verify Total Open Balance value
 And LA column<> "Referred to Care Coverage" / "Referred to Supervisor" 
  
 @391790
 Scenario: CWL_Verify records in Future Follow Up filter folder
 When user clicks on "Patient Access" link
 And user clicks on "Conversion Followup" side submenu
 Then user clicks Future Follow Up 
 And Verify NFU date
 And Verify Total Open Balance value
 And LA column<> "Referred to Care Coverage" / "Referred to Supervisor" 
 
 @391791
 Scenario: CWL_Verify records in Zero Balance filter folder
 When user clicks on "Patient Access" link
 And user clicks on "Conversion Followup" side submenu
 Then user clicks Zero Balance 
 And verify total open balance=0
 And LA column<> "Referred to Care Coverage" / "Referred to Supervisor"

 
 
 
 
 

 
 
 
 
 
  

 
 
 
 
 

 

 
 
 



 



















 

 
 
 

 

 

  
 
 

 

 

 


 
