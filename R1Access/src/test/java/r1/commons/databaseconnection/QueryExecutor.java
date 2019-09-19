package r1.commons.databaseconnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import r1.commons.utilities.CommonMethods;

public class QueryExecutor {
	
	
	public static void runQueryTran(String queryName) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, CommonMethods.queryProperties(queryName));
	}
	
	public static void runQueryTran(String queryName, String facility) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), facility);
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, CommonMethods.queryProperties(queryName));
	}
	
	public static void runQueryTranParam(String queryName, String parameter) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.getServerDBName(CommonMethods.LoadProperties("webdriver.base.url"), CommonMethods.LoadProperties("facility"));
		DatabaseConn.serverConn(DatabaseConn.serverName,DatabaseConn.databaseName, String.format(CommonMethods.queryProperties(queryName), parameter));
	}	
	
	public static void runQueryBindAccretive(String queryName, String parameter) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.serverConn(CommonMethods.LoadProperties("bindServer"),"Accretive", String.format(CommonMethods.queryProperties(queryName), parameter));
	}
	
	public static void runQueryBindAccretive(String queryName, String parameter1, String parameter2) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		DatabaseConn.serverConn(CommonMethods.LoadProperties("bindServer"),"Accretive", String.format(CommonMethods.queryProperties(queryName), parameter1,parameter2));
	}
	
}
