@ConfigRule
Feature: ConfigRule

  Background: user navigates to Residual tab 
  Given user is on R1 hub page
  When user clicks on facility list
  And user select the facility
  And user clicks on "Patient Access" link 
  And user clicks on "Pre-Registration" side submenu
 
 @391606
 Scenario: Config-Rule_Verify that end user is able to login into application and can navigate to the worklist
 Given user is able to view Pre-Registration page

 @391608
 Scenario: Config-Rule_Verify User is able to see Configuration Rules tab
 Given user is able to view Pre-Registration page
 When user clicks on any Unassigned Account
 Then user is able to verify and click on Configuration Rules tab
 
 @391610
 Scenario: Config-Rule_Verify details under Primary Authorization Suppression panel
 Given user is able to view Pre-Registration page
 When user clicks on 'Search' tab
 And user search "PAS" account using query
 And user is able to verify and click on Configuration Rules tab
 And user expand Primary Authorization Suppression tool bar
 Then user verify details under 'Log History' grid PAS tab
 And user verify details under 'Field Details' grid PAS tab
 And user verify details under 'Matching Rules' grid PAS tab
 And user set 'Include Partial Matches' checkbox = "True" and verify partial matching table appears PAS tab
 And user set 'Include Partial Matches' checkbox = "False" and verify partial matching table disappears PAS tab
 And user set 'Include Inactive' checkbox = "True" and verify Inactive rules table appears PAS tab
 And user set 'Include Inactive' checkbox = "False" and verify Inactive rules table disappears PAS tab
 And user collapse Primary Authorization Suppression tool bar
 
 @391611
 Scenario: Config_Rule_ Verify details under Primary Coverage Exceptions panel
 Given user is able to view Pre-Registration page
 When user clicks on 'Search' tab
 And user search "PCE" account using query
 And user is able to verify and click on Configuration Rules tab
 And user expand Primary Coverage Exceptions tool bar
 Then user verify details under 'Log History' grid PCE tab
 And user verify details under 'Field Details' grid PCE tab
 And user verify details under 'Matching Rules' grid PCE tab
 And user set 'Include Partial Matches' checkbox = "True" and verify partial matching table appears PCE tab
 And user set 'Include Partial Matches' checkbox = "False" and verify partial matching table disappears PCE tab
 And user set 'Include Inactive' checkbox = "True" and verify Inactive rules table appears PCE tab
 And user set 'Include Inactive' checkbox = "False" and verify Inactive rules table disappears PCE tab
 And user collapse Primary Coverage Exceptions tool bar

@394149 @test
Scenario: Config-Rule_Verify details under Service Automation Rule
 Given user is able to view Pre-Registration page
 When user clicks on 'Search' tab
 And user search "SAR" account using query
 And user is able to verify and click on Configuration Rules tab
 And user expand Service Automation Rules tool bar
 Then And user verify details under 'Field Details' grid SAR tab
 And user verify details under 'Matching Rules' grid SAR tab
 And user set 'Include Partial Matches' checkbox = "True" and verify partial matching table appears SAR tab
 And user set 'Include Partial Matches' checkbox = "False" and verify partial matching table disappears SAR tab
 And user set 'Include Inactive' checkbox = "True" and verify Inactive rules table appears SAR tab
 And user set 'Include Inactive' checkbox = "False" and verify Inactive rules table disappears SAR tab
 And user expand Service Automation Rule tool bar
 
 @391614
 Scenario: Config-Rule_Verify Primary Authorization Suppression and Primary Coverage Exceptions section is only displayed when coverage is complete for a patient
 Given user is able to view Pre-Registration page
 When user clicks on any Unassigned Account
 And user is able to verify and click on Configuration Rules tab
 And user clicks on "Coverage" moduleTab
 And user click on Redo button
 Then user verify Coverage Section
 And user delete existing coverage
 And user is able to verify and click on Configuration Rules tab
 And user verify 'Primary Authorization Suppression' and 'Primary Coverage Exceptions' tab visible "False"
 And user clicks on "Coverage" moduleTab
 And user clicks on "Complete" button
 And user is able to verify and click on Configuration Rules tab
 And user verify 'Primary Authorization Suppression' and 'Primary Coverage Exceptions' tab visible "True"