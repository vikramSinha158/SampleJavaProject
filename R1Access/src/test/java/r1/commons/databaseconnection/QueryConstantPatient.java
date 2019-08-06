package r1.commons.databaseconnection;

public class QueryConstantPatient {

	public static String queryPatientGurantor() {
		return "Select top 1 encounterid ,SSN ,Admitdate from Registrations where GuarantorID is not null and encounterid is not NULL and SSN is not null and SSN <> '000000200' and SSN <> '000000000' and Phone is not null and ID not in (select RecordKey from RecordCheckOut) order by id desc ";
	}

	public static String queryPatientCheckReturn(String encounterID) {
		return " Select top 1 isadmitted,isdischarged * from registrations where isdischarged = 1 and isadmitted=1 and encounterid='"
				+ encounterID + "'";
	}

	public static String queryPatientforZeroAmmount() {
		return " Select Distinct top 2 r.encounterId, SUM(c.totalCharges) FROM registrations r JOIN charges c ON r.id = c.registrationId GROUP BY r.encounterId HAVING SUM(c.totalCharges) = 0";
	}

	public static String queryPatientforNotZeroAmmount() {
		return "SELECT Distinct top 2 r.encounterId, SUM(c.totalCharges) FROM registrations r JOIN charges c ON r.id = c.registrationId GROUP BY r.encounterId HAVING SUM(c.totalCharges) <>0  ";
	}

	public static String queryPatientGetCricitcalError() {
		return "select top 2 encounterId from registrations where address is null";
	}

	public static String queryPatientGetNonricitcalError() {
		return "select top 2 encounterId from registrations where address is null;";
	}

	public static String queryPatientforGreaterZeroAmmount() {
		return "SELECT distinct top 5 r.encounterId, SUM(c.totalCharges) FROM registrations r JOIN charges c ON r.id = c.registrationId GROUP BY r.encounterId HAVING SUM(c.totalCharges) > 0";
	}

}
