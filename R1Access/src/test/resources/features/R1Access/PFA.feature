@PFA
Feature: Verify PFA functionality

Background: user navigates to Patient Shopper Tool page
Given user is on R1 hub page
When user clicks on facility list
And user select the facility "SJMC - St. John Hospital and Medical Center"

@418873
Scenario: Verify that the user is able to create PFA Screening question answer(Level 1)
Given user is on R1 Access home page
And user clicks on Settings link
And user clicks on PFA Configuration link
And user clicks on PFA Level_1 Questions link
When user clicks on New button
And Input values in the Question Code "D001" and Question "Do you have a coverage" fields
And user clicks on is Active check box
And user clicks Add button
Then PFA Level1 question should be created with message "PFA Questions added successfully"
When user clicks on New Answer button
And user input values in the Answer Code "D001" and Answer Text "YES" fields
And user clicks on Cancel button.
Then PFA answers panel should not be appear
When user clicks on New Answer button
And user input values in the Answer Code "D001" and Answer Text "YES" fields
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
Given User is on R1 Access home page
When user clicks on Patient Access link
And user clicks on R1 detect worklist
When user fetch the encounterid from Query "PFA_419028_SQL10" 
And user clicks on SEARCH link
And enters the encounterid in visit Text field
And user clicks on Search button
And  verify the answer of question Are you pregnant or is the date of service pregnancy related? on L1Screening Questions tab.
Then Default answer  should be No selected appear




