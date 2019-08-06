package r1.serenity.steps;

import java.io.IOException;
import java.sql.SQLException;
import net.thucydides.core.annotations.Step;
import r1.commons.databaseconnection.DatabaseConn;
import r1.commons.databaseconnection.QueryConstantPatient;
import r1.commons.utilities.CommonMethods;

public class PatientSteps {
	
	@Step
	public static String getPatientGuranorAccount(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPatient.queryPatientGurantor());
	    DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
	@Step
	public static String getPatientAdmitdateStatus(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName,QueryConstantPatient.queryPatientGurantor());
	    DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	@Step
	public static String getPatientAdmitDischargeDateStatus(String encounterid,String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPatient.queryPatientCheckReturn(encounterid));
	    DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
	@Step
	public static String getPatientCriticalAccounts(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPatient.queryPatientGetCricitcalError());
	    DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	@Step
	public static String getPatientNonCriticalAccounts(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPatient.queryPatientGetNonricitcalError());
	    DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	
	@Step
	public static String getPatientZeroChargelAccounts(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		System.out.println( QueryConstantPatient.queryPatientforZeroAmmount());
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPatient.queryPatientforZeroAmmount());
	    DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	@Step
	public static String getPatientNotZeroChargelAccounts(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPatient.queryPatientforNotZeroAmmount());
	    DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}
	@Step
	public static String getPatientGreaterZeroChargeAccounts(String column) throws IOException, ClassNotFoundException, SQLException{
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, QueryConstantPatient.queryPatientforGreaterZeroAmmount());
	    DatabaseConn.resultSet.next();
		return DatabaseConn.resultSet.getString(column);
	}

}
