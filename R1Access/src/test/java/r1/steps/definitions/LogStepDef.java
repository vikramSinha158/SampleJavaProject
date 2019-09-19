package r1.steps.definitions;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import r1.commons.BasePage;
import r1.pages.LogPage;

public class LogStepDef extends BasePage {
	
	LogPage logPage;
	
	@Then("^user should able to view label column$")
	public void user_should_able_to_view_label_column(DataTable dt) {
		logPage.verifyLabel(dt);
	}

	@Then("^user should able to view triangle icon with column value sorted on clicking column header$")
	public void user_should_able_to_view_triangle_icon_with_column_value_sorted_on_clicking_column_header(DataTable dt) {
		logPage.verifyColClick(dt);
	}

	@When("^user clicks on \"([^\"]*)\" radio button$")
	public void user_clicks_on_radio_button(String btn) {
		logPage.clickActionType(btn);
	}

	@Then("^user should able to view both \"([^\"]*)\" and \"([^\"]*)\" type log$")
	public void user_should_able_to_view_both_and_type_log(String taskType, String actionType) {
		logPage.verifyActionType(taskType,actionType);
	}

	@Then("^user should able to view all \"([^\"]*)\" type log$")
	public void user_should_able_to_view_all_type_log(String Type) {
		logPage.verifySingleActionType(Type);
	}

	@Then("^user should able to verify a log for last task of performed tasks$")
	public void user_should_able_to_verify_a_log_for_last_task_of_performed_tasks() {
		logPage.verifyActionlog();
	}
}
