Feature: Verify the functionality of Service2.0

Background: User should be able to navigate on Account Worklist Grid

 Given user is on R1 hub page
 When user clicks on facility list
 And user select the facility "SCFL - St Vincents Medical Center Clay County"
 And user clicks on Patient Access link
 And user clicks on Pre-Registration
 Then user should be able to view Account Worklist Grid
   
 @391638 @391835 @391837 @391648
 Scenario: Verify Radio Buttons for Single and multiple pricing modes
 When user clicks on any Unassigned Account 
 And user clicked on "Services" tab
 Then verify the fields before checkout
 When user clicked on checkout button
 And user clicked on Admitting if exists
 Then verify the fields after the checkout
 When user enter services like "Skin" in search field
 Then searched result should be shown in service pane
 And verify radio buttons
 When user add services
 Then verify service should be added
 When user delete added services
 Then service search result grid will not be displayed
 When user clicks on "Release" btn
 Then single multiple radio buttons of pricing will not be displayed