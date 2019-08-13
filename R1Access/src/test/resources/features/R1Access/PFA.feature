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
And user clicks on PFA Level 1 Questions link.
When user clicks on New button
And Input values in the "Question Code" and "Question" fields
And user clicks on is Active check box
And user clicks on Add button
Then PFA Level1 question should be created with message "Question gets created successfully"
When user clicks on New Answer button
And user input values in the "Answer Code" and "Answer Text" fields
And user clicks on Cancel button.
Then PFA answers panel should not be appear
When user clicks on New Answer button
And user input values in the "Answer Code" and "Answer Text" fields
And user clicks on is active check box
And user clicks on Add Answer button.
Then new answer should be added in the answers grid with message "PFA Answer added successfully"
When user clicks on Link Answer button
And user clicks on Cancel button.
Then Answer dropdown list, Link New Answer button and Cancel button should not be appear.
When user clicks on Link Answer button
And user select an created answer from dropdown
And user clicks on Link new Answer button.
Then displays added answer in the answers grid placed under Update button 
And message answer added for the question successfully appear
When user clicks on Unlink Answer button
And user select an answer from dropdown 
And user clicks on Unlink Existing Answer button.
Then message answer unlinked successfully appear for the question should be appear
And answer should not be appear in answer grid under Update button

@418874
Scenario: Verify funding source is triggered correctly when PFA Funding Sources rule and their criteria are Added/Deleted based on Level 1 question answer
Given user is on R1 Access home page
And user clicks on Settings link
And user clicks on PFA Configuration link
And user clicks on PFA Funding Source Rules link
When user open an funding source from worklist
And user clicks on Add Rule button 
And user clicks on Cancel button.
Then Add New Rule panel should get disappear
When user open an funding source from worklist
And user clicks on Add Rule button 
And user input values in Rule name text field.
And user check the Active Check box 
And user clicks on save button
Then if rule name Exists Displays Message PFA Rule with the same name already exists!
And if Rule name does not exists, New Rule should be added 
And displays message PFA Rule added successfully
When user clicks on add criteria button 
And user clicks on Cancel button.
Then Add New Criteria panel get disappear
When user clicks on add criteria button 
And user select name from Name dropdown 
And user select value from Operator dropdown 
And user select value from value dropdown 
And user clicks on save button
Then Criteria should be added in Rules grid with the message "Business Rule Criteria added successfully"
When user clicks on patient access link 
And user clicks on R1 detect worklist
And user open an account from R1 detect worklist 
And user clicks on "Check Out" button
And Select all the question answer according to created Rule/Criteria 
And user clicks on Save and Continue button
Then user navigate to Screening Needs(L2) screen And funding source should be configured appear according to created rule
When user clicks on Settings link 
And user clicks on PFA Configuration link
And user clicks on PFA Funding Source Rules link
And user open the funding source where created the new rule on PFA funding source rules tab. 
And user clicks on delete button.
Then criteria should be disappeared with message Criteria Deleted successfully
When user clicks on patient access link 
And user clicks on R1 detect worklist
And user open an account from R1 detect worklist 
And user clicks on "Check Out" button 
And select all the question answer according to deleted criteria from rule
And user clicks on Save and Continue button
Then user navigate to Screening Needs(L2) screen And funding source should not be configured appear according to created rule.
When user clicks on Settings link 
And user clicks on PFA Configuration link
And user clicks on PFA Funding Source Rules link
And user open the funding source where created the new rule on PFA funding source rules tab. 
And user clicks on Delete Rule button.
Then Rule should be disappeared with message Rule deactivated successfully
When user clicks on patient access link 
And user clicks on R1 detect worklist
And user open an account from R1 detect worklist 
And user clicks on "Check Out" button 
And Select all the question answer according to deleted rule
And user clicks on Save and Continue button
Then user navigate to Screening Needs(L2) screen And funding source should not be configured appear according to delete rule.


