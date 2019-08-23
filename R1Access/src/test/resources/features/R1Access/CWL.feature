 @CWL
 Feature: verify CWL functionality
 Background: Facility selects
 Given user is on R1 hub page
 When user clicks on facility list
 And user select the facility "SJMA - St. John Macomb-Oakland Hospital"
 @391785
 Scenario: CWL_Verify that end user is able to see mapped Plan Codes
 When Click on "Settings" menu
 Then List of sub-menus should be displayed in left panel
 When Mouse hover on "Payor and Plan Config" menu
 Then Sub menu list of worklist for "Payor and Plan Config" menu should be displayed
 When Click on 'Conversion Plan Mapping' sub menu
 Then All the necessary plan codes which are mapped into CWL should be displayed
 
 @391787
 Scenario: CWL_Verify the filter folders in the worklist
 When user click on "Patient Access"
 And user user clicks on Conversion Follow up
 Then verify following filter folder lists
 
 @391788
  Scenario: CWL_Verify records in "I/S at Risk" filter folder
  When user click on "Patient Access"
  And user user clicks on Conversion Follow up
  Then user clicks "I/S at Risk"
  And verify "PT" value
  And Verify NFU date
  And Verify Total Open Balance value
  And LA column<> "Referred to Care Coverage" / "Referred to Supervisor" 
  
  
   @391789
  Scenario: CWL_Verify records in "E/O at Risk" filter folder
 When user click on "Patient Access"
 And user user clicks on Conversion Follow up
  Then user clicks E/O at Risk
  And verify "PT" value as 'E' OR 'O' 
  And Verify NFU date
  And Verify Total Open Balance value
  And LA column<> "Referred to Care Coverage" / "Referred to Supervisor" 
  
  
 @391790
 Scenario: CWL_Verify records in "Future Follow Up" filter folder
  When user click on "Patient Access"
  And user user clicks on Conversion Follow up
  Then user clicks Future Follow Up 
  And Verify NFU date
  And Verify Total Open Balance value
  And LA column<> "Referred to Care Coverage" / "Referred to Supervisor" 
 
  @391791
 Scenario: CWL_Verify records in "Zero Balance" filter folder
  When user click on "Patient Access"
  And user user clicks on Conversion Follow up
  Then user clicks Zero Balance 
  And verify total open balance=0
  And LA column<> "Referred to Care Coverage" / "Referred to Supervisor"
 
@391809
Scenario: CWL_Verify "Care Coverage" filter folder and it's sub-folders
 When user click on "Patient Access"
 And user user clicks on Conversion Follow up
 And select any records from conversion followup
 Then record with "Conversion FU" tab loaded should be opened up
 And verify Secondary Audit Action panel displayed
 When save secondary audit action without selecting checkboxes
 Then Please select the action to update should be displayed
 And No record should get added to the "Action Log" panel
 When check all the checkboxes and select value from Final status dropdown and save
 Then verify "Action Log" panel records should be added
 But If "Audit Completed" is"Unchecked" no log goes for it 
 And Verify value in Disposition according to final status
 And Verify mass-update panel

 
 
 
 
 

 
 
 
 
 
  

 
 
 
 
 

 

 
 
 



 



















 

 
 
 

 

 

  
 
 

 

 

 


 
