package r1.steps.definitions;

import java.io.IOException;
import java.sql.SQLException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.pages.Navigation;
import r1.pages.NotesPage;
import r1.pages.PatientPage;
import r1.pages.UserLogin;
import r1.serenity.steps.NotesSteps;
import r1.commons.BasePage;
import r1.commons.R1AccessCommonMethods;
import r1.commons.databaseconnection.QueryConstants;
import r1.commons.utilities.CommonMethods;

public class PatientPASupervisorRole extends BasePage {
	R1AccessCommonMethods r1AccessCommonMethod;
	PatientPage patientPage;
	Navigation navigation;
	String userName;
	
	@When("^user clicks on Setting link$")
	public void user_clicks_on_Setting_link() {
		r1AccessCommonMethod.clickFooterR1AccesModulesTab("Settings");
	}
	@When("^user clicks on user managment of IT Tools$")
	public void user_clicks_on_user_managment_of_IT_Tools() {
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("IT Tools");
	}
	@When("^user clicks on ARSupervisor CheckBoxs$")
	public void user_clicks_on_ARSupervisor_CheckBoxs() throws InterruptedException, IOException {

		userName = CommonMethods.LoadProperties("username").trim();
		r1AccessCommonMethod.setUserRoles("Username", userName, "PA Supervisor", true);
	}
	@When("^user run the query and fetch the encounteridForEqualZero$")
	public void user_run_the_query_and_fetch_the_encounteridForEqualZero() 
			throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		r1AccessCommonMethod.clickFooterR1AccesModulesTab("Settings");
		navigation.clickFacilityList();
		navigation.selectFacility("SJMA - St. John Macomb-Oakland Hospital");
		r1AccessCommonMethod.clickR1HubModulesMenuLink("Patient Access");
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("Pre-Registration");
		patientPage.getPatientAccountGetChargeZero();
	}
	@Then("^user should be able to view cancelled checkbox in disableState mode$")
	public void user_should_be_able_to_view_cancelled_checkbox_in_disableState_mode() {
		patientPage.VerifyCancelCheckBox();
	}	
	@When("^user run the query and fetch the encounteridForNotEqualZero$")
	public void user_run_the_query_and_fetch_the_encounteridForNotEqualZero()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		r1AccessCommonMethod.clickFooterR1AccesModulesTab("Settings");
		navigation.clickFacilityList();
		navigation.selectFacility("SJMA - St. John Macomb-Oakland Hospital");
		r1AccessCommonMethod.clickR1HubModulesMenuLink("Patient Access");
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("Pre-Registration");
		patientPage.getPatientAccountGetChargeNotZero();
	}
	@When("^user enter encounterid in search textbox(\\d+)$")
	public void user_enter_encounterid_in_search_textbox(int arg1) {
		patientPage.entersSearchText();
	}
	@When("^user clicks on ARSupervisor CheckBoxs for disable Role$")
	public void user_clicks_on_ARSupervisor_CheckBoxs_for_disable_Role() throws InterruptedException, IOException {
		userName = CommonMethods.LoadProperties("username").trim();
		r1AccessCommonMethod.setUserRoles("Username", userName, "PA Supervisor", false);
	}
	@When("^user run the query and fetch the encounteridForDisable$")
	public void user_run_the_query_and_fetch_the_encounteridForDisable()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		r1AccessCommonMethod.clickFooterR1AccesModulesTab("Settings");
		navigation.clickFacilityList();
		navigation.selectFacility("SJMA - St. John Macomb-Oakland Hospital");
		r1AccessCommonMethod.clickR1HubModulesMenuLink("Patient Access");
		r1AccessCommonMethod.clickSubSideR1HubModulesMenuLink("Pre-Registration");
		patientPage.getPatientAccountGetChargeGreaterZero();
	}
}
