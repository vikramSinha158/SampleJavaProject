@PFA
Feature: Verify PFA functionality

  Background: user navigates to R1 hub page
    Given user is on R1 hub page
    When user clicks on facility list
    And user select the facility "SJPK - Providence and Providence Park Hospital"
    
    
  @418872
  Scenario: Verify the user is able to see PFA tab color as RED for the uninsured patients BLUE for insured patients
    When user clicks on "Patient Access" link
    And user clicks on show all button
    And user clicks on "R1 detect" link
    And user clicks on Unworked subfolder
    And user open an account from unworked subfolder worklist
    Then "PFA" tab color should be visible "Red" 
    And status should be "Incomplete" appear
    When user clicks on "Coverage" tab 
    And check out the account 
    And user run the query and fetch "PayorCode"
    And add coverage by click on plus button
    And user enters the payor code in search text box
    And user clicks on find button
    And user select plan code from search result grid
    And click on Add button
    And user changes coverage status as "Passed" in verified column
    When user clicks on "Complete" button
    And user clicks on "PFA" tab
    Then "PFA" tab color should be visible "Blue" 
    And user clicks on "release" button
    
   @418876
     Scenario: Verify Default answer for question Are you a resident of
     When user clicks on "Patient Access" link
     And user clicks on show all button
     And user clicks on "R1 detect" link
     And user fetch the "encounterid" from Query PFA_418876_SQL1
     And user clicks on SEARCH link
     And user enters the encounterid in visit Text field
     And user clicks on Search button
     And check out the account
     Then default answer Other should be select for "Are you a resident of:"
     And user clicks on "release" button 
    
    @419018
    Scenario: Verify Default answer for Are you a veteran and enrolled in the VA Health Care system for patient's age less than eighteen
     When user clicks on "Patient Access" link
     And user clicks on show all button
     And user clicks on "R1 detect" link
     And user fetch the "EncounterID" from Query PFA_419018_SQL1
     And user clicks on SEARCH link
     And user enters the encounterid in visit Text field
     And user clicks on Search button
     And check out the account
     Then there should be no answer selected as default
     And user clicks on "release" button
     
      @419018
    Scenario: Verify Default answer for Are you a veteran and enrolled in the VA Health Care system for patient's age greater than eighteen
     When user clicks on "Patient Access" link
     And user clicks on show all button
     And user clicks on "R1 detect" link
     And user fetch the "EncounterID" from Query PFA_419018_SQL2
     And user clicks on SEARCH link
     And user enters the encounterid in visit Text field
     And user clicks on Search button
     And check out the account
     Then there should be no answer selected as default
     And user clicks on "release" button
    
    @419037
    Scenario: Verify user is able to clear L1 Screening Questions answers by hitting Clear Answers button
     When user clicks on "Patient Access" link
     And user clicks on show all button
     And user clicks on "R1 detect" link
     And user clicks on Unworked subfolder
     And user open an account from unworked subfolder worklist
     And check out the account
     When user fill all the L1 Screening Questions
     And user clicks on Clear Answers button
     Then all selected answers should be clear appear
     Then First question Did the patient decline the screening questionnaire answer should be by deafult "No" selected
     And user clicks on "release" button
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
@418873
Scenario: Verify that the user is able to create PFA Screening question answer(Level 1)

When user clicks on Settings link
And user clicks on PFA Configuration link
And user clicks on PFA Level_1 Questions link
When user clicks on New button
And Input values in the Question Code "G002" and Question "Do you have a coverage" fields
And user clicks on is Active check box
And user clicks Add button
Then PFA Level1 question should be created with message "PFA Questions added successfully"
When user clicks on New Answer button
And user input values in the Answer Code "G002" and Answer Text "YES" fields
And user clicks on Cancel button.
Then PFA answers panel should not be appear
When user clicks on New Answer button
And user input values in the Answer Code "G002" and Answer Text "YES" fields
And user clicks on is Active Check box
And user clicks on Add Answer button.
Then new answer should be added in the answers grid with message "PFA Answer added successfully"
When user clicks on Link Answer button
And user clicks on cancel link answer button.
Then Answer dropdown list, Link New Answer button and Cancel button should not be appear.
When user clicks on Link Answer button
And user select an created answer from dropdown
And user clicks on Link new Answer button.
Then displays added answer in the answers grid placed under Update button 
And message "Answer added for the question successfully" appear
When user clicks on Unlink Answer button
And user select an answer from dropdown 
And user clicks on Unlink Existing Answer button.
Then message "Answer unlinked successfully for the question" appear for the question should be appear
And answer should not be appear in answer grid under Update button


@491028
Scenario: Verify Default Answer for Pregnancy related question in case of Sex is M

When user clicks on Patient Access link
And user clicks on show all button
And user clicks on R1 detect worklist
When user fetch the encounterid from Query PFA_419028_SQL10 
And user clicks on SEARCH link
And enters the encounterid in visit Text field
And user clicks on Search button
Then Default answer should be No selected for question "Are you pregnant or is your upcoming visit pregnancy related?" on L1Screening Questions tab
And user clicks on "release" button

@491029
Scenario: Verify Default Answer for Pregnancy related question in case of Sex is F and Age>54

When user clicks on Patient Access link
And user clicks on show all button
And user clicks on R1 detect worklist
When user fetch the encounterid from Query PFA_419029_SQL11
And user clicks on SEARCH link
And enters the encounterid in visit Text field
And user clicks on Search button
Then Default answer should be No selected for question "Are you pregnant or is your upcoming visit pregnancy related?" on L1Screening Questions tab
And user clicks on "release" button

@419032
Scenario: Verify PFA tab completed by Override tab

When user clicks on Patient Access link
And user clicks on show all button
And user clicks on R1 detect worklist
When user clicks on an account
And user clicks on override tab
And user verify FollowUp Date field 
Then Displays Date picker for Follow up date
And should display autofill Followup date in disabled textbox
When user clicks on save button without inserting any values
Then message should be displays "Please complete all the required Questions."
When user select value from funding sources dropdown 
And user select value from Action dropdown
And user clicks on checkbox
And user enters text in text box 
And user clicks on save button
Then message should be displayed "Record Added into CWL Successfully."
When user clicks on complete button
Then PFA tab turns blue appear with Completed status 
When user clicks on the Patient Access link
And user clicks on Conversion Followup worklist
And user clicks on show all button
And user select the value Account operator = from filter dropdown and enter encounter id in text box and click filter
Then account should be displayed in Conversion Follow up worklist with the above assigned funding source


@419038
Scenario: Verify multiple Funding Source should appear on Screening Needs tab

When user clicks on Patient Access link
And user clicks on show all button
And user clicks on R1 detect worklist
When user clicks on Unworked subfolder
And user open an account from unworked subfolder worklist
And user clicks on "Check Out" button
And user fill all the L1 Screening Questions
And user clicks on save and continue button
Then user should be navigate to Screening Needs tab
And multiple funding source should be displayed.
And user clicks on "release" button

@419039
Scenario: Verify patient's employment status check box, after submit the Common Data Needs section

When user clicks on Patient Access link
And user clicks on show all button
And user clicks on R1 detect worklist
And user clicks on Self Pay L2 in Process or Insured L2 in Process subfolder
And user open an account from subfolder worklist
And user clicks check out button
And user clicks on screening needs tab
And user enter the number of persons in the household
And user select the patient employment status
And user clicks on Submit all FS button
Then Common Data Needs bar colour should be GREEN
And selected employement status check box should be checked appear
When user clicks on complete button 
Then selected employement status check box should be checked
And user clicks on "release" button

 @419041
Scenario: Verify PFA tab color if  PFA Level_1 is saved with the questionnaire declined

When user clicks on Patient Access link
And user clicks on show all button
And user clicks on R1 detect worklist
When user clicks on Unworked subfolder
And user open an account from unworked subfolder worklist
And user clicks check out button
And Validate answer "No" for question Did the patient decline the screening questionnaire 
Then all the answers should be enabled appear on Screening Questions tab
When user clicks on Unworked subfolder
And user open an account from unworked subfolder worklist
And user clicks check out button
And user select the yes check box for question Did the patient decline the screening questionnaire
Then all the answers should be disabled appear on Screening Questions tab
When user clicks on complete button
Then PFA tab turns blue appear with Completed status
And user clicks on "release" button     
     
   
     
     
     
     
     
     
     
     
     
     
    
